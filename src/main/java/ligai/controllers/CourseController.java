package ligai.controllers;

import ligai.enums.QuestionType;
import ligai.models.*;
import ligai.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/android")
public class CourseController {
    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private ThemeRepository themeRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QSelectOutOfFourRepository qSelectOutOfFourRepository;

    @Autowired
    private LessonProgressRepository lessonProgressRepository;

    @Autowired
    UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/greeting")
    public QSelectOutOfFour greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        long id = 2;
        return qSelectOutOfFourRepository.findFirstById(id).orElse(null);
    }

    @GetMapping("/greeting/save")
    public QSelectOutOfFour saveRandom() {
        QSelectOutOfFour qSelectOutOfFour = QSelectOutOfFour.qSelectOutOfFourBuilder()
                .task("Как перевести на английский слово 'Лиса'?")
                .lesson(null)
                .questionType(QuestionType.ONE_OUT_OF_FOUR)
                .answerString("1")
                .variant1("FOX")
                .variant2("DOG")
                .variant3("CAT")
                .variant4("DUCK")
                .build();

        qSelectOutOfFourRepository.save(qSelectOutOfFour);
        return qSelectOutOfFour;
    }


    @GetMapping("/andLogin")
    public User authUserByCredentials(@RequestParam(value = "login") String login,
                                      @RequestParam(value = "hashPassword") String pass) {
        Optional<User> result = usersRepository.findFirstByLogin(login);

        if (result.isPresent()) {
            if (passwordEncoder.matches(pass, result.get().getHashPassword())) {
                return result.get();
            }
        }
        throw new IllegalArgumentException("Login or password incorrect");
    }
}

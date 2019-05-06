package ligai.controllers;

import ligai.enums.ProgressStatus;
import ligai.enums.QuestionType;
import ligai.models.*;
import ligai.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RESTControllerExample {
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

    @RequestMapping("/greeting")
    public QSelectOutOfFour greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
                             @RequestParam(value = "elf", required = false, defaultValue = "World") String sloan) {

        long id = 1;
        return qSelectOutOfFourRepository.findOne(id);
    }

    @Autowired
    UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @RequestMapping(value = "/android/andrLogin", method = RequestMethod.GET)
    public User authUserByCredentials(@RequestParam(value = "login", required = true) String login,
                                      @RequestParam(value = "pass", required = true) String pass) {

        Optional<User> result = usersRepository.findFirstByLogin(login);
        // System.out.println(passwordEncoder.matches(pass, result.get().getPass()));
        //System.out.println("I was here");
        if (result.isPresent()) {

            //System.out.println(result.get().getPass() + "___");
            if (passwordEncoder.matches(pass, result.get().getPass())) {
                return result.get();
            } else return null;
        } else return null;
    }
}

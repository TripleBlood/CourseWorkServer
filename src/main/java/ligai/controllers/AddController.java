package ligai.controllers;

import ligai.enums.QuestionType;
import ligai.models.Course;
import ligai.models.Lesson;
import ligai.models.QSelectOutOfFour;
import ligai.models.Theme;
import ligai.repositories.CoursesRepository;
import ligai.repositories.LessonRepository;
import ligai.repositories.QSelectOutOfFourRepository;
import ligai.repositories.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/save")
public class AddController {

    @Autowired
    CoursesRepository coursesRepository;
    @Autowired
    ThemeRepository themeRepository;
    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    QSelectOutOfFourRepository qSelectOutOfFourRepository;

    @GetMapping("/qSelectOutOfFour")
    public QSelectOutOfFour saveQSelectOutOfFour(
            @RequestParam String task,
            @RequestParam String answerString,
            @RequestParam String variant1,
            @RequestParam String variant2,
            @RequestParam String variant3,
            @RequestParam String variant4,
            @RequestParam String lessonName) {

        Optional<Lesson> lesson = lessonRepository.findFirstByName(lessonName);

        if (lesson.isPresent()) {
            QSelectOutOfFour qSelectOutOfFour = QSelectOutOfFour.qSelectOutOfFourBuilder()
                    .task(task)
                    .lesson(lesson.get())
                    .questionType(QuestionType.ONE_OUT_OF_FOUR)
                    .answerString(answerString)
                    .variant1(variant1)
                    .variant2(variant2)
                    .variant3(variant3)
                    .variant4(variant4)
                    .build();

            qSelectOutOfFourRepository.save(qSelectOutOfFour);
            return qSelectOutOfFour;
        }
        return null;
    }

    @GetMapping("/lesson")
    public Lesson saveLesson(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam(name = "theme-name") String themeName) {

        Optional<Theme> theme = themeRepository.findFirstByName(themeName);

        if (theme.isPresent()) {
            Lesson lesson = Lesson.builder()
                    .name(name)
                    .description(description)
                    .theme(theme.get())
                    .build();

            lessonRepository.save(lesson);
            return lesson;
        }
        return null;
    }

    @GetMapping("/theme")
    public Theme saveTheme(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam(name = "course-name") String courseName) {

        Optional<Course> course = coursesRepository.findFirstByName(courseName);

        if (course.isPresent()) {
            Theme theme = Theme.builder()
                    .name(name)
                    .description(description)
                    .course(course.get())
                    .build();

            themeRepository.save(theme);
            return theme;
        }
        return null;
    }

    @GetMapping("/course")
    public Course saveCourse(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam String author) {
        Course course = Course.builder()
                .name(name)
                .description(description)
                .author(author)
                .build();

        coursesRepository.save(course);
        return course;
    }
}

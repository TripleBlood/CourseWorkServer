package ligai.controllers;

import ligai.enums.QuestionType;
import ligai.models.*;
import ligai.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Контроллер, обрабатывающий все запросы на создание экземляров сущностей
 */
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
    @Autowired
    QSelectOutOfFourPicRepository qSelectOutOfFourPicRepository;
    @Autowired
    QAwayFromSequenceRepository qAwayFromSequenceRepository;
    @Autowired
    QGroupsRepository qGroupsRepository;
    @Autowired
    QPairsRepository qPairsRepository;


    // TODO: normal Post-method adding!!!

    /**
     * Saves new element to QSelectOutOfFourRepository
     *
     * @param answerString has the appearance "123" where numbers are correct variants number
     * @return
     */
    @GetMapping("/q-select-one-out-of-four")
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

    /**
     * Saves new element to QSelectOutOfFourPicRepository
     *
     * @param answerString has the appearance "123" where numbers are correct variants number
     * @return
     */
    @GetMapping("/q-select-one-out-of-four-pic")
    public QSelectOutOfFourPic saveQSelectOutOfFourPic(
            @RequestParam String task,
            @RequestParam String answerString,
            @RequestParam String variant1,
            @RequestParam String variant2,
            @RequestParam String variant3,
            @RequestParam String variant4,
            @RequestParam String pictureUrl1,
            @RequestParam String pictureUrl2,
            @RequestParam String pictureUrl3,
            @RequestParam String pictureUrl4,
            @RequestParam String lessonName) {

        Optional<Lesson> lesson = lessonRepository.findFirstByName(lessonName);

        if (lesson.isPresent()) {
            QSelectOutOfFourPic qSelectOutOfFourPic = QSelectOutOfFourPic.qSelectOutOfFourPicBuilder()
                    .task(task)
                    .lesson(lesson.get())
                    .questionType(QuestionType.ONE_OUT_OF_FOUR_PIC)
                    .answerString(answerString)
                    .variant1(variant1)
                    .variant2(variant2)
                    .variant3(variant3)
                    .variant4(variant4)
                    .pictureUrl1(pictureUrl1)
                    .pictureUrl2(pictureUrl2)
                    .pictureUrl3(pictureUrl3)
                    .pictureUrl4(pictureUrl4)
                    .build();

            qSelectOutOfFourPicRepository.save(qSelectOutOfFourPic);
            return qSelectOutOfFourPic;
        }
        return null;
    }

    /**
     * Saves new element to QSelectOutOfFourRepository
     *
     * @param answerString has the appearance "123" where numbers are correct variants number
     * @return
     */
    @GetMapping("/q-select-multiple-out-of-four")
    public QSelectOutOfFour saveQSelectMultipleOutOfFour(
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
                    .questionType(QuestionType.MULTIPLE_OUT_OF_FOUR)
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

    /**
     * Saves new element to QSelectOutOfFourPicRepository
     *
     * @param answerString has the appearance "123" where numbers are correct variants number
     * @return
     */
    @GetMapping("/q-select-multiple-out-of-four-pic")
    public QSelectOutOfFourPic saveQSelectMultipleOutOfFourPic(
            @RequestParam String task,
            @RequestParam String answerString,
            @RequestParam String variant1,
            @RequestParam String variant2,
            @RequestParam String variant3,
            @RequestParam String variant4,
            @RequestParam String pictureUrl1,
            @RequestParam String pictureUrl2,
            @RequestParam String pictureUrl3,
            @RequestParam String pictureUrl4,
            @RequestParam String lessonName) {

        Optional<Lesson> lesson = lessonRepository.findFirstByName(lessonName);

        if (lesson.isPresent()) {
            QSelectOutOfFourPic qSelectOutOfFourPic = QSelectOutOfFourPic.qSelectOutOfFourPicBuilder()
                    .task(task)
                    .lesson(lesson.get())
                    .questionType(QuestionType.MULTIPLE_OUT_OF_FOUR_PIC)
                    .answerString(answerString)
                    .variant1(variant1)
                    .variant2(variant2)
                    .variant3(variant3)
                    .variant4(variant4)
                    .pictureUrl1(pictureUrl1)
                    .pictureUrl2(pictureUrl2)
                    .pictureUrl3(pictureUrl3)
                    .pictureUrl4(pictureUrl4)
                    .build();

            qSelectOutOfFourPicRepository.save(qSelectOutOfFourPic);
            return qSelectOutOfFourPic;
        }
        return null;
    }

    //TODO: complete documentation

    /**
     * Saves new element to QAwayFromSequenceRepository
     *
     * @param answerString has the appearance "1#2#3" where numbers of blocks that should be out of sequence
     * @param mainSequence had the appearance "block0#block1#block2#block3#block4"
     * @return
     */
    @GetMapping("/q-away-from-sequence")
    public QAwayFromSequence saveQAwayFromSequence(@RequestParam String lessonName,
                                                   @RequestParam String task,
                                                   @RequestParam String answerString,
                                                       @RequestParam String mainSequence) {
        Optional<Lesson> lesson = lessonRepository.findFirstByName(lessonName);

        if (lesson.isPresent()) {
            QAwayFromSequence qAwayFromSequence = QAwayFromSequence.qAwayFromSequenceBuilder()
                    .task(task)
                    .lesson(lesson.get())
                    .questionType(QuestionType.SEQUENCE_OUT)
                    .answerString(answerString)
                    .mainSequence(mainSequence)
                    .build();
            qAwayFromSequenceRepository.save(qAwayFromSequence);
            return qAwayFromSequence;
        }
        return null;
    }

    @GetMapping("/q-groups")
    public QGroups saveQGroups(@RequestParam String task,
                               @RequestParam String lessonName,
                               @RequestParam String answerString,
                               @RequestParam(name = "a-group-name") String a_group_name,
                               @RequestParam(name = "b-group-name") String b_group_name,
                               @RequestParam String variant1,
                               @RequestParam String variant2,
                               @RequestParam String variant3,
                               @RequestParam String variant4) {
        Optional<Lesson> lesson = lessonRepository.findFirstByName(lessonName);

        if (lesson.isPresent()) {
            QGroups qGroup = new QGroups().qGroupsBuilder()
                    .task(task)
                    .lesson(lesson.get())
                    .questionType(QuestionType.GROUP)
                    .answerString(answerString)
                    .a_group_name(a_group_name)
                    .b_group_name(b_group_name)
                    .variant1(variant1)
                    .variant2(variant2)
                    .variant3(variant3)
                    .variant4(variant4)
                    .build();
            qGroupsRepository.save(qGroup);
            return qGroup;
        }
        return null;
    }

    @GetMapping("/q-pairs")
    public QPairs saveQPairs(@RequestParam String task,
                             @RequestParam String lessonName,
                             @RequestParam String answerString,
                             @RequestParam String variant1,
                             @RequestParam String variant2,
                             @RequestParam String variant3,
                             @RequestParam String variant4,
                             @RequestParam String pair1,
                             @RequestParam String pair2,
                             @RequestParam String pair3,
                             @RequestParam String pair4) {
        Optional<Lesson> lesson = lessonRepository.findFirstByName(lessonName);

        if (lesson.isPresent()) {
            QPairs qPair = new QPairs().qPairsBuilder()
                    .task(task)
                    .lesson(lesson.get())
                    .questionType(QuestionType.PAIRS)
                    .answerString(answerString)
                    .variant1(variant1)
                    .variant2(variant2)
                    .variant3(variant3)
                    .variant4(variant4)
                    .pair1(pair1)
                    .pair2(pair2)
                    .pair3(pair3)
                    .pair4(pair4)
                    .build();
            qPairsRepository.save(qPair);
            return qPair;
        }
        return null;
    }

    @GetMapping("/q-pairs-pic")
    public QPairs saveQPairsPic(@RequestParam String task,
                                @RequestParam String lessonName,
                                @RequestParam String answerString,
                                @RequestParam String variant1,
                                @RequestParam String variant2,
                                @RequestParam String variant3,
                                @RequestParam String variant4,
                                @RequestParam String pic1,
                                @RequestParam String pic2,
                                @RequestParam String pic3,
                                @RequestParam String pic4) {
        Optional<Lesson> lesson = lessonRepository.findFirstByName(lessonName);

        if (lesson.isPresent()) {
            QPairs qPair = new QPairs().qPairsBuilder()
                    .task(task)
                    .lesson(lesson.get())
                    .questionType(QuestionType.PAIRS_PIC)
                    .answerString(answerString)
                    .variant1(variant1)
                    .variant2(variant2)
                    .variant3(variant3)
                    .variant4(variant4)
                    .pair1(pic1)
                    .pair2(pic2)
                    .pair3(pic3)
                    .pair4(pic4)
                    .build();
            qPairsRepository.save(qPair);
            return qPair;
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

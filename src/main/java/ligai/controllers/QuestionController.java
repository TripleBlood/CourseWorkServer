package ligai.controllers;

import ligai.models.Lesson;
import ligai.models.QPairs;
import ligai.models.Question;
import ligai.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QSelectOutOfFourRepository qSelectOutOfFourRepository;
    @Autowired
    QPairsRepository qPairsRepository;
    @Autowired
    QGroupsRepository qGroupsRepository;
    @Autowired
    QSequenceUpdateRepository qSequenceUpdateRepository;
    @Autowired
    QAwayFromSequenceRepository qAwayFromSequenceRepository;

    @Autowired
    LessonRepository lessonRepository;


    @GetMapping("/by-lesson")
    public List findAllQuestionsByLesson(@RequestParam(name = "name") String lessonName){
        Optional<Lesson> lesson = lessonRepository.findFirstByName(lessonName);

        if (lesson.isPresent()){
            Optional<ArrayList<Question>> questions = questionRepository.findAllByLesson(lesson.get());

            if (questions.isPresent()){
                List<Question> questionArrayList = questions.get();

                List finalList = new ArrayList();

                //TODO Pictures!!!
                for (Question question : questionArrayList){
                    switch (question.getQuestionType()){
                        case ONE_OUT_OF_FOUR:
                        case MULTIPLE_OUT_OF_FOUR:
                            finalList.add(qSelectOutOfFourRepository.findFirstById(question.getId()).get());
                            break;
                        case PAIRS:
                            finalList.add(qPairsRepository.findFirstById(question.getId()));
                            break;
                        case GROUP:
                            finalList.add(qGroupsRepository.findFirstById(question.getId()));
                        case SEQUENCE_INCERT_NOGAPS:
                        case SEQUENCE_PRINT:
                        case SEQUENCE_INCERT:
                        case SEQUENCE:
                            finalList.add(qSequenceUpdateRepository.findFirstById(question.getId()));
                            break;
                        case SEQUENCE_OUT:
                            finalList.add(qAwayFromSequenceRepository.findFirstById(question.getId()));
                            break;
                        case TEXT:
                            finalList.add(question);
                            break;
                    }
                }
                System.out.println(finalList);
                return finalList;
            }
        }
        return null;
    }
}

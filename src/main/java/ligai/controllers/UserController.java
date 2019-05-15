package ligai.controllers;

import ligai.enums.ProgressStatus;
import ligai.models.Course;
import ligai.models.Lesson;
import ligai.models.LessonProgress;
import ligai.models.User;
import ligai.repositories.CoursesRepository;
import ligai.repositories.LessonProgressRepository;
import ligai.repositories.LessonRepository;
import ligai.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    CoursesRepository coursesRepository;
    @Autowired
    LessonRepository lessonRepository;
    @Autowired
    LessonProgressRepository lessonProgressRepository;

    @GetMapping("/get-user")
    public User getUserByLogin(@RequestParam String login){
        Optional<User> user = usersRepository.findFirstByLogin(login);
        if (user.isPresent()){
            return user.get();
        } else return null;
    }

    @GetMapping("/get-all-users")
    public List<User> getAllUsers(){
        List<User> users = usersRepository.findAll();
        return users;
    }

    @GetMapping("/assign-student")
    public void assignUserToCourse(@RequestParam String login,
                                   @RequestParam(name = "course-name") String courseName){
        Optional<User> user = usersRepository.findFirstByLogin(login);
        Optional<Course> course = coursesRepository.findFirstByName(courseName);

        if (user.isPresent() && course.isPresent()){
            user.get().getCourses().add(course.get());
            usersRepository.save(user.get());
        }
    }

    @GetMapping("/user-completed-lesson")
    public void userCompletedLesson(@RequestParam String login,
                                    @RequestParam String lesson){
        Optional<LessonProgress> lessonProgress = lessonProgressRepository.findFirstByUser_LoginAndLesson_Name(login, lesson);

        if (lessonProgress.isPresent()){
            lessonProgress.get().setProgressStatus(ProgressStatus.DONE);
            lessonProgressRepository.save(lessonProgress.get());
            return;
        }

        Optional<User> user = usersRepository.findFirstByLogin(login);
        Optional<Lesson> lessonRes = lessonRepository.findFirstByName(lesson);
        if (user.isPresent() && lessonRes.isPresent()){
            LessonProgress lessonProgress1 = new LessonProgress().builder().lesson(lessonRes.get()).user(user.get()).progressStatus(ProgressStatus.DONE).build();
            lessonProgressRepository.save(lessonProgress1);
        }
    }
}

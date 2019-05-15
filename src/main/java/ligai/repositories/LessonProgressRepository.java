package ligai.repositories;

import ligai.models.Lesson;
import ligai.models.LessonProgress;
import ligai.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LessonProgressRepository extends JpaRepository<LessonProgress, Long> {
    public Optional<LessonProgress> findFirstByUserAndAndLesson(User user, Lesson lesson);

    public Optional<LessonProgress> findFirstByUser_LoginAndLesson_Name(String login, String lessonName);

}

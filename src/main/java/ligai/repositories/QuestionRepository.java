package ligai.repositories;

import ligai.models.Lesson;
import ligai.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findAllByLesson(Lesson lesson);
}

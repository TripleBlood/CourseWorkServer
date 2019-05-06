package ligai.repositories;

import ligai.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Course, Long> {

}

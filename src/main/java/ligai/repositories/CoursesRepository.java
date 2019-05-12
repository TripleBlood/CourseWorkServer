package ligai.repositories;

import ligai.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoursesRepository extends JpaRepository<Course, Long> {
    Optional<Course> findFirstByName(String name);

}

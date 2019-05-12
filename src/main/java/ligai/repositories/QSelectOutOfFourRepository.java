package ligai.repositories;

import ligai.models.QSelectOutOfFour;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface QSelectOutOfFourRepository extends JpaRepository<QSelectOutOfFour, Long> {
    Optional<QSelectOutOfFour> findFirstById(Long id);


}

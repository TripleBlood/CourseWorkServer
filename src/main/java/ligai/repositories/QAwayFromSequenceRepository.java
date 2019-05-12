package ligai.repositories;

import ligai.models.QAwayFromSequence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QAwayFromSequenceRepository extends JpaRepository<QAwayFromSequence, Long> {
    Optional<QAwayFromSequence> findFirstById(Long id);
}

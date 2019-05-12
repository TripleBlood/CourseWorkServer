package ligai.repositories;

import ligai.models.QSequenceUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QSequenceUpdateRepository extends JpaRepository<QSequenceUpdate, Long> {
    Optional<QSequenceUpdate> findFirstById(Long id);
}

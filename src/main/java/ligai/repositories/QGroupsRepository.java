package ligai.repositories;

import ligai.models.QGroups;
import ligai.models.QPairs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QGroupsRepository extends JpaRepository<QGroups, Long> {
    Optional<QGroups> findFirstById(Long id);
}

package ligai.repositories;

import ligai.models.QPairs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QPairsRepository extends JpaRepository<QPairs, Long> {
    Optional<QPairs> findFirstById(Long id);
}

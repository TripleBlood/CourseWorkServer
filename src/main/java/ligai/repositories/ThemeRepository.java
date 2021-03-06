package ligai.repositories;

import ligai.models.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
    Optional<Theme> findOneById(Long id);
    Optional<Theme> findFirstByName(String name);
}

package ligai.services;

import org.springframework.security.core.Authentication;
import ligai.models.User;

public interface AuthenticationService {
    User getUserByAuthentication(Authentication authentication);
}

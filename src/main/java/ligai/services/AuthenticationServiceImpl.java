package ligai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ligai.models.User;
import ligai.repositories.UsersRepository;
import ligai.security.details.UserDetailsImpl;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public User getUserByAuthentication(Authentication authentication) {
        UserDetailsImpl currentUserDetails = (UserDetailsImpl)authentication.getPrincipal();
        User currentUserModel = currentUserDetails.getUser();
        Long currentUserId = currentUserModel.getId();
        return usersRepository.findOne(currentUserId);
    }
}

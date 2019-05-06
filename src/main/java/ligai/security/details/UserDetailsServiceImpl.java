package ligai.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ligai.models.User;
import ligai.repositories.UsersRepository;

/* UserDetailsService - интерфейс, который позволяет
получить объект авторизации по userName
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = usersRepository.findFirstByLogin(login).orElseThrow(()
                -> new IllegalArgumentException("User not found by login <" + login + ">"));
        // создаем объект UserDetails
        // кладем туда пользователя
        return new UserDetailsImpl(user);
    }
}

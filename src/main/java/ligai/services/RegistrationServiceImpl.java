package ligai.services;

import ligai.repositories.UsersRepository;
import ligai.security.role.Role;
import ligai.security.state.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ligai.forms.UserRegistrationForm;
import ligai.models.User;


@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void register(UserRegistrationForm userForm) {
        // создаем нового пользователя для БД с ролью USER
        if( usersRepository.findFirstByLogin(userForm.getLogin()).isPresent()){
            throw new IllegalArgumentException("User already exists");
        }

        User newUser = User.builder()
                .login(userForm.getLogin())
                .hashPassword(passwordEncoder.encode(userForm.getPassword()))
                .role(Role.USER)
                .state(State.CONFIRMED)
                .build();

        // сохраняем пользователя
        usersRepository.save(newUser);
    }
}

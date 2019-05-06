package ligai.services;

import ligai.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ligai.forms.UserRegistrationForm;
import ligai.models.User;
import ligai.repositories.UsersRepository;
import ligai.security.role.Role;
import ligai.security.states.State;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void register(UserRegistrationForm userForm) {
        // создаем нового пользователя для БД с ролью USER
        User newUser = User.builder()
                .login(userForm.getLogin())
                .pass(passwordEncoder.encode(userForm.getPass()))
                .role(Role.USER)
                .state(State.CONFIRMED)
                .build();

        // сохраняем пользователя
        usersRepository.save(newUser);
    }
}

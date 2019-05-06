package ligai.security.providers;

import ligai.models.User;
import ligai.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // метод аутентификации
    // получает на вход аутентификационные данные
    // пользователя
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // получаем имя пользователя
        String username = authentication.getName();
        // получаем пароль
        String pass = authentication.getCredentials().toString();

        // находите пользователя по логину
        Optional<User> userOptional = usersRepository.findFirstByLogin(username);
        // если пользователь найден
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // если пароль пользователя не совпал с тем, который ввели
            if (!passwordEncoder.matches(pass, user.getPass())) {
                // проверяем, может заходит админ?
                //if (passwordEncoder.matches(password, user.getHashTempPassword())) {
                    // если все нормально - обнуляем этот временный пароль пользователю
                //    user.setHashTempPassword(null);
                    // сохраняем уже без пароля
                //    usersRepository.save(user);
                //} else {
                    throw new BadCredentialsException("Wrong password or login");
                //}
            }
        } else {
            throw new BadCredentialsException("Wrong password or login");
        }

        // сюда попадем, если заходит либо пользователь с нормальным паролем
        // либо админ с временным

        // загружаем details пользователя по имени
        UserDetails details = userDetailsService.loadUserByUsername(username);
        // получаем его права ADMIN либо USER
        Collection<? extends GrantedAuthority> authorities = details.getAuthorities();
        // возвращаем созданную аутентификацию дальше
        return new UsernamePasswordAuthenticationToken(details, pass, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}

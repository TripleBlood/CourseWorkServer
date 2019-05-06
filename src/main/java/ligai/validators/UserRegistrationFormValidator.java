package ligai.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ligai.forms.UserRegistrationForm;
import ligai.models.User;
import ligai.repositories.UsersRepository;

import java.util.Optional;


@Component
public class UserRegistrationFormValidator implements Validator {
    // подключаем БД с людьми
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.getName().equals(UserRegistrationForm.class.getName());
    }

    // Валидируем объект target
    @Override
    public void validate(Object target, Errors errors) {
        // Валидатору приходит все подряд
        // Мы преобразуем входные данные в UserRegistrationForm
        UserRegistrationForm form = (UserRegistrationForm)target;

        // получили/не получили пользователя
        Optional<User> existedUser = usersRepository.findFirstByLogin(form.getLogin());
        // если пользователь есть
        if (existedUser.isPresent()) {
            errors.reject("bad.login", "Логин занят!");
        }
        // проверяем на пустоту логин или пароль
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "empty.login", "Пустой логин");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass", "empty.pass", "Пустой пароль");

    }
}

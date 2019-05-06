package ligai.controllers;

import ligai.forms.UserRegistrationForm;
import ligai.repositories.UsersRepository;
import ligai.services.RegistrationService;
import ligai.validators.UserRegistrationFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserRegistrationFormValidator userRegistrationFormValidator;

    @InitBinder("userForm")
    public void initUserFormValidator(WebDataBinder binder) {
        binder.addValidators(userRegistrationFormValidator);
    }

    @GetMapping(value = "/signUp")
    public String getSignUpPage() {
        return "sign_up";
    }

    @PostMapping(value = "/signUp")
    public String signUp(@Valid @ModelAttribute("userForm") UserRegistrationForm userRegistrationForm,
                         BindingResult errors, RedirectAttributes attributes) {
        // если есть ошибки - например, логин занят
        if (errors.hasErrors()) {
            // кладем специальный атрибут error
            attributes.addFlashAttribute("error", errors.getAllErrors().get(0).getDefaultMessage());
            // перенаправляем пользователя снова на эту же страницу
            // но у же с атрибутом ошибки
            return "redirect:/signUp";
        }

        System.out.println(userRegistrationForm.getLogin() + " " + userRegistrationForm.getPass());
        // вызывается сервис, который регистрирует пользователя
        service.register(userRegistrationForm);
        // вернули страницу, где написано "Вы успешно зарегистрировались"
        return "sign_up";
    }
}

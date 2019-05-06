package ligai.controllers;

import ligai.forms.UserRegistrationForm;
import ligai.repositories.UsersRepository;
import ligai.services.RegistrationService;
import ligai.validators.UserRegistrationFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RestController
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

    @PostMapping(value = "/sing-up")
    public Object signUp(@Valid @RequestBody UserRegistrationForm userRegistrationForm,
                         BindingResult errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(403).body(errors.getAllErrors().get(0).getDefaultMessage());
        }
        try {
            service.register(userRegistrationForm);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(403).body(e.getMessage());

        }
        return ResponseEntity.ok("Success");
    }
}

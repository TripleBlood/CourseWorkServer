package ligai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import ligai.models.User;
import ligai.security.role.Role;
import ligai.services.AuthenticationService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


@Controller
public class AuthController {

    @Autowired
    private AuthenticationService service;

    // если хотим получить страницу для логина
    @GetMapping("/login")
    public String login(@ModelAttribute("model") ModelMap model, Authentication authentication,
                        @RequestParam Optional<String> error) {
        // если аутентификация ненулевая - кидаем на корень сайта
        if (authentication != null) {
            return "redirect:/";
        }
        // если аутентификации нет, или была ошибка
//      // кладем на страницу ошибку
        model.addAttribute("error", error);
        // и опять возвращает страницу логин
        return "login";
    }

    // если делаем /logout
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Authentication authentication) {
        // если аутентификация была
        if (authentication != null) {
            // вырубаем сессию
            request.getSession().invalidate();
        }
        // вовзращаем страницу логина
        return "redirect:/login";
    }

    // если обращаемся в корень сайта
    @GetMapping("/")
    public String root(Authentication authentication) {
        if (authentication != null) {
            // получаем пользователя по его аутентификации
            User user = service.getUserByAuthentication(authentication);
            // если это просто пользователь
            if (user.getRole().equals(Role.USER)) {
                // отдаем ему страницу профиля
                return "redirect:/user/shop";
            } else if (user.getRole().equals(Role.ADMIN)) {
                // если админ - отдаем страницу админа
                return "redirect:/admin";
            }
        }
        // если сессии нет - на логин кидаем
        return "redirect:/login";
    }

    // профиль пользователя
    @GetMapping("/user/profile")
    public String getProfilePage(Authentication authentication, @ModelAttribute("model") ModelMap model) {
        // кладем на страницу данные пользователя
        model.addAttribute(service.getUserByAuthentication(authentication));
        // возвращаем страницу профиля
        return "profile";
    }
}

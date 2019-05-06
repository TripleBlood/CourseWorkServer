package ligai.controllers;


import ligai.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    private AuthenticationService authenticationService;


    @GetMapping("/admin")
    public String getAdminHomePage(@ModelAttribute("model") ModelMap model, Authentication authentication,
                                   @RequestParam Optional<String> error) {
        model.addAttribute(authenticationService.getUserByAuthentication(authentication));
        return "admin_home";
    }


//
//    @GetMapping("/admin/list")
//    public String getAdminProdListPAge(@ModelAttribute("model") ModelMap model, Authentication authentication,
//                                   @RequestParam Optional<String> error) {
//        model.addAttribute("products", productRepository.findAll());
//        return "admin_list";
//    }
//
//    @GetMapping("/admin/savings")
//    public String getAdminProdListPAge(@ModelAttribute("model") ModelMap model) {
//        long i = 1;
//        Savings save = savingsRepository.getById(i);
//        model.addAttribute("savings", save);
//        return "admin_save";
//    }

}

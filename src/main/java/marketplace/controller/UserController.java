package marketplace.controller;

import marketplace.model.User;
import marketplace.service.SecurityService;
import marketplace.service.UserService;
import marketplace.validator.UserValidator;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;
    private final SecurityService securityService;
    private final UserValidator userValidator;


    public UserController(UserService userService, SecurityService securityService, UserValidator userValidator) {
        this.userService = userService;
        this.securityService = securityService;
        this.userValidator = userValidator;

    }

    @GetMapping(value = "/registration", produces = MediaType.TEXT_HTML_VALUE)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping(value = "/registration", produces = MediaType.TEXT_HTML_VALUE)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getUserPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping(value = "/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully");
        }

        return "login";
    }

    //TODO create userLots on welcome page. Uncommitted block in welcome.jsp

//    @GetMapping(value = {"/", "/welcome"})
//    public String welcome(Model model, Principal principal) {
//        User user = userRepository.findByUsername(principal.getName());
//        List<Product> myProducts = productService.findAll();
//        for (Product product : myProducts) {
//            if (!product.getOwnerId().equals(user.getId())) {
//                myProducts.remove(product);
//            }
//        }
//        model.addAttribute("myProducts", myProducts);
//        return "welcome";
//    }


    //TODO delete this block after fix behavior todo
    @GetMapping(value = {"/", "/welcome"})
    public String welcome() {
        return "welcome";
    }

    @GetMapping(value = "/admin")
    public String admin() {
        return "admin";
    }

}

package marketplace.controller;

import marketplace.model.User;
import marketplace.service.SecurityService;
import marketplace.service.UserService;
import marketplace.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

//TODO Replace @RequestMapping

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    //@GetMapping(value = "/registration")
    @RequestMapping(value = "/registration", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    //@PostMapping(value = "/registration")
    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUserLogin(), userForm.getUserPasswordConfirm());

//        TODO replace welcome
        return "redirect:/welcome";
    }

    //@GetMapping(value = "/login")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully");
        }

        return "login";
    }

    // @GetMapping(value = {"/", "/welcome"})
    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

}

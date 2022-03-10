package marketplace.validator;

import marketplace.model.User;
import marketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }

        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.userLogin");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "Required");
        if (user.getUserPassword().length() < 6 || user.getUserPassword().length() > 32) {
            errors.rejectValue("userPassword", "Size.userForm.password");
        }

        if (!user.getUserPasswordConfirm().equals(user.getUserPassword())) {
            errors.rejectValue("userPasswordConfirm", "Different.userForm.password");
        }
    }

}

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

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userLogin", "Required");
        if (user.getUserLogin().length() < 6 || user.getUserLogin().length() > 32) {
            errors.rejectValue("userLogin", "Size.userFrom.username");
        }

        if (userService.findByUserLogin(user.getUserLogin()) != null) {
            errors.rejectValue("userLogin", "Duplicate.userFrom.userLogin");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if(user.getUserPassword().length() < 6 || user.getUserPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getUserPasswordConfirm().equals(user.getUserPassword())) {
            errors.rejectValue("userPasswordConfirm", "Different.userForm.password");
        }
    }
}

package com.spring.Valgykla.validator;

import com.spring.Valgykla.model.User;
import com.spring.Valgykla.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    @Qualifier("UserService")
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");

        if (!user.getPassword().matches("^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])).{5,}$")){
            errors.rejectValue("password", "Regex.userForm.password");
        }

        if (!user.getCnfPassword().equals(user.getPassword())) {
            errors.rejectValue("cnfPassword", "Diff.userForm.cnfPassword");
        }
    }
}
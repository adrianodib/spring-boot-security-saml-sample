package br.com.assesso.dcsecurity.saml.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.assesso.dcsecurity.saml.dto.UserDto;

public class UserValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        return UserDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object obj, final Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "message.firstName", "Primeiro nome é requerido.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "message.lastName", "Sobrenome é requerido.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "message.password", "Password é requerido.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "message.username", "UserName é requerido.");
    }

}

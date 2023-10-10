package com.jobsearch.findyourjob.validator;/*
 * @created by Tom 08/10/2023
 */

import com.jobsearch.findyourjob.domain.dto.ClientFormData;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ClientsValidator implements Validator {

    private static final String EMAIL_REGEXP = "^(.+)@(\\S+)$";

    private static final Pattern pattern = Pattern.compile(EMAIL_REGEXP);

    @Override
    public boolean supports(Class<?> aClass) {
        return ClientFormData.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ClientFormData clientFormData = (ClientFormData) target;

        if (clientFormData.getName() == null || clientFormData.getName().isEmpty()) {
            errors.rejectValue("name", "400", "Title must not be empty");
        }

        if (clientFormData.getName().length() > 50) {
            errors.rejectValue("name", "400", "Name can be a maximum of 50 chars");
        }

        if (clientFormData.getEmail() == null || clientFormData.getEmail().isEmpty()) {
            errors.rejectValue("email", "400", "Email must not be empty");
        }

        if (!isValid(clientFormData.getEmail())) {
            errors.rejectValue("email", "400", "Email is not valid");
        }
    }

    public boolean isValid(final String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

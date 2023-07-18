package ua.ypon.springcourse.FirstSecurityApp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.ypon.springcourse.FirstSecurityApp.models.Person;
import ua.ypon.springcourse.FirstSecurityApp.services.PeopleService;

@Component
public class PersonValidator implements Validator {

    private final PeopleService peopleService;

    @Autowired
    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        if (peopleService.PresentPerson(person.getUsername()).isEmpty()) {
            return;
        }
        errors.rejectValue("username", "", "така людина вже зареєстрована");
    }
}

package ua.ypon.springcourse.FirstSecurityApp.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.ypon.springcourse.FirstSecurityApp.models.Person;
import ua.ypon.springcourse.FirstSecurityApp.services.RegistrationService;
import ua.ypon.springcourse.FirstSecurityApp.util.PersonValidator;

@Controller
@RequestMapping("/auth")
public class AuthController {

    // Використовуємо анотацію @Autowired для ін'єкції залежностей
    private final PersonValidator personValidator;
    private final RegistrationService registrationService;

    @Autowired
    public AuthController(PersonValidator personValidator, RegistrationService registrationService) {
        this.personValidator = personValidator;
        this.registrationService = registrationService;
    }

    // Анотація @GetMapping вказує на обробник GET-запиту за шляхом "/auth/login"
    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    // Анотація @GetMapping вказує на обробник GET-запиту за шляхом "/auth/registration"
    // Анотація @ModelAttribute("person") створює модель "person" для передачі на сторінку
    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") Person person) {
        return "auth/registration";
    }

    // Анотація @PostMapping вказує на обробник POST-запиту за шляхом "/auth/registration"
    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid Person person,
                                      BindingResult bindingResult) {
        // Виконуємо валідацію об'єкта Person з використанням PersonValidator
        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors())
            return "/auth/registration";
        // Виконуємо реєстрацію за допомогою RegistrationService
        registrationService.register(person);

        return "redirect:/auth/login";
    }
}

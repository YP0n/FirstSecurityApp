package ua.ypon.springcourse.FirstSecurityApp.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ua.ypon.springcourse.FirstSecurityApp.models.Person;

import java.util.Collection;

/**
 * net.ukr@caravell 28/06/2023
 */
public class PersonDetails implements UserDetails {
    // Об'єкт Person, який містить деталі про користувача
    private final Person person;

    // Конструктор класу, який приймає об'єкт Person
    public PersonDetails(Person person) {
        this.person = person;
    }

    // Метод, який повертає список ролей користувача (авторизованих)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    // Метод, який повертає пароль користувача
    @Override
    public String getPassword() {
        return this.person.getPassword();
    }

    // Метод, який повертає ім'я користувача (логін)
    @Override
    public String getUsername() {
        return this.person.getUsername();
    }

    // Метод, який повертає true, якщо обліковий запис користувача не закінчився
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // Метод, який повертає true, якщо обліковий запис користувача не заблокований
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Метод, який повертає true, якщо облікові дані користувача не закінчилися
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Метод, який повертає true, якщо обліковий запис користувача активний
    @Override
    public boolean isEnabled() {
        return true;
    }

    // Метод, який повертає об'єкт Person, який містить деталі про авторизованого користувача
    public Person getPerson() {
        return this.person;
    }
}

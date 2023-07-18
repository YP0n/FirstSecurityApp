package ua.ypon.springcourse.FirstSecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ua.ypon.springcourse.FirstSecurityApp.models.Person;
import ua.ypon.springcourse.FirstSecurityApp.repositories.PeopleRepository;

import java.util.Optional;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;


    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Optional<Person> PresentPerson(String username) {
        return peopleRepository.findByUsername(username);
    }
}

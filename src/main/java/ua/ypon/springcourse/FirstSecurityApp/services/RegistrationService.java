package ua.ypon.springcourse.FirstSecurityApp.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ypon.springcourse.FirstSecurityApp.models.Person;
import ua.ypon.springcourse.FirstSecurityApp.repositories.PeopleRepository;


@Service
public class RegistrationService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public RegistrationService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Transactional
    public void register(Person person) {
        peopleRepository.save(person);
    }
}

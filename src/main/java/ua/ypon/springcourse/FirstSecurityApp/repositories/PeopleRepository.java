package ua.ypon.springcourse.FirstSecurityApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.ypon.springcourse.FirstSecurityApp.models.Person;

import java.util.Optional;

/**
 * net.ukr@caravell 28/06/2023
 */
@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByUsername(String username);
}

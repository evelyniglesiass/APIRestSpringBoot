package br.com.evelyniglesiass.repositories;

import br.com.evelyniglesiass.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}

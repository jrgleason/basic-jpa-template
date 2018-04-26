package org.gleason.coffeeshop.repo;

import org.gleason.coffeeshop.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person, String> {
}

package org.gleason.coffeeshop.service;

import org.gleason.coffeeshop.domain.Person;
import org.gleason.coffeeshop.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoffeeShopService {
    @Autowired
    PersonRepo repo;

    public Iterable<Person> getPeople(){
        return repo.findAll();
    }
}

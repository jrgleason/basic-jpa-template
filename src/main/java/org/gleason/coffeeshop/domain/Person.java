package org.gleason.coffeeshop.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON", schema = "MAIN")
public class Person {
    @Id
    private String name;
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return name;
    }
}

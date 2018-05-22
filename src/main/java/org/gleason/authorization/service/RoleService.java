package org.gleason.authorization.service;

import org.gleason.authorization.domain.Role;
import org.gleason.authorization.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class RoleService {
    private RoleRepo repo;
    private final EntityManager entityManager;

    @Autowired
    public RoleService(EntityManager entityManager, RoleRepo repo){
        this.entityManager = entityManager;
        this.repo = repo;
    }

    public Iterable<Role> getRoles(){
        return repo.findAll();
    }

    public void addRole(Role toAdd){
        entityManager.getTransaction().begin();
        entityManager.persist(toAdd);
        entityManager.getTransaction().commit();
    }
}

package org.gleason.authorization.repo;

import org.gleason.authorization.domain.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, String> {
}

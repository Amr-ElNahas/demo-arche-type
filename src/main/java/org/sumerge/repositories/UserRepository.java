package org.sumerge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sumerge.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

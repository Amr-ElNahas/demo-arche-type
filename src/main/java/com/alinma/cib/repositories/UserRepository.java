package com.alinma.cib.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alinma.cib.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

package org.sumerge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sumerge.models.UserDocument;

public interface UserRepository extends JpaRepository<UserDocument, Long> {
}

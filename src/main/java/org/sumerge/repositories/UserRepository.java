package org.sumerge.repositories;

import org.sumerge.models.UserDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDocument, ObjectId> {
}

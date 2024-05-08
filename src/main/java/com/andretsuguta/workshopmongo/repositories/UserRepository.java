package com.andretsuguta.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.andretsuguta.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}

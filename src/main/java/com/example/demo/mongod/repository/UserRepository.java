package com.example.demo.mongod.repository;

import com.example.demo.mongod.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}

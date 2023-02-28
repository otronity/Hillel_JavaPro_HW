package com.example.springsecurity.repository;

import com.example.springsecurity.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findFirstByName(String name);

    boolean existsUserByName(String name);

}

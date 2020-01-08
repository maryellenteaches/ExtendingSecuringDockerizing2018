package com.example.ec.repo;

import com.example.ec.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * Repository for the Security_User table
 *
 * Created by Mary Ellen Bowman.
 */
@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * Find the User by the username.
     *
     * @param userName username to query by.
     * @return Optional Of a User
     */
    Optional<User> findByUsername(String userName);
}
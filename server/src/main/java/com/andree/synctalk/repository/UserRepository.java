package com.andree.synctalk.repository;

import com.andree.synctalk.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserByUsername(String username);
}

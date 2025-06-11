package com.example.apiAuthetication.repositories;

import com.example.apiAuthetication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserProduct extends JpaRepository<User, Integer> {
    Optional<User> findyEmail(String email);

    List<User> findByNameContaining(String name);

    List<User> findByStatus(boolean status);

    Optional<User> findByEmailStatus(String email, boolean status);

}

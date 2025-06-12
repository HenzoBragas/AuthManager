package com.example.apiAuthetication.repositories;

import com.example.apiAuthetication.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer> {
}

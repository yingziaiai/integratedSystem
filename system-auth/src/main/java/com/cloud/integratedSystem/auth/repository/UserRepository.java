package com.cloud.integratedSystem.auth.repository;

import com.cloud.integratedSystem.auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUserName(String userName);
}

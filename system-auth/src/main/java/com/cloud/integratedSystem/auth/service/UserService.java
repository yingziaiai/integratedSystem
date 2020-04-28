package com.cloud.integratedSystem.auth.service;

import com.cloud.integratedSystem.auth.entities.User;

import java.util.Set;

public interface UserService {
    User findByUserName(String userName);
    Set<String> findRolesByUserName(String userName);
}

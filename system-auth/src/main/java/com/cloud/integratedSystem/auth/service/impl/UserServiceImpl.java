package com.cloud.integratedSystem.auth.service.impl;

import com.cloud.integratedSystem.auth.entities.User;
import com.cloud.integratedSystem.auth.repository.RoleRepository;
import com.cloud.integratedSystem.auth.repository.UserRepository;
import com.cloud.integratedSystem.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public Set<String> findRolesByUserName(String userName) {
        User user = findByUserName(userName);
        if (user != null) {
            Set<String> roleCodes = roleRepository.findRoleCodeByUserId(user.getUserId());
            return roleCodes;
        }
        return null;
    }

}

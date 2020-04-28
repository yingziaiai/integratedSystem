package com.cloud.integratedSystem.auth.repository;

import com.cloud.integratedSystem.auth.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByRoleId(String roleId);

    @Query(value = "Select b.role_code FROM tb_user_role a left join tb_role b on a.user_id = :userId", nativeQuery = true)
    Set<String> findRoleCodeByUserId(@Param("userId") String userId);

}

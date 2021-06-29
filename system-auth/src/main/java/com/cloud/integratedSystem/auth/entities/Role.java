package com.cloud.integratedSystem.auth.entities;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(name = "tb_role")
@Data
@ToString(exclude="userSet")
public class Role {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "role_id")
    private String roleId;

    @Column(name = "role_name", unique = true, nullable = false, length = 64)
    private String roleName;

    @Column(name = "role_code", nullable = false, length = 64)
    private String roleCode;

    @Column(name = "role_desc", length = 64)
    private String roleDesc;

    @Column(name = "create_time")
    private OffsetDateTime createTime;

    @Column(name = "update_time")
    private OffsetDateTime updateTime;

    @ManyToMany
    @JoinTable(name = "tb_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id") }) //被控方表字段名
    private Set<User> userSet;
}

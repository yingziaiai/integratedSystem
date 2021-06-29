package com.cloud.integratedSystem.auth.entities;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Table(name = "tb_user")
@ToString(exclude="roleSet")
@Data
public class User {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "user_id")
    private String userId;

    @Column(name = "username", unique = true, nullable = false, length = 64)
    private String userName;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Column(name = "email", length = 64)
    private String email;

    @Column(name = "phone", length = 64)
    private String phone;

    @Column(name = "avatar", length = 64)
    private String avatar;

    @Column(name = "create_time")
    private OffsetDateTime createTime;

    @Column(name = "update_time")
    private OffsetDateTime updateTime;

    @ManyToMany
    @JoinTable(name = "tb_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id")})
    private Set<Role> roleSet;
}

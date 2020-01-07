package com.example.ec.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Entity of a Security Role
 * Created by Mary Ellen Bowman
 */
@Entity
@Table(name="security_role")
public class Role  implements GrantedAuthority {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="role_name")
    private String roleName;

    @Column(name="description")
    private String description;

    @Override
    public String getAuthority() {
        return roleName;
    }

    /**
     * Get the identifier.
     *
     * @return identifier
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the identifier
     *
     * @param id identifier
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Set the role name
     *
     * @param roleName role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Get the role name
     *
     * @return role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Get the description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }
}
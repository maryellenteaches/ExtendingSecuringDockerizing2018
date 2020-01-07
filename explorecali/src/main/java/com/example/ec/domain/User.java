package com.example.ec.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

/**
 * Security User Entity.
 *
 * Created by Mary Ellen Bowman
 */
@Entity
@Table(name = "security_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns
            = @JoinColumn(name = "user_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",
                    referencedColumnName = "id"))
    private List<Role> roles;

    /**
     * Construct a fully initialized Object.
     *
     * @param username username
     * @param password password
     * @param role role
     * @param firstName first name
     * @param lastName last name
     */
    public User(String username, String password, Role role, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.roles = Arrays.asList(role);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Default Constructor.
     */
    protected User() {
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
     * Get the username.
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get the password.
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get the first name.
     *
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the last name.
     *
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get the roles.
     *
     * @return roles
     */
    public List<Role> getRoles() {
        return roles;
    }
}

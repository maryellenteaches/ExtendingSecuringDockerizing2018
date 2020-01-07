package com.example.ec.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void test() {
        User user = TestHelper.makeUser();
        assertThat(user.getUsername(), is("username"));
        assertThat(user.getPassword(), is("password"));
        assertThat(user.getFirstName(), is("firstName"));
        assertThat(user.getLastName(), is("lastName"));
        assertThat(user.getRoles().get(0).getRoleName(), is("roleName"));
        assertThat(user.getRoles().get(0).getDescription(), is("description"));
    }
}
package com.example.ec.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Mary Ellen Bowman
 */
public class TourPackageTest {
    @Test
    public void testConstructorAndGetters() throws Exception {
        TourPackage p = TestHelper.makePackage();
        assertThat(p.getName(), is("name"));
        assertThat(p.getCode(), is("code"));
    }

    @Test
    public void equalsHashcodeVerify() throws IllegalAccessException {
        TourPackage p1 = TestHelper.makePackage();
        TourPackage p2 = TestHelper.makePackage();

        assertThat(p1,is(p2));
        assertThat(p1.hashCode(), is(p2.hashCode()));
    }
}
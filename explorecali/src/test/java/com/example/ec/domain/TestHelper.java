package com.example.ec.domain;

import java.util.Collections;

import static com.example.ec.domain.Difficulty.Difficult;
import static com.example.ec.domain.Region.Central_Coast;
import static org.apache.commons.lang3.reflect.FieldUtils.writeField;

public class TestHelper {
    public static TourPackage makePackage() throws IllegalAccessException{
        class TourPackageTester extends TourPackage{
            public TourPackageTester() {
                super();
            }
        }
        TourPackage tourPackage = new TourPackageTester();
        writeField(tourPackage, "code", "code", true);
        writeField(tourPackage, "name", "name", true);
        return tourPackage;

    }
    public static Tour makeTour() throws IllegalAccessException {
        class TourTester extends Tour{
            public TourTester() {
                super();
            }
        };
        Tour tour = new TourTester();
        writeField(tour, "title", "title", true);
        writeField(tour, "title", "title", true);
        writeField(tour, "description", "description", true);
        writeField(tour, "blurb", "blurb", true);
        writeField(tour, "price", 50, true);
        writeField(tour, "duration", "1 day", true);
        writeField(tour, "bullets", "bullets", true);
        writeField(tour, "keywords", "keywords", true);
        writeField(tour, "tourPackage", makePackage(), true);
        writeField(tour, "difficulty", Difficult, true);
        writeField(tour, "region", Central_Coast, true);
        return tour;
    }

    public static User makeUser() {
        class UserTester extends User {
            public UserTester() {
                super();
            }
        }
        class RoleTester extends Role{
            public RoleTester() {
                super();
            }
        }
        User user = new UserTester();
        Role role = new RoleTester();
        try {
            writeField(role, "roleName", "roleName", true);
            writeField(role, "description", "description", true);
            writeField(user, "roles", Collections.singletonList(role), true);
            writeField(user, "username", "username", true);
            writeField(user, "password", "password", true);
            writeField(user, "firstName", "firstName", true);
            writeField(user, "lastName", "lastName", true);
        } catch (IllegalAccessException e) {
        }
        return user;
    }
}

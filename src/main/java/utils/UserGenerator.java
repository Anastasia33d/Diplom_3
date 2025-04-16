package utils;
import com.github.javafaker.Faker;
import models.User;

import java.util.UUID;

public class UserGenerator {
    private static final Faker faker = new Faker();

    public static User getRandomUniqUser() {
        String uniqueSuffix = UUID.randomUUID().toString() + System.currentTimeMillis();
        String email = "user" + uniqueSuffix + faker.internet().emailAddress();
        String password = faker.internet().password(6, 10);
        String name = faker.name().firstName() + uniqueSuffix;

        return new User(email, password, name);
    }
}




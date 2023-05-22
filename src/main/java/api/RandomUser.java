package api;

import com.github.javafaker.Faker;

public class RandomUser {
    public static User createRandomUser() {
        Faker faker = new Faker();
        return new User(faker.name().username(), faker.internet().password());
    }
}

package helpers;

import com.github.javafaker.Faker;

public class DataHelper {

    private static final Faker faker = new Faker();

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomPassword() {
        return faker.letterify("??????????");
    }

    public static String getRandomDigits(int count) {
        return faker.number().digits(count);
    }

    public static int getRandomNumber(int min, int max) {
        return faker.number().numberBetween(min, max);
    }
}

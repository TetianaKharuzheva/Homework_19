package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class TestDataGenerator {

    public static String generateRandomField() {
        return RandomStringUtils.randomAlphabetic(10);
    }
}

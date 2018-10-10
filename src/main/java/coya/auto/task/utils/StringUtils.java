package coya.auto.task.utils;

import java.util.Random;

public class StringUtils {

    private static final Random RANDOM = new Random();
    private static final int START_CHAR = (int) '!';
    private static final int END_CHAR = (int) '~';

    public static String randomString(final int maxLength) {
        final int length = RANDOM.nextInt(maxLength + 1);
        return RANDOM.ints(length, START_CHAR, END_CHAR + 1)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
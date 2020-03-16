package com.ntt.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class NumberCommon {
    public static int getRandomBetweenRange(int min, int max) {
        return min + new Random().nextInt(max);
    }

    public static long getRandomBetweenRange(long min, long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public static List<String> getListRandom(int lineNumber, int min, int max){
        List<String> data = new ArrayList<>();
        if (lineNumber < 1 || max < min) return data;
        for (int i = 0; i < lineNumber; i++) {
            data.add(getRandomBetweenRange(min, max) + "");
        }
        return data;
    }

    public static Integer convertToInteger(Object value) {
        if (value == null || StringCommon.isNullOrBlank((String) value)) {
            return null;
        }
        try {
            Integer result = Integer.valueOf(value.toString());
            return result;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }
}

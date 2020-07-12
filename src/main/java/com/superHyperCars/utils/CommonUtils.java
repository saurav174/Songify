package com.superHyperCars.utils;

import java.util.UUID;

public class CommonUtils {

    public static String getUniqueKey() {
        UUID uniqueKey = UUID.randomUUID();
        return uniqueKey.toString();
    }

}

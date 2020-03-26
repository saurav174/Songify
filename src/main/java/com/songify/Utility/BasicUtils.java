package com.songify.Utility;

import java.util.Collection;

public class BasicUtils {

    public static boolean isEmpty(Collection<?> collection) {
        if (collection == null || collection.isEmpty() || collection.size() == 0) {
            return true;
        }
        return false;
    }

}

package com.songify.utils;

import java.util.regex.Pattern;

public class EmailUtility {

    private static final String EMAIL_REGEX="^[a-zA-Z0-9_+&*-]+(?:\\."+
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";;

    public static boolean isValid(String email)
    {


        Pattern pat = Pattern.compile(EMAIL_REGEX);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

}

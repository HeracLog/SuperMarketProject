package com.supermarket.project.supermarketproject;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PassHash {

    static String hash(String pass)
    {
        pass = pass.replaceAll(" ","hashMore");

        char[] arr = pass.toCharArray();
        Arrays.sort(arr);

        return new String(arr);
    }
}

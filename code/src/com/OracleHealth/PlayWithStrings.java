package com.OracleHealth;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlayWithStrings {
    public static void main(String[] args) {

        String[] arr = {"Tea","Cake"};
        List<String> texts = Arrays.asList(arr);

//        texts.add("ff"); We cannot add any elemnt as it's a fixed size, and cannot be manipulated
        texts.replaceAll(e -> e.replaceAll("Tea","Coffee"));
        /*        OR        */
        Collections.replaceAll(texts,"Coffee","Tea");
        arr[1] = "sd";
        long count = Arrays.stream(arr).count();
        System.out.println(count);
        System.out.println(texts);
        /** Hece proved that in this scenario, we can oly replace elements in arr ad texts */
    }
}

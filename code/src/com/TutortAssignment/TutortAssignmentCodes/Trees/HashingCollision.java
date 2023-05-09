package com.TutortAssignment.TutortAssignmentCodes.Trees;

import java.util.HashMap;
import java.util.Map;

public class HashingCollision {
    public static void main(String[] args) {

        MyKey m = new MyKey(1,"ddc1");
        MyKey m1 = new MyKey(2,"tuban");
        MyKey m2 = new MyKey(1,"ddc2");
        MyKey m3 = new MyKey(1,"ddc3");
        Map<MyKey,String> tmps = new HashMap();
        System.out.println("storing value for m");
        tmps.put(m, "America");
        System.out.println("storing value for m1");
        tmps.put(m1, "Canada");
        System.out.println("storing value for m2");
        tmps.put(m2, "Nepals");
        System.out.println("storing value for m3");
        tmps.put(m3, "Nepal");
        System.out.println(tmps.get(m));
        System.out.println(tmps.get(m1));
        System.out.println(tmps.get(m2));
        System.out.println(tmps.get(m3));
//        tmps.remove(m3,"Nepals");
        String remove = tmps.remove(m2);
        System.out.println(remove+" gg "+tmps.get(m2));
    }
}

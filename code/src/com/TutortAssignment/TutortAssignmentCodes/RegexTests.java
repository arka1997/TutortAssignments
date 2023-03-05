package com.TutortAssignment.TutortAssignmentCodes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTests {
    private static final Pattern SEMANTIC_PATTERN =
            Pattern.compile(
                    "([0-9]\\d*)\\.?(0|[1-9]\\d*|\\*)?\\.??");
    public static void main(String[] args) {
        String re= ".*\\d.*";//so basically it checks, if the string "text" has any digit or not, if yes, then true
        String text = "1a2a";

        Pattern pt = Pattern.compile(re);
        Matcher mt = pt.matcher(text);
        boolean matches = mt.matches();

        boolean matches1 = SEMANTIC_PATTERN.matcher(text).matches();
        System.out.println(matches1);

    }
}
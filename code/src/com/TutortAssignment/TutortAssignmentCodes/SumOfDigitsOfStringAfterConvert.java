package com.TutortAssignment.TutortAssignmentCodes;


import java.util.Collection;
import java.util.HashMap;

public class SumOfDigitsOfStringAfterConvert {
    public static void main(String[]args){
        String s = "zbax";
        int k = 2;
        String s2 = convertAlphabetsToInt(s);
        HashMap<String,Integer> h = new HashMap<>(26);
        h.get(s.charAt(0));
        for(int i=0;i<k;i++){
            int sum = sumOfDigits(s2);
            s2=String.valueOf(sum);
        }
        System.out.println(s2);
    }
    public static String convertAlphabetsToInt(String s) {
        //converting the alphabets to its respective Integers
        int j = 0;
        String s2 = "";
        while(j<s.length()){
            int c = s.charAt(j++)-'a'+1;
            s2 +=c;
        }
        return s2;
    }
    public static int sumOfDigits(String s2) {
        int sum = 0;
        for(int i =0;i<s2.length();i++){
            sum +=Integer.parseInt(String.valueOf(s2.charAt(i)));
        }
        System.out.println("val="+sum);
        return sum;
    }
}

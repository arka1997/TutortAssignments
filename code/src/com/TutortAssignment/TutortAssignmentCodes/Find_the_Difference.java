package com.TutortAssignment.TutortAssignmentCodes;

import java.util.HashMap;
import java.util.Map;

public class Find_the_Difference {
    public static void main(String[] args) {
        String s="iiii";
        String t="a";
        int j = 0;
        String s2 = "";
        while(j<s.length()){
            int c = s.charAt(j++)-'a'+1;
            s2 +=c;
        }
        System.out.println("val="+s2);

        int sum = 0;
        for(int i =0;i<s2.length();i++){
            sum +=Integer.parseInt(String.valueOf(s2.charAt(i)));

        }
        System.out.println("val="+sum);

        findTheDifference(s, t);
    }
    public static char findTheDifference(String s, String t) {
//         only lower case, and String length cannot be more then 1000
//       1st step, to sort both the string, and check if both the string has same values or not,the one which is extra is returned, didn't worked, beacuse
        // 2nd Step -> pick one character from the String s, and then serach in the String t, the elment which is not found in t is returned. This approach didn't work for s= "ae", t = "aea", because if we use contains(), then it will pick each elemnts and check in the another array if present or not, now for duplicates, the approach fails. Like pick suppose s= "ae", t = "aae", then we see that one 'a' is extra, but t.contains(s) will retrun true for 'a'.
//         3rd step -> convert String "t" into char array, traverse the "t" array, and search for the char s.chatAt(i) if found in the array "t", if yes, we set it to 0. then after that we run another loop, and return the non-zero number from array, which was present in "t" but not in "s" and is unique.O(n^2), two loops needed, one for traversing t array, and one for pointing at every location of String s, and traversing upto s.length().
        // 4th Step -> use hashmap, calculate frequency -> then check whose frequency is equalto zero, that's our unique charater, and return that.
//         5th step -> using xor, add one char from "s", and the other char from "t", which will cancel each other, and the unique one will be left in the variable, and we return it.
        HashMap<Character,Integer> h = new HashMap<>(26);
        int p1 = 0;
        while(p1<s.length()){
            char pointToChar = s.charAt(p1);
            h.put(pointToChar, h.getOrDefault(pointToChar,0)+1);
            p1++;
        }
        for(Map.Entry entry : h.entrySet()){
            System.out.println("key="+entry.getKey()+" value="+entry.getValue());
        }
        // ade
        // aaed
//         Now again traverse through the String t. Our primary focus will be reducing the frequency of each character
//         to zero by deducting the "Value" Part with -1. Now ther are two if blocks,
    //         a) one for deducting the frequency
    //         b) 2nd to check if the key is prtesent in HashMap && the key ha a value zero or not OR if the current key
    //            is not present in Hashmap(In both case we return that extra character)
        p1 = 0;
        while(p1<t.length()){
            char pointToChar = t.charAt(p1);
            if(h.containsKey(pointToChar)&&h.get(pointToChar)==0|| !h.containsKey(pointToChar)){
                return t.charAt(p1);
            }else{
                h.put(pointToChar,h.get(pointToChar)-1);
            }
        }
        return '!';
    }
}

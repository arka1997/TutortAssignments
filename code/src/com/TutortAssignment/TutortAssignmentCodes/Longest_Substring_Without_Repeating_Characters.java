package com.TutortAssignment.TutortAssignmentCodes;

import java.util.ArrayList;
import java.util.HashMap;

class Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        String s = "dvdf";
        lengthOfLongestSubstring(s);
        lengthOfLongestSubstringApproach2(s);
    }
    public static int lengthOfLongestSubstringApproach2(String s1) {
        // first we need two pointers, S & E, one will be fixed at first, and the 2nd one will keep on moving ahead, while storing each unique characters in HashMap. Now when the pointer "E" will find any repeated character in hashmap, then it will just move "S" to new position as we have found a repeated char, so we won't proceed further with that element and move ahead, and start calculating for repeated from next elemnt. But we need to calculate the distance until the repeated character is found(with Index calculation S-E).Now after we start again, we will first check if the character "E" is currently pointing at is present in HashMap or not, if yes, then we check if the value pair is less then "S" or not, if yes, then we update the value of the character in HashMap.
// Small Optimization -> When we find any repeated character in HashMap, then we will move the "S" pointer to that (index+1)th element. Like abcdcb -> S=0;E=4, when we found repeatd, that means if we again move S -> S+1, and start from char "b", then it will also stop at the same repeatation of "c". So better we move to to that index position directly of the repeated character i HashMap. And becase of this we also store the index of every chars in HashMap.
        HashMap<Character,Integer> h = new HashMap<>();
        int s = 0;
        int e = 0;
        int max = Integer.MIN_VALUE;
        if(s1.length()==0){
            return 0;
        }
        if(s1.length()==1){
            return 1;
        }
        while(e<s1.length()){
            char ch = s1.charAt(e);
            if(!h.containsKey(ch)||h.get(ch)<s){//calc non repeating if value is not present in map or current index present in Map is less then start
                h.put(ch,e);
                e++;
            }else{
                int diff = e-s;
                max = Math.max(diff,max);
                s = h.get(ch)+1;
                e=s;
                if(s>=s1.length()){
                    break;
                }
            }
            int diff = e-s;
            max = Math.max(diff,max);
        }
        return max;
    }
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> h = new HashMap<>();
        ArrayList<Character> a = new ArrayList<>();
        int uniqueSize = 0;
        if(s.length()==1){
            return 1;
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            // if(h.containsKey(ch)){
            if(a.contains(ch)){
                uniqueSize = Math.max(uniqueSize,a.size());
                a = new ArrayList<>();
            }
                a.add(ch);
                // h.put(ch,1);
        }
        return uniqueSize;
    }
}
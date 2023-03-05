package com.TutortAssignment.TutortAssignmentCodes;

import java.util.HashMap;

class FirstUniqueCharacterInString {
    public static void main(String[] args) {
        String s = "leetcode";
        firstUniqChar(s);
    }
    public static int firstUniqChar(String s) {
        // Approach1 -> first we can sort the array, and chekc if the next elemnt is not equals to the current elemnt, the return the number, wy? becuse after sorting, all duplicate elemnts will be togther, and currentElemnt==nextelemnt will be equal, and we ignore them. Only consider when currentElemnt!=nextElemnt...T.C. -> O(nlogn) , S.C ->O(1)
    // Approach 2: HashMap, here we count the frequency of every characters, and check whose frequency is equal to 1. T.C -> O(n), S.C -> O(n) due to extra HashMap
    // we ca do one thing, take the indexes of each charcater in the string inside HashMap, and then store that elemnts frequency. 
    HashMap<Character,Integer> h1 = new HashMap<>();
        for(int i=0;i<s.length();i++){
            h1.put(s.charAt(i),h1.getOrDefault(s.charAt(i),0)+1);
            System.out.println(h1);
        }
        for(int i=0;i<s.length();i++){
            if(h1.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
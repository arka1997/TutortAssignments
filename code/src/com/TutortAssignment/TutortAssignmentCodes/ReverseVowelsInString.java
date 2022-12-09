package com.TutortAssignment.TutortAssignmentCodes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
//question can come before solving: a)Does the string have spaces b) does it will contain only small letters and ignore other case and numbers.
//Here we convert string to char array,a nd store in another variable -> then traverse the string using 2 pointer -> then whenever both the pointer
// have reached the vowels on both ends, then we interchange the values of the character array, and not the string.String just for searching the vowel, we
//will change the positoions in the char array. Because in string, if there are duplicates it cannot replace a single character, it will replace all characters in that string. so we prefer converting to char Array.
public class ReverseVowelsInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "Euston saw I was not Sue.";

        int p1=0;
        int p2=str.length()-1;
        char[] replace1 = str.toCharArray();
        HashSet<Character> h = new HashSet<Character>();
        h.add('a');
        h.add('e');
        h.add('i');
        h.add('o');
        h.add('u');
        h.add('A');
        h.add('E');
        h.add('I');
        h.add('O');
        h.add('U');
        while(p1<p2){
            if(h.contains(str.charAt(p1))){
                if(h.contains(str.charAt(p2))){
//                  swap when we get vowels
                    char temp = replace1[p1];
                    replace1[p1] = replace1[p2];
                    replace1[p2] = temp;
                    p1++;
                    p2--;
                }else {
                    p2--;
                }
            }else{
                p1++;
            }
        }
        String s = "";
        for(int i=0;i<replace1.length;i++){
            s +=replace1[i];
        }
        System.out.println(s);
    }
}

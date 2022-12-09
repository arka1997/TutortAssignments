package com.TutortAssignment.TutortAssignmentCodes;

public class Jewels__Stones {
    public static void main(String[] args) {
        String jewels= "aA";
        String stones = "aAAbbbb";
        int i = numJewelsInStones(jewels, stones);
        System.out.println(i);
    }
        public static int numJewelsInStones(String jewels, String stones) {
            //1st pick one jewel each time, ad send it to another function, where it will check if that jewel exist in the string or not, if yes, return the count of it.
            // And also,give an edge case with contains() in 2nd method, which will check if each jewel exist in that string or not
            // and also case is different
            // chars() -> this converts the string into stream of characters, to apply filters and stream api methods
            //now when we convert each char into Intstream, then we filter -> and check if each IntChar in stones is present in jewels or not, if yes, then we increase the count, with count().
            return (int)stones.chars().filter(e -> jewels.contains(String.valueOf((char) e))).count();
//          return (int)stones.chars().filter(e -> jewels.contains(String.valueOf((char) e))).count();
            // int count = 0;
            // for(int i=0;i<jewels.length();i++){
            //     count = findJewelsCount(jewels.charAt(i),stones,count);
            // }
            // return count;
        }
        public int findJewelsCount(char ch,String stones,int count){
            if(stones.contains(String.valueOf(ch))){//here we have to convert the "ch" to String, beacuse the contains parameter accepts String only
                for(int i=0;i<stones.length();i++){
                    if(stones.charAt(i)==ch){
                        count++;
                    }
                }
            }
            return count;
        }
    }
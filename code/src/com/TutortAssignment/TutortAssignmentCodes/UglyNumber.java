package com.TutortAssignment.TutortAssignmentCodes;

import java.util.ArrayList;

class UglyNumber {
    static int x = 3;


    public static void main(String[] args) {
        String s = "DebanjanSarkar";
        isUgly(18);
        UglyNumber c = new UglyNumber();

    }
    public static boolean isUgly(final int n) {
        ArrayList<Integer> a = new ArrayList<>();
        int count = 0;
        if(n == 1){
            return true;
        }
        // int i=1;
        for(int i=1; i <= n / 2; i++){
            if(n % i == 0){
                System.out.println(i);
            }
        }
        // while(n!=0){
        //     int x = n / i;
        //     i++;
        // }
        //     if(n/2 == 3 || n/2 == 5){
        //         count++;
        //         if(n/3 == 2 || n/3 == 5){
        //             count++;
        //             if(n/5 == 3 || n/5 == 2){
        //                 count++;
        //     }
        // }
        //     }
        // if(count == 3){
        //     return true;
        // }
        return false;
    }
}
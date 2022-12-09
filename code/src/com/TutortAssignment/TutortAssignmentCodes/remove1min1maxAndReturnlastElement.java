package com.TutortAssignment.TutortAssignmentCodes;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;
public class remove1min1maxAndReturnlastElement {
    public static void main(String args[]) {
        int size=7;
        int[] arr= new int[size];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        approach(arr);
    }
    public static void approach(int @NotNull [] arr){
        int p1 = 0; int p2 = arr.length;
        Arrays.sort(arr);
        int m = p2+(p1-p2)/2;
        if(arr.length%2==0){
            System.out.println("Sum of x+y = " + m);
        }
        while (p1<p2){
            p1++;
            p2--;
        }

        System.out.println("Sum of x+y = " + p1);
    }
}

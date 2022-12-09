package com.TutortAssignment.TutortAssignmentCodes;

import java.util.Scanner;

public class ElementsEqualToIndex {
    public static void main(String args[]) {
        int size=5;
        int[] arr= new int[size+1];
        Scanner sc = new Scanner(System.in);
      for(int i=1;i<arr.length;i++){
              arr[i]=sc.nextInt();
      }
     approach(arr);
    }
    public static void approach(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i]==i){
                System.out.println(arr[i]);
            }
        }
    }
}
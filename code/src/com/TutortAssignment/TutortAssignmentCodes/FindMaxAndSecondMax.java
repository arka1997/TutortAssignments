package com.TutortAssignment.TutortAssignmentCodes;

import java.util.Scanner;

public class FindMaxAndSecondMax {
    public static void main(String[] args) {
        int size=5;
        int[] arr= new int[size];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        findTwoGreatestElements(arr);
    }
    //    3 5 4 7 9
    private static void findTwoGreatestElements(int[] arr) {
        int max = Integer.MIN_VALUE;
        int scndMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                scndMax = max;//-9999,2 , 4
                max = arr[i];//2 , 4, 5
            } else if (scndMax < arr[i]) {//if elemnt is not greater then max. then we came in this else block to check, if the arr[i] element is also small then secndMax or not, if small, then we ignore, but if big, then scndMax will store the new arr[i] element
                scndMax = arr[i];
            }
        }

        System.out.println(max);
        System.out.println(scndMax);
    }
}

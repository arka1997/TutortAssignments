package com.TutortAssignment.TutortAssignmentCodes;

import java.util.Arrays;
import java.util.Scanner;

public class MaxAndMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];

        for(int i = 0; i < arr.length; ++i) {
            arr[i] = sc.nextInt();
        }

        arr = fndMaxAndMin(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] fndMaxAndMin(int[] arr) {
        int[] arr1 = new int[2];
        int max = -2147483648;
        int min = 2147483647;

        int i;
        for(i = 0; i < arr.length; ++i) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for(i = 0; i < arr.length; ++i) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        arr1[0] = min;
        arr1[1] = max;
        return arr1;
    }
}

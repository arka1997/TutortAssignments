package com.TutortAssignment.TutortAssignmentCodes;

import java.util.Scanner;

public class CountNumbersLessThenKey {
    public CountNumbersLessThenKey() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int key = sc.nextInt();
        int[] arr = new int[size];

        int m;
        for(m = 0; m < arr.length; ++m) {
            arr[m] = sc.nextInt();
        }

        m = countNumbers(arr, size, key);
        System.out.println(m);
    }

    public static int countNumbers(int[] arr, int size, int key) {
        int count = 0;

        for(int i = 0; i < arr.length; ++i) {
            if (arr[i] < key) {
                ++count;
            }
        }

        return count;
    }
}

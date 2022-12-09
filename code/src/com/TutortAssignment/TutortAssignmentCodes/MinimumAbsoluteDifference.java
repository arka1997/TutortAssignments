package com.TutortAssignment.TutortAssignmentCodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        int arr[] = {3,8,-10,23,19,-4,-14,27};
        List<List<Integer>> lists = minimumAbsDifference(arr);
        System.out.println(lists);
    }
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        // -14 -10 -4 3 8 19 23 27
        //1 2 3 4
        Arrays.sort(arr);
        List<List<Integer>> l2 = new ArrayList<List<Integer>>();
        int absDiff = Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            int curr = arr[i+1] - arr[i];
            if(curr < absDiff){
                l2.clear();
                List<Integer> l1 = Arrays.asList(arr[i],arr[i+1]);
                l2.add(l1);
                absDiff = curr;
            }else if( curr == absDiff){
                List<Integer> l1 = Arrays.asList(arr[i],arr[i+1]);
                l2.add(l1);
            }
            //if curr<absdiff > empty the list l2, and add the new ones,
            // cur>absDiff -> I need to ignore them, and I can't add inside that list
            //     curr == absDiff -> then cotinue adding it
        }
        return l2;
    }
}

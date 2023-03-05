package com.TutortAssignment.TutortAssignmentCodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class BuildArrayFromPermutation {
    public static void main(String[] args) {
        int[] nums = {0,2,1,5,3,4};
        buildArray(nums);
        HashMap<Integer,Integer> h;
        HashSet<Integer> hh;
        ArrayList<Integer> a;
        String s = " ";
        System.out.println(s.length());
    }
    public static int[] buildArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int z = nums[nums[i]];
            System.out.println("x" + temp);
            nums[i] = z;
            System.out.println("a" + nums[i]);
            nums[temp] = temp;
            System.out.println("b" + nums[z]);
        }
        return nums;
    }
}
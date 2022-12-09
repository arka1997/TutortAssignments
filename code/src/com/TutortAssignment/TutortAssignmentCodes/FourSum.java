package com.TutortAssignment.TutortAssignmentCodes;

import java.util.ArrayList;
import java.util.List;

class FourSum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> lists = fourSum(nums, target);
        System.out.println(lists);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<Integer> l1 = new ArrayList<>();
        List<List<Integer>> l2 = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int p1=j+1;
                int p2 = nums.length-1;
                while(p1<p2){
                    // here every time keep ith & jth element fixed for two sum, and then perform the operaion on the rest of the array for the two sum, which becomes total 4sum.
                    if((nums[p1]+nums[p2]+nums[i]+nums[j])==target){
                        l1.add(nums[p1]);
                        l1.add(nums[p2]);
                        l1.add(nums[i]);
                        l1.add(nums[j]);
                        l2.add(l1);
                        // l1.clear();
                        p1++;
                        p2--; 
                    }else if((p1+p2)<target){
                        p1++;
                    }else{
                        p2--;
                    }
                }
            }
        }
        return l2;
    }
}
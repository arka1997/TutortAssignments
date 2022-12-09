package com.TutortAssignment.TutortAssignmentCodes;

import java.util.HashMap;

class TwoSumBruteForce_And_Optimized {
    public static void main(String[] args) {
        int nums[] = {3,2,4,3};
        int target = 6;
        int[] ints = twoSum(nums, target);
    }
    //BruteForce -> Here we can take two Loops OR pointers one will traverse from 0 to N, other will traverse from 0+1 to N, from every elemnt of first loop, t find the target
//     Good Approach: Here we can sort the Array first, then we use two pointers, p1 = 0, p2 = n-1. Now we traverse and check if p1 +p2 == target, if(p1 +p2>target)=> then we do p2--, if(p1 +p2<target)=> then we do p1++, T.C -> O(nlog n)
//     Best Approach using HashMap with O(n).
//     Sorted Approach
    public static int[] twoSum(int[] nums, int target) {
        
        // funcApproachOne(nums,target);
        
        return funcOptimizedApproachSecond(nums,target);
        
    }
//     Approach 2
    public static int[] funcOptimizedApproachSecond(int[] nums, int target){
//       Approach takes O(n) TC. Now we tarverse the array and go on inserting elemnts in the HashMap if the "target-nums[j]" elemnt is not contained previously. If it is present an dwe found it, then we will just return a new array, with the index at arr[0] and the "target-nums[j]" at arr[1]
        
        HashMap<Integer,Integer> h1 = new HashMap<>();
        int arr[]=new int[2];
        for(int j=0;j<nums.length;j++){
            if(h1.get(target-nums[j])!=null){
                return new int[]{j,h1.get(target-nums[j])};
            }
            h1.put(nums[j],j);
        }
        return arr;
    }
    
// Approach1
    public int[] funcApproachOne(int[] nums, int target){
        int arr[]=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            int val=target-nums[i];
            for(int j=i+1;j<nums.length;j++)
            {
                if(val==nums[j])
                {
                    arr[0]=i;
                    arr[1]=j;
                }
            }
        }
        return arr;
    }
}
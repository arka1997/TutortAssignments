package com.TutortAssignment.TutortAssignmentCodes;

import java.util.*;

class FourSum {
    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        List<List<Integer>> lists = fourSum(nums, target);
        System.out.println(lists);
    }
        public static List<List<Integer>> fourSum(int[] nums, int target) {
            // Here it is said, that suppose we target 7, [2,2,1,2], so here, if we do 4Sum, we can have patterns like [2,2,2,1] OR [2,1,2,2] OR....So we can have different patterns with same values, that equals to "target". So we don't want that. So we use "SET", which doesn't allow duplicates.

            Arrays.sort(nums);
            List<List<Integer>> l2 = new ArrayList<>();
            for(int i=0;i<nums.length-3;i++){
                if(i>0&&nums[i]==nums[i-1]){
                    continue;
                }
                //here ywe check current elemnt with next elemnt, and not the previous element using "nums[i-1]" beacuse we miss one case for [-2,0,0,1] in arr =[-2,-1,0,0,1,2], where j need to be in index =2, and p1 will start form the next zero elemnt. but if we firstly check with nums[i] & nums[i+1], then we skip while j=2, and shift j to 3, so we miss the edge case
                for(int j=i+1;j<nums.length-2;j++){
                    if(j>i+1&&nums[j]==nums[j-1]){
                        continue;
                    }
                    int p1=j+1;
                    int p2 = nums.length-1;
                    while(p1<p2){
                        long sum = nums[p1]+nums[p2];
                        sum += nums[i];
                        sum += nums[j];
                        // here every time keep ith & jth element fixed for two sum, and then perform the operaion on the rest of the array for the two sum, which becomes total 4sum.
                        if(sum==target){
                            //here we are taking the ArrayList Input because we want a new Object of ArrayList  everytime while storing in l2.
                            l2.add(Arrays.asList(nums[p1],nums[p2],nums[i],nums[j]));
                            while(p1<p2&&nums[p1]==nums[p1+1]) {
                                p1++;
                            }
                            while(p1<p2&&nums[p2]==nums[p2-1]){
                                p2--;
                            }
                            p1++;
                            p2--;
                        }else if(sum<target){
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
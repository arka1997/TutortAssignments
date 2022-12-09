package com.TutortAssignment.TutortAssignmentCodes;

import java.util.Arrays;

public class MajorityElementBruterForce_And_Optimized {
    public static void main(String[] args) {
        int[] nums = {1,3,1,1,4,1,1,5,1,1,6,2,2};
        //         Code need to be refactored, sorting will take O(nlogn). So we should go for other approach without HashMap to get O(n)
// Approach1
        // goodApproach(nums);

// Approach2
        int possibleMajority = bestOptimizedApproach(nums);
        int count =0;
        int arrLen=nums.length/2;
        if(nums.length==1){
            System.out.println(nums[0]);
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==possibleMajority){
                count ++;
            }else if(count > (arrLen/2)){
                System.out.println(possibleMajority);
                break;
            }
        }
    }
        public int majorityElement(int[] nums) {
//         Code need to be refactored, sorting will take O(nlogn). So we should go for other approach without HashMap to get O(n)
// Approach1
            // goodApproach(nums);

// Approach2
            int possibleMajority = bestOptimizedApproach(nums);
            int count =0;
            int arrLen=nums.length/2;
            if(nums.length==1){
                return nums[0];
            }
            for(int i=0;i<nums.length;i++){
                if(nums[i]==possibleMajority){
                    count ++;
                }else if(count > (arrLen/2)){
                    return possibleMajority;
                }
            }
            return possibleMajority;
        }
        public static int bestOptimizedApproach(int[] nums){
            int j=0;
            int val = 0;
            int count = 1;
            for(int i=1;i<nums.length;i++){
                val = nums[j];
                // if we have non-matching elemnts like [1,1,2,3,4], & i=2 then we simply map 1's with the non-matching, and decrease the value of count, now when all similar 1's, have found their nonmatching partners, then then we set the last elemnt inside val, for which the mapping has been done, and count reached zero.'
                if(val!=nums[i]){//here first check if val is not equalto the elemnt,if yes, then we decrease the count, and if count becomes zero, then we simply update the value of "val" & "count", as well as j.
                    --count;
                    // NOTE: Mapping is done, here, like [2,3,1,2,2] -> here count of 2 is greater then other numbers, and when we map 2 with other different pairs, there's always extra number will left, here "2", which is our majority elemnt.Pairs are 2->3,2->1, and a last number will always be there which cannot pair, and that's our majority number, here 2.
                    if(count==0){
                        j=i;
                        val = nums[j];
                        count =1;
                    }
                }else if(val==nums[i]){
                    // if we have similar elements, then we increase the value of count
                    count ++;
                }
            }
            return val;
        }
        public int goodApproach(int[] nums){
            Arrays.sort(nums);//1 1 1 2 2 2 2
            int i=0;
            int count=1;
            while(i<nums.length-1){
                if(nums[i+1]==nums[i]){
                    count++;
                }else{
                    if(nums.length/2<count){
                        count=1;
                        return nums[i];
                    }
                }
                i++;
            }
            return nums[i];
        }
    }
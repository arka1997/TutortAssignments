package com.TutortAssignment.TutortAssignmentCodes;

public class Maximum_ConsecutiveOnes_III {
    //    SlidingWindow Approach
//    Second Approach using 3 variables, same thing we do for 3rd max elemnts, so in same way, we will store three indexes of "0" in 3 different variables and find max
//    Taking two pointers, which will be pointing to -1. There weill be two situation: i) when our "zCnt" is > the zero, then we violate, and decrease "zCnt" by 1 and increase "s" by 1.
//  ii)  when "zCnt" <= 1, then
    public static void main(String[] args) {
        int nums[] = {0,0,1,0,1,0,1,0,0,0,1,0};
        int nums1[] = {1,0,1,1,0};
        int nums2[] = {0,0,0,1};
        int nums3[] = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        System.out.println(maximum_ConsecutiveOnes_II(nums3,k));
    }
    public static int maximum_ConsecutiveOnes_II(int nums[],int k) {
        int s = 0, e = 0;
        int max = Integer.MIN_VALUE;
        int zCnt = 0;//Here on the basis of variable, we do the max calc, always we see between two zeros at two different ends, we have a "zero" at the center. Sliding window here is done on basis of
//Here we move pointer "e", when until zCnt <=1, and creating a sliding window with 3 zeros in it.
        while(e<nums.length&&s<=e){
            if(zCnt<k){
//                here we are only increasing the zCnt when "e" points to 0. Now when zCnt becomes 2,
                if(nums[e]==0){//if the elemnt "e" is pointing is equalto zero, then we increase the "zCnt". And we do this until we get a zero of count = 2, we are limitting to 2 because in each SlidingWindow here, there is always 3 zeroes involved, when we calculate the max.
//                    Two zero, at two ends, and 1 in the middle, and this middle zero is cosidered or flipped to 1. Now we do Index calculation from rightIndexOfZero -lefttIndexOfZero -1.
                    zCnt++;
                }
                e++;//when pointer "e" is pointing to 1, then we simply move pointer to next index
            }else if(zCnt>=k){//zCnt when increments to 3 in 1st "if" block, then this second "if" block also executes simultaneously
                // here we increse pointer "s", to the next position and decrese the zCnt by 1 when elemnt "s" is pointing to is ZERO.
                if(nums[s] == 0) {
                    zCnt--;
                }
                s++;//when pointer "s" is pointing to 1, then we simply move s
            }
            max = Math.max(max,e-s);
        }
        return max;
    }
}
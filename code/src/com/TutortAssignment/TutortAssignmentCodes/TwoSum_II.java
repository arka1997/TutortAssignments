package com.TutortAssignment.TutortAssignmentCodes;

import java.util.Arrays;

class TwoSum_II {
    public static void main(String[] args) {
        int numbers[] = {5,25,75};
        int target = 100;
        System.out.println(Arrays.toString(twoSum(numbers,target)));
    }
    public static int[] twoSum(int[] numbers, int target) {
        // remove duplicates
        //start from index =1 of an Array
//         -1000 <= numbers[i] <= 1000 -> for these range, we can conside using "int"
//         Base Approach -> Take 2 loops, first loop, will point to index 1 -> n, and second loop will start from 2 -> n. Now for each elemnt of first loop, we traverse the 2nd loop, to find it's pair.
//         Optimized Binary Search approach ->First we have to pick one elment from the Array, and then substract it with target, then send that value to the new method, where that number will be searched in the array. if found then return the index, other wise returns -1;
        int l=0;
        int r = numbers.length;
        int arr[] = new int[2];
        arr[0]=-1;
        arr[1] = -1;
        while(l<=r){
            int scndPair = target-numbers[l];
            int returnVal = func(numbers,scndPair,l+1,r,target);
            if(returnVal!=-1){
                arr[0]=l+1;
                arr[1]=returnVal+1;
                return arr;
            }
            System.out.println(l);
            l++;
        }
        return arr;
    }
    public static int func(int numbers[],int scndPair,int l, int r,int target){
        while(l<r){
            int mid = l+(r-l)/2;
            if(numbers[mid]==scndPair){
                return mid;
            }else if(numbers[mid]>scndPair){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return -1;
    }
}
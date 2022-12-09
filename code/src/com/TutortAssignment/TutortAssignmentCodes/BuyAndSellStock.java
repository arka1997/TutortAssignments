package com.TutortAssignment.TutortAssignmentCodes;

import java.sql.Array;

class BuyAndSellStock {
    public static void main(String[] args) {
        int arr[] = {7,4,5,2,6};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {
//         we will only traverse towards the front of the array. Now suppose, on the 1st day, we have a big number "7", now we will search the entire array for another bigger number, with the max difference between both of them. If not found , then go to the second day, and do the same
        // Bruteforce with 2 loopsO(n^2) =>we need a loop to traverse the array, another loop is needed to check and found out the max price difference between 1st day compared with the the rest of the other days.
        //Optimized aproach -> we can take the array prices[], and use a loop. Then we use ith pointer starting from end "n" point. Now when we traverse from back, we check if the ith elemnt is greater then (i-1)th pevious elemnt, if yes, then we move to (i-1)th elemnt and change it to the ith same element, if no, then we ignore. In these way we will have have the gretest number. like [7236] => 7666, so at a particular position which is greater, we calculate that. and then we subtarct between the old array and new array.

        int max = Integer.MIN_VALUE;
        int maxRange[] =new int[prices.length];
        for(int i=prices.length-1;i>=0;i--){
            if(prices[i]>max){
                maxRange[i] = prices[i];
                max = prices[i];
            }else{
                maxRange[i] = max;
            }
        }
        for(int i=0;i<prices.length;i++){
            System.out.println("a"+maxRange[i]);
        }
        max = Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            int diff = maxRange[i]-prices[i];
             System.out.println(diff);
            if(max<diff){
                max = diff;
            }
        }
        return max;
    }
}
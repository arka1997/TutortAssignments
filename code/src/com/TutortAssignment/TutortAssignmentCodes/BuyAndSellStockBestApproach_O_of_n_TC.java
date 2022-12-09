package com.TutortAssignment.TutortAssignmentCodes;

class BuyAndSellStockBestApproach_O_of_n_TC {
    public static void main(String[] args) {
        int arr[] = {7,1,5,4,12,2};
        System.out.println(funcSecondApproach(arr));
    }
    public int maxProfit(int[] prices) {
//         we will only traverse towards the front of the array. Now suppose, on the 1st day, we have a big number "7", now we will search the entire array for another bigger number, with the max difference between both of them. If not found , then go to the second day, and do the same
        // Bruteforce with 2 loopsO(n^2) =>we need a loop to traverse the array, another loop is needed to check and found out the max price difference between 1st day compared with the the rest of the other days.
        //Optimized aproach1 -> we can take the array prices[], and use a loop. Then we use ith pointer starting from end "n" point. Now when we traverse from back, we check if the ith elemnt is greater then (i-1)th pevious elemnt, if yes, then we move to (i-1)th elemnt and change it to the ith same element, if no, then we ignore. In these way we will have have the gretest number. like [7236] => 7666, so at a particular position which is greater, we calculate that. and then we subtarct between the old array and new array.
//          Optimized Approach2: 
        // Approach 1:
        // funcFirstApproach(prices);
        
        //Approach2:
        return funcSecondApproach(prices);
    }
    
    public static int funcSecondApproach(int[] currPrices){
        System.out.println("7,1,5,3,6,4");
//         traverse the loop and the check for the minimum upto the current posiotion, like if we are index 3, then we will keep a record of the minimum so far upto that 3rd index in "minSoFar".
        int minSoFar = Integer.MAX_VALUE;//this pointer will store the minimum upto the current position.
        int maxProfit = 0;//this will store the max difference between current ith elemnt and "minSoFar" element.
        int diff = 0;
        for(int i=0;i<currPrices.length;i++){
//             A small block to update minSoFar with the minimum element
            if(currPrices[i]<minSoFar){
                minSoFar = currPrices[i];
            }
            diff = currPrices[i]-minSoFar;
            if(diff>maxProfit){
                maxProfit=diff;
            }
        }
//        2,4,1,2
                // 7,1,5,0, 6,3
                // 7,1,5,4,12,2
        return maxProfit;
        }
        // for(int j=index+1;j<prices.length;j++){
        //     int diff= prices[j] - minSoFar;
        //     if(diff>maxProfit){
        //         maxProfit = diff;
        //     }
        // }
    
    public int funcFirstApproach(int[] prices){
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
//         Consider two pointer, one will check if the next element is bigger then current element, if yes, then we calculate the difference, and store in variable "maxProfit". 
    }
}
package com.TutortAssignment.TutortAssignmentCodes.DP;

import java.util.Arrays;

class CoinChange {
    static int minCoinCnt = Integer.MAX_VALUE;
    static int dp[][];

    public static void main(String[] args) {
        int []coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }
    public static int coinChange(int[] coins, int v) {
        
        // return coinChangeRecursion2(coins,v,coins.length);

    dp = new int[coins.length][v];//Pick items, and at different levls of V, each of the coins will hve unique data. Like for V=3, coins{1,2,3}, will give a different value then v=2 for coins{1,2,3}

        for(int arr[]:dp){
            Arrays.fill(arr,-1);
        }
    minCoinCnt = coinChangeDP(coins,v,0,0);
//  minCoinCnt=coinChangeRecursion1(coins,v,0,0);
         if(minCoinCnt==Integer.MAX_VALUE){//If there are no coins that can make amount=0, then value minCoinCnt, will not be updated, and holding max value, then return -1
             return -1;
         }
        return minCoinCnt;
    }

    // DP->Memoization
    public static int coinChangeDP(int[] coins, int amount, int i, int cnt) {
        if(amount==2&&i==1){
            System.out.println("abc");
        }
        if(amount==0){
            return cnt;
        }
        // we should store the value  of "cnt" in DP

        int ans=0;

//        int minCoinCnts = Integer.MAX_VALUE;
        if(dp[i][amount-1]!=-1){
            return dp[i][amount-1];
        }
        if(dp[i][amount-1]==-1){
            for(;i<coins.length;i++){
                if(amount-coins[i]>=0){//Here in some cases it will not enter this block, and won't update the minCoinCnts, and by default "Max_Value" is returned.
                    ans = coinChangeDP(coins,amount-coins[i],i,cnt+1);
                    minCoinCnt = Math.min(ans,minCoinCnt);
                    dp[i][amount-1] = minCoinCnt;
                    // System.out.println("Inside"+dp[i][amount]);
                }
            }
        }
        return minCoinCnt;//Either it will return he updated value of "minCoinCnt" or simply return the global min Value
    }
    // Recursion 1
    public int coinChangeRecursion1(int[] coins, int v,int i,int cnt) {
        if(v==0){
            return minCoinCnt = Math.min(minCoinCnt,cnt);
        }
        for(;i<coins.length;i++){
            if(v-coins[i]>=0){
                coinChangeRecursion1(coins,v-coins[i],i,cnt+1);
            }
        }
        return minCoinCnt;
    }

    // Recursion 2
    public int coinChangeRecursion2(int[] coins, int amount,int n) {
    if (amount == 0) {
        return 0;
    }
    if (n == 0 && amount > 0) {
        return -1;
    }
    if (coins[n - 1] > amount) {
        return coinChangeRecursion2(coins, amount, n - 1);
    }
    // Recursive case:
    // Calculate the number of ways to make the target value using the current coin
    // and the number of ways to make the target value without using the current coin.
    int includeCoin = coinChangeRecursion2(coins, amount - coins[n - 1], n);//Include means we decrease the amount by coins and also keep the length fixed, and go on decrease the amount with the (n-1)th coin. 
    int excludeCoin = coinChangeRecursion2(coins, amount, n - 1);//Here we exclude by going to next index, and then again make recursion calls.
    
    //This will basically calculATE A COUNT ON BASIS OF CONDITIONS
    if (includeCoin == -1 && excludeCoin == -1) {//this is when both our include and exclude has reached end, and there is no coins that make the amount to zero, and amnt still >0, then return -1
        return -1;
    } else if (includeCoin == -1) {//If include couldn't make amount to 0, but the exclude which calculates the previous back result from end return non-zero elemnt, then increase the count of exclude+1.
        return excludeCoin + 1;
    } else if (excludeCoin == -1) {
        return includeCoin + 1;
    } else {//else, if both has got some non-zero results that has reduced the amount to 0, then simply return the min of them for getting the one using Min coins
        return Math.min(includeCoin + 1, excludeCoin);
    }
    }   
}
package com.TutortAssignment.TutortAssignmentCodes.DP;

class SubSetSum{

    //Here we use Object "Boolean" and not primitive "boolean"
    //because by default "null" is initialized in "Boolean" array,
    //whereas by default "false" is initialized for "boolean" Array.
    static Boolean dp[][];
    static boolean dp2[][];
    static Boolean isSubsetSum(int N, int arr[], int sum){
        dp=new Boolean[N][sum+1];//stores null by default as Object type
        dp2=new boolean[N+1][sum+1];//stores false as default being primitive type
        // return checkIsSubsetSumDP(arr,sum,N);
        return checkIsSubsetSumTabular(arr,sum,N);
    }
    static Boolean checkIsSubsetSumTabular(int nums[],int sum,int n){
        // For Empty List if sum == 0, then true, but
        // For Empty List, if sum > 0, then false for the rest.
        for(int i = 0;i<=n;i++){
            dp2[i][0] = true;
        }
        for(int j = 1;j<=n;j++){
            for(int indSum = 1;indSum<=sum;indSum++){
                // by default exclude case is false, only turn those indexes true which satisfies edge case

                boolean notTake = dp2[j-1][indSum];//For exclude case, we always get the value of its previous one, whicle backtracking to Top
                boolean take = false;//if current Number greater then Sum, then exclude, so initially it's defined as false
                if(nums[j-1]<=indSum){//if current number is small or equalto TargetSum, then include, and when we include, we subtract thesum from current Number
                    int prevIndexSum = indSum - nums[j-1];//Here for include we subtract index = sum - currentNumber, and get the index of the subtraction, and that index is already calculated, as we are backtracking, so put the values in dp[curreIndex]=dp[index]
                    take = dp2[j-1][prevIndexSum];
                }
                dp2[j][indSum] = take || notTake;
            }
        }
        return dp2[n][sum];
    }


    static Boolean checkIsSubsetSumDP(int nums[],int sum,int i){

        if(sum==0){
            return true;
        }
        if(i<=0){//[sum > 0] and not [sum !=0] to check for both positive and negative result of sum
            return false;
        }
        if(dp[i-1][sum]==null){
            if(nums[i-1]<=sum){//include & exclude
                dp[i-1][sum] = checkIsSubsetSumDP(nums,sum-nums[i-1],i-1)||checkIsSubsetSumDP(nums,sum,i-1);

            }else{
                dp[i-1][sum] = false;
                return checkIsSubsetSumDP(nums,sum,i-1);
            }
        }
        return dp[i-1][sum];
    }
}
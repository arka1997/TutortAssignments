package com.OracleHealth;//{ Driver Code Starts
import java.io.*;
import java.util.*;

class SubsetTargetSum
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            SubsetTargetSumSub ob = new SubsetTargetSumSub();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class SubsetTargetSumSub{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        List<Integer> addRemvArr = new LinkedList<>();
        return checkIsSubsetSum(N,arr,sum,N);
    }
    static Boolean checkIsSubsetSum(int N, int nums[], int sum,int i){
        if(sum==0){
            return true;
        }
        if(sum<0 && i==0){//[sum > 0] and not [sum !=0] to check for both positive and negative result of sum
            return false;
        }
        if(nums[i-1]>=sum){
            checkIsSubsetSum(N,nums,sum,i-1);
        }else{
            boolean b = checkIsSubsetSum(N, nums, sum - nums[i - 1], i - 1) || checkIsSubsetSum(N, nums, sum, i - 1);
        }
        return null;
    }
}
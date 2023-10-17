package com.TutortAssignment.TutortAssignmentCodes.DP;//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class LongestCommonSubstring

{
    static int dp[][];
    public static void main(String args[])throws IOException
    {
        // Time Complexity = 3^n, as 3 rexursion calls is made
        // return longestCommonSubstrRecursion(s1,s2,n,m,0);
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        int n = s1.length();
        int m = s2.length();
        // Initialize the dp array with -1 (to indicate that it's not yet computed).
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // code here
        System.out.println(longestCommonSubstrDP(s1, s2, n, m, 0));
    }

    static int longestCommonSubstrDP(String s1, String s2, int n, int m, int countofLongest) {
        if (n == 0 || m == 0) {
            return countofLongest;
        }

        // If the result is already computed, return it from the dp array.
        if (dp[n - 1][m - 1] != -1) {
            return dp[n - 1][m - 1];
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n - 1][m - 1] = longestCommonSubstrDP(s1, s2, n - 1, m - 1, countofLongest + 1);
        } else {
            dp[n - 1][m - 1] = Math.max(countofLongest, Math.max(
                    longestCommonSubstrDP(s1, s2, n - 1, m, 0),
                    longestCommonSubstrDP(s1, s2, n, m - 1, 0)
            ));
        }

        return countofLongest;
    }
}
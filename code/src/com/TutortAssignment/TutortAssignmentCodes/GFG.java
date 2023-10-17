package com.TutortAssignment.TutortAssignmentCodes;//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    ArrayList<Integer> A = new ArrayList<Integer>();
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		        A.add(arr[i]);
		        
		    }

			System.out.println(A);
		    
		    ArrayList <ArrayList<Integer>> res = new Solution().subsets(A);
		    for (int i = 0; i < res.size (); i++)
		    {
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		          System.out.print(res.get(i).get(j)+" ");
		        }
		        System.out.println();
		      
		    }
		    //System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{   
    static ArrayList<ArrayList<Integer>> l2;
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A)
    {
        //So here we can take the Item/value = 3, as it's weight is 1<W => 1<4. 
        //  We can aslo have 1 as item/value, as it's weight is 4, but we will pick the max value subset, 
        // such that sum of Values doesn't becomes greater then given weights(W)
        List<Integer> l = new ArrayList<>();
		l2 = new ArrayList<ArrayList<Integer>>();
		Collections.sort(l2, (o1, o2) -> {
			int n = Math.min(o1.size(), o2.size());
			for (int i = 0; i < n; i++) {
				if (o1.get(i).equals(o2.get(i))) {
					continue;
				}
				else {
					// sort based on the unequal elements value
					return o1.get(i) - o2.get(i);
				}
			}
			// sort based on size
			return o1.size() - o2.size();
		});

		// Print the sorted ArrayList of ArrayLists
		for (ArrayList<Integer> innerList : l2) {
			System.out.println("x: "+innerList);
		}
//		System.out.println(A);
        return subsetsRecusrion(A,l,A.size());
        
    }
    static ArrayList<ArrayList<Integer>> subsetsRecusrion(ArrayList<Integer> A,List<Integer> l, int n) 
    {

        if(n==0){
            l2.add(new ArrayList<Integer>(l));
            // System.out.println(l2);
            return l2;
        }
        // if(A.size()==0){
        //      return l2;
        // }
        l.add(A.get(n-1));
        subsetsRecusrion(A,l,n-1);
        l.remove(l.size()-1);//don't use 'n', as we need the current size
        subsetsRecusrion(A,l,n-1); 
        return l2;
    }
}
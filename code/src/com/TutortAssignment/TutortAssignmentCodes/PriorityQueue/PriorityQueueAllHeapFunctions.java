package com.TutortAssignment.TutortAssignmentCodes.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PriorityQueueAllHeapFunctions {
//{ Driver Code Starts
//Initial Template for Java

        // Driver Code
        static class FastReader{
            BufferedReader br;
            StringTokenizer st;

            public FastReader(){
                br = new BufferedReader(new InputStreamReader(System.in));
            }

            String next(){
                while (st == null || !st.hasMoreElements()){
                    try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); }
                }
                return st.nextToken();
            }

            String nextLine(){
                String str = "";
                try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); }
                return str;
            }

            Integer nextInt(){
                return Integer.parseInt(next());
            }

            Long nextLong(){
                return Long.parseLong(next());
            }
        }

        public static void main(String args[])
        {
            FastReader sc = new FastReader();
            PrintWriter out = new PrintWriter(System.out);
            int t = sc.nextInt();

            while(t>0)
            {
                int n = sc.nextInt();
                long arr[] = new long[n];

                for(int i=0; i<n; i++) {
                    arr[i] = sc.nextLong();
                }
                out.println(new Solution().minCost(arr, n));
                t--;
            }
            out.flush();
        }
    }
// } Driver Code Ends


    class Solution
    {
        static int min = Integer.MAX_VALUE;
        static int n = -1;
        //Function to return the minimum cost of connecting the ropes.
        long minCost(long arr1[], int s)
        {
            return heapInbuiltFunction(arr1,s);
            // 5 +9 +15
            // 7+9+15
            // 10+13+15
            // 5 +10+15
            // 5 + 11 + 15
            // so basically we are starting from the smallest ropes, and then going to bigger ones, so that the cost doen't increase much
            // create a min heap from the array
            // Then repeat te below process upto Heap Count becomes less then 1
            //     *Call getMin() for 1st index & 2nd index.
            //     *Add them up, and store it in a variable for maintining the cost
            //     *Then delete the previous 2 indexes from Heap using Percolate Down
            //     *Now, what we can do here
        }
        long heapInbuiltFunction(long arr1[], int s){
            // copying to new Array for running the inbuilt methods and for insertion correctly, otherwise preoblm arises due to size
            long arr[] = new long[30];
            for(int i=0;i<s;i++){
                n=n+1;
                arr[n] = arr1[i];

            }
            n=n+1;
            int strtIndx = (n/2)-1;//to get the index of last Non-Leaf Node
            for(int i=strtIndx;i>=0;i--){//here we are doing reverse level order Traversal starting from Last Non-Leaf Node to Root
                min = i;//declaring the default Node as currentmin
                buildHeap(arr, n, i);
            }
            return calcCostOfRopes(arr,n);
        }


        long calcCostOfRopes(long[] arr, int size){
            int sum = 0;
            int minCost = 0;
            int i=0;
            // int size = n;
            while(i<(size-1)){
                sum += extractMin(arr)+extractMin(arr);
                minCost += sum;
                insert(arr,sum);
                sum = 0;
                i++;
            }
            return minCost;
        }

        void buildHeap(long[] arr, int size, int i){
            //first get the LeftLeaf and RightLeaf Index of the 1st NonLeaf Node. Find the min out of 3, and replce the current Node with that
            int l = 2*i+1;
            int r = 2*i+2;
            if(l<size && arr[min]>arr[l]){
                min = l;
            }
            if(r<size && arr[min]>arr[r]){
                min = r;
            }
            //then swap, if the min index is different from "i"
            if(min!=i){
                swap(arr,min,i);
                buildHeap(arr,size,min);
            }
        }
        // here get the min Element from Min Heap, and then delete it.
        long extractMin(long[] arr){
            long minVal = arr[0];

            min = 0;
            arr[0] = arr[n-1];
            n = n - 1;
            // printHeap(arr);
            shiftDown(arr,min,n);
            // printHeap(arr);
            return minVal;
        }
        void shiftDown(long arr[], int min, int size){
            int l = 2*min+1;
            int r = 2*min+2;
            int temp = min;
            if(l<size&&arr[l]<arr[min]){
                min = l;
            }
            if(r<size&&arr[r]<arr[min]){
                min = r;
            }
            if(min!=temp){
                swap(arr,min,temp);
                shiftDown(arr,min,size);
            }
        }
        void insert(long arr[], int newSum){
            n = n + 1;//increase size of n
            arr[n-1] = newSum;//add the newNode at the end of Heap
            shiftUp(arr,n-1,newSum);//then do percolate Up to heapify
        }
        void shiftUp(long arr[], int pIndex,int newSum){
            while(pIndex>0 && newSum<arr[parent(pIndex)]){
                swap(arr,parent(pIndex),pIndex);
                pIndex = parent(pIndex);
            }
        }
        int parent(int index){
            return (index-1)/2;
        }
        void swap(long[] arr, int p,int i){
            long temp = arr[i];
            arr[i] = arr[p];
            arr[p] = temp;
        }
        void printHeap(long[] arr){
            for (int i = 0; i < n; ++i)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
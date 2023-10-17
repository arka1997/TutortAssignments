package com.OracleHealth;

import java.io.*;
import java.util.*;
import java.util.ArrayList;

class Solution{
    
    private static final List<Integer> elems = new ArrayList<Integer>();
    private static int elemsSize = 0;
    
    public static void main( String args[] ) throws Exception{
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int numOfOps = Integer.parseInt(br.readLine().trim());
        
        String[] command = null;
        for (int i = 0; i < numOfOps; i++){
            command = br.readLine().trim().split(" ");
            if (command[0].equals("a"))
                addElem(Integer.parseInt(command[1]));
            else
                removeElem(Integer.parseInt(command[1]));
        }
    }
    
    private static void addElem(int elem){
        int pos = Collections.binarySearch(elems, elem);//if an elemnt is not present in List, then return -1 as position
        if (pos < 0)//if the pos is -1, then we simply do -(-1) -1 = 0, thus going to next index, for inserting the elemnt in an empty index
            pos = -pos - 1;
        elems.add(pos, elem);
    	elemsSize++;
    	printMedian();
    }
    
    private static void removeElem(int elem){
        int pos = Collections.binarySearch(elems, elem);
        if (pos < 0) {
//            System.out.println("Wrong!");
            }
        else{
            elems.remove(pos);
            elemsSize--;
            printMedian();
        }
    }
    
    private static void printMedian(){
        System.out.println(elemsSize);
        if (elemsSize > 0){
            if (elemsSize % 2 == 1) {
                System.out.println(elems.get(elemsSize/2));//for odd, simply return middle element
            }else{
                long median = (long)elems.get(elemsSize/2) + (long)elems.get((elemsSize/2) - 1);
                if (median % 2 == 0) {
                    System.out.format("%d%n", median/2);
                }
                else {
                    System.out.format("%.1f%n", median/2.0);
                }
            }
        }
        else{
//            System.out.println("Wrong!");
            return;
    	}
    }
}
//import java.math.BigDecimal;
//        import java.io.*;
//        import java.util.*;

//class Solution{
//    static List<Integer> addSortArr = new ArrayList<>();
//    static int elemsSize = 0;
//    public static void main(String[] args) {
//        List<Character> opt = new ArrayList<>();
//        List<Integer> arr2 = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        for(int i = 0; i<N; i++){
//            opt.add(sc.next().charAt(0));
//            arr2.add(sc.nextInt());
//        }
//        for(int j = 0; j<N; j++){
//            if(opt.get(j)=='r'){
////remove element
//                rmvEle(arr2.get(j));
//            }else if(opt.get(j)=='a'){
////add element
//                addEle(arr2.get(j));
//            }
//        }
//    }
//
//    private static void rmvEle(int val) {
//        int pos = Collections.binarySearch(addSortArr, val);//for removing also, we check if element exist in Array, if yes, we return the index
//        //but there are 2 scenarios i) no. to be removed is present in Array ii) No. to be removed is not present in Array
//        if(pos<0){
//            System.out.println("Wrong!");
//        }else{
//            addSortArr.remove(pos);
//            elemsSize--;
//            medianEvenOdd();
//        }
//    }
//
//    private static void addEle(int val) {
////        this function returns the index, if the searched "val" is found in that array,BUT,
////        if the value doesn't exist then it will return the index at which it should be present if it exist in that array while maintaining the sorted order.
//        int pos = Collections.binarySearch(addSortArr, val);
//        if(pos<0){
//            pos = -pos - 1;
//        }
//        addSortArr.add(pos,val);
//        elemsSize++;
//        medianEvenOdd();
//    }
//
//    private static void medianEvenOdd() {
//        if(elemsSize>0) {
//            if (elemsSize % 2 == 0) {//for even Size
//                long median = (long)addSortArr.get(elemsSize/2) + (long)addSortArr.get((elemsSize/2) - 1);
//                if (median % 2 == 0)
//                    System.out.format("%d%n", median/2);
//                else
//                    System.out.format("%.1f%n", median/2.0);
////                int left = addSortArr.get(sizeOfSortArr / 2);
////                int right = addSortArr.get((sizeOfSortArr / 2) - 1);//Its for the oddMedian, to get the previous index value for calculating medium
////                float median = (left + right) / 2f;
////                BigDecimal number = new BigDecimal(median);
////                System.out.println(number.stripTrailingZeros().toPlainString());
//            } else {//for odd Size
//                int median = elemsSize / 2;
//                System.out.println(addSortArr.get(median));
//            }
//        }else{
//            System.out.println("Wrong!");
//        }
//    }
//}
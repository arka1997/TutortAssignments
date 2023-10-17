package com.OracleHealth;

import java.math.BigDecimal;
import java.util.*;

public class FindProcessorFromProcessorRepoMapperTest {
//    If median = 3.50, print = 3.5
//    if median = 3, print = 3

    static List<Integer> addSortArr = new ArrayList<>();
    public static void main(String[] args) {
        List<Character> opt = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i<N; i++){
            opt.add(sc.next().charAt(0));
            arr2.add(sc.nextInt());
        }
        for(int j = 0; j<N; j++){
            if(opt.get(j)=='r'){
//remove element
                rmvEle(arr2.get(j));
            }else if(opt.get(j)=='a'){
//add element
                addEle(arr2.get(j));
            }
        }
    }

    private static void rmvEle(int val) {
        int pos_i = Collections.binarySearch(addSortArr, val);//for removing also, we check if element exist in Array, if yes, we return the index
        //but there are 2 scenarios i) no. to be removed is present in Array ii) No. to be removed is not present in Array
        if(pos_i<0){
            System.out.println("Wrong!");
        }else{
            addSortArr.remove(pos_i);
            medianEvenOdd();
        }
    }

    private static void addEle(int val) {
//        this function returns the index, if the searched "val" is found in that array,BUT,
//        if the value doesn't exist then it will return the index at which it should be present if it exist in that array while maintaining the sorted order.
//        if an element is not present in List, then return -1 as position
//        if (pos < 0)//if the pos is -1, then we simply do -(-1) -1 = 0, thus going to next index, for inserting the elemnt in an empty index

        int pos_i = Collections.binarySearch(addSortArr, val);
        if(pos_i<0){
            pos_i = -pos_i -1;
        }
        addSortArr.add(pos_i,val);
        medianEvenOdd();
    }

    private static void medianEvenOdd() {
        int sizeOfSortArr = addSortArr.size();
        if(sizeOfSortArr>0) {
            if (sizeOfSortArr % 2 == 0) {//for even Size
                long left = (long)addSortArr.get(sizeOfSortArr / 2);
                long right = (long)addSortArr.get((sizeOfSortArr / 2) - 1);//Its for the oddMedian, to get the previous index value for calculating medium
                long median = (left + right);
                if (median % 2 == 0) {
                    System.out.format("%d%n", median/2);
                }
                else {
                    System.out.format("%.1f%n", median/2.0);
                }
            } else {//for odd Size
                int median = sizeOfSortArr / 2;
                System.out.println(addSortArr.get(median));
            }
        }else{
            System.out.println("Wrong!");
        }
    }
}

package com.TutortAssignment.TutortAssignmentCodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }
    public static List<List<Integer>> generate(int numRows) {
//         Note, at every ist index and the last index of each row like [1,2,1] OR [1,3,3,1], we see "1" is constant at both ends. We don't make any changes there. But we make changes in the mid while traversing.
//         now for tese we need two loops
        // first we need to take 2 loops-> one will go upto "numRows". Second loop will go in the range 0 to i(pointer in 1st Loop). As we see in Pascal's triangle, at 3rd step, there is 3 box, 4th step, has 4th box.
//        List<Integer> l4= Arrays.asList(1,2);
//        List<Integer> l3= Arrays.asList(4,5,6);
        List<List<Integer>> l2= new ArrayList<>();
//        l2.add(l4);
//        l2.add(l3);
//        System.out.println(l2.get(0).get(1));//this is how we traverse through arrayList within ArrayList for values

        for(int i=1;i<=numRows;i++){
            List<Integer> l1= new ArrayList<>();//here we kept it because every time we will be storing a new arrayList with ew data, otherwise old data , and new added data will be mixed up
//             Use this loop to print only the mid elemnts, and ignoring the corner values, i.e., "1"
            for(int j=0;j<i;j++){ //here we start from 1, as
                if(j==0||i==j+1){
                    l1.add(1);
                }else{
                    System.out.println("x"+l2.get(i - 2).get(j-1));
                    System.out.println("y"+l2);
                    System.out.println("yy"+l2);
                    System.out.println("z"+l2.get(i - 2).get(j));
                    l1.add(l2.get(i - 2).get(j-1) + l2.get(i - 2).get(j));
                }
            }
            System.out.println("a"+l1);
        l2.add(l1);
        }
        return l2;
    }
}
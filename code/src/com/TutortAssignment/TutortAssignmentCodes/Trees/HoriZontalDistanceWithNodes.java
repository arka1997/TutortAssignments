package com.TutortAssignment.TutortAssignmentCodes.Trees;


import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.stream.Collectors;

public class HoriZontalDistanceWithNodes {
    static Node root;
        class Node{
            Node left;
            Node right;
            int val;
            Node(int val){
                val = val;
                left=null;
                right = null;
            }
        }
        public static void main(String[] args) {
//          root = new Node(2);
            int level = 0 ;
            List<Integer> l1 = new LinkedList<Integer>();
            List<List<Integer>> l2 = new LinkedList<List<Integer>>();
            // return rightSideView2(root,level,l1);
            TreeMap<Integer,List<Integer>> h1 = new TreeMap<>();
            TreeMap<Integer, List<Integer>> integerListHashMap = horizontalDistance(root, level, 0, h1);
//        For printing values----->
            for(List<Integer> l:integerListHashMap.values()){
            l2.add(l);
            System.out.println(l);
        }
//        For printing trees----->
//            for(int l:integerListHashMap.keySet()){
//                System.out.println(l);
//            }
        }
    public static TreeMap<Integer, List<Integer>> horizontalDistance(Node root, int level, int hd, TreeMap<Integer, List<Integer>> h1)
    {
        if(root==null){
            return h1;
        }
        // NOW store in Map in 2 ways.
        // When, our key => H.D. is not found in HashMap, then we enter new key, and the corrosponding Node, with that HorizontalDistance.
        // Another is, when the current H.D. already exists in HashMap, then we simply search that key in Map, and add the new Node's value with the old one.
        if(h1.containsKey(hd)){
            h1.get(hd).add(root.val);
            System.out.println("1st: "+root.val);
        }else{
            h1.put(hd,new LinkedList<>());
            h1.get(hd).add(root.val);
            System.out.println("2nd: "+root.val);
        }
        // System.out.println("1st: "+hd);
        horizontalDistance(root.left,level+1,hd-1,h1);
        // System.out.println("2nd: "+hd);
        horizontalDistance(root.right ,level+1,hd+1,h1);
        return h1;
    }
}

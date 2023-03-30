package com.TutortAssignment.TutortAssignmentCodes.Trees;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class VerticalOrderTraversalOfBinaryTree {
    public static void main(String[] args) {
        Nodes root = null;
        Tree tree = new Tree();
//        Initialize the first Node, here root.
        String s = "3,9,20,N,N,15,7";
//        call the "insertNode()" method for inserting all Nodes
        root = tree.insertNode(s);
        verticalTraversal(root);
    }
    static int min=0;
    static int max=0;
    static Map<Integer, List<Integer>> map = new HashMap();
    public static List<List<Integer>> verticalTraversal(Nodes root) {
        List<List<Integer>> res = new ArrayList();
        if(root==null) {
            return res;
        }
        Queue<Nodes> qt = new LinkedList();
        Queue<Integer> qi = new LinkedList();
        qt.add(root);
        qi.add(0);//not root.val
        while(!qt.isEmpty()){
            int size = qt.size();
            Map<Integer,List<Integer>> tmp = new HashMap();
            for(int i=0;i<size;i++){
                // Here we pick the current Node, and it's current axis using "curr" & "idx"
                Nodes cur = qt.poll();
                int idx = qi.poll();
                if(!tmp.containsKey(idx)) {
                    tmp.put(idx, new ArrayList<Integer>());
                }
                tmp.get(idx).add(cur.val);
                // Here we maintain the min & max, so that we can print and all elemnts ito a List, from extreme positive end, to extreme negative end
                if(idx<min) {
                    min = idx;
                }
                if(idx>max) {
                    max = idx;
                }
                // Here we add two elements in queue, in one queue, we add current Node, and in the 2nd queue we add the axis positions like +1, -1, 0, ......
                if(cur.left!=null){
                    qt.add(cur.left);
                    qi.add(idx-1);
                }
                if(cur.right!=null){
                    qt.add(cur.right);
                    qi.add(idx+1);
                }
            }
            // Here sorting after every level ends,and after sorting we again add to a new "map" from "tmp"
            for(int key : tmp.keySet()){
                if(!map.containsKey(key)){
                    map.put(key, new ArrayList<Integer>());
                }
                List<Integer> list = tmp.get(key);
                Collections.sort(list);
                map.get(key).addAll(list);
            }
        }
        //here we are simply printing from the extreme negative end, to the extreme positive end, as that order is told to be followed
        for (int i=min; i<=max; i++){
            List<Integer> list = map.get(i);
            res.add(list);
        }
        return res;
    }
}
package com.TutortAssignment.TutortAssignmentCodes.Trees;

import java.util.*;

public class MaximmLevelSumOfBinaryTree {
    public static void main(String[] args) {
        Nodes root = null;
        Tree tree = new Tree();
//        Initialize the first Node, here root.
        String s = "1,7,0,7,-8,null,null";
//        call the "insertNode()" method for inserting all Nodes
        root = tree.insertNode(s);
        System.out.println(maxLevelSum(root));
    }
    public static int maxLevelSum(Nodes root) {
        // First we will traverse level by level, then do the sum of all the Nodes in that level. And keep a record of "sum" by storing in a map along with it's level. For this we will use BFS(Level Order)
        if(root==null){
            return -1;
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Nodes> q = new ArrayDeque<>();
        q.add(root);
        int sum = 0;
        int level=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Nodes curr = q.poll();//Here we remove one element from queue, and before deleting we add it's left & right child to the queue in the new Level.
                sum += curr.val;
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            map.put(level,sum);
            level++;
            sum = 0;
        }
        // WAY 1 -> One line calculation for getting the key of the max Value
        // int key = (int) Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();

        // WAY 2 -> Finding the max value first from the map. Then converting the map to entry Set and then traverse the SET to find the max value stored in "maxVar" and return the key.
        int maxVar = map.values().stream().max(Integer::compare).get();
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(m.getValue().equals(maxVar)){
                return m.getKey();
            }
        }
        return 0;
    }
}

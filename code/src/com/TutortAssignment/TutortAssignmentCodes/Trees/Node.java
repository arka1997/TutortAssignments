package com.TutortAssignment.TutortAssignmentCodes.Trees;

import java.util.LinkedList;
import java.util.Queue;

class Nodes {
    Nodes left;
    Nodes right;
    int val;
    public Nodes(int vals){
        val = vals;
        left=null;
        right = null;
    }
}
class Tree {
    //when a first Node is created then we simply declare a method to insert that Node
    Nodes insertNode(String s){
//        Splitting the array
        String[] str = s.split(",");
//        Inserting our firstNode in Queue
        Nodes root = new Nodes(Integer.parseInt(str[0]));
        Queue<Nodes> q = new LinkedList<>();
        q.add(root);
        int i=1;
        while(i<str.length){
            Nodes temp = q.remove();
            String currVal = str[i];
            if(!currVal.equals("N")&&!currVal.equals("null")){
//                Create left child of current Node
                temp.left = new Nodes(Integer.parseInt(str[i]));
                q.add(temp.left);
            }
            if(++i>=str.length){break; }
            currVal = str[i];
            if(!currVal.equals("N")&&!currVal.equals("null")){
//                Create right child of current Node
                temp.right = new Nodes(Integer.parseInt(str[i]));
                q.add(temp.right);
            }
            i++;
        }
        return root;
    }
}
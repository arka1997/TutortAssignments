package com.TutortAssignment.TutortAssignmentCodes.Trees;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SumTree {
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
        int level = 0 ;
    }

//    For doing the Tree Sum, we will follow PostOrder, becasue here Sum of left Node is calculated first => then Right Node => then the parent Node.And this order is "PostOrder"
    int sumNode(Node root){
        if(root==null){//edge case
//            This block will execute, whenever we have reached the last or deepest leaf Node.
            return 0;
        }
        return sumNode(root.left) + sumNode(root.right) + root.val;//Here one recursion call is made to shift towards left, and root.left gives => the Address part in left, which is storing the another Node in left half-side.
    }
}

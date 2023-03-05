package com.TutortAssignment.TutortAssignmentCodes.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTree {

    public static void main(String[] args) {
        Nodes root = null;
        Tree tree = new Tree();
//        Initialize the first Node, here root.
        String s = "1,2,3,4,N,5,N,6";
        root = tree.insertNode(s);

//        System.out.println("The height of binary tree is : "
//                + tree.findHeight(root,0));
        System.out.println("The deepest Node in binary tree is : "
                + HeightOfTree.deepestNode(root,0));
    }

    static int maxLevel = -1;
    static int resAtMaxLvl = -1;
    private static int deepestNode(Nodes root, int level) {
//        Approach 1:
//    for getting deepest Node, we simply need to track the max level which exists at the end of tree, and return the Node in that level
//        How to achieve that?
//        First I can create two recursion calls and increase the level at every recursion call. Becasue when we make a recursion call, we go to next Nodes down the tree on the next Level, so we keep a track of the level
//        And also keep the track of the Node at every level, so that when we are in the last level, we have the Node that exists there, and we simply return it.
//        Now we also store the level, and check if it is the max level or not, and also if yes, then we store the Node at that level
//        Approach 2:
//        Do level Order traversal, and maintain a count at every level. Then at last return the count as well as the last value.
        if(root==null){
            return 0;
        }
        resAtMaxLvl = deepestNode(root.left,level+1);
        System.out.println(root.val);
        resAtMaxLvl = deepestNode(root.right,level+1);
        System.out.println(root.val);
        if(level>maxLevel){
            maxLevel = level;
            resAtMaxLvl = root.val;
        }
        return resAtMaxLvl;
    }

//    public int findHeight(Node root, int i) {
////        Basically height of tree means, find the longest branch of that tree. And we know in Binary tree for every Node, we have only two branch, one is left and one is right. So, either of it will be the longest and give total height of tree. So thatswy we check
////        whose count is maximum between left & right. And that is our height of tree. So to achieve that, whenever we reach null, then we simply return -1. So, for a lastNode, we will pick max(ls & rs) when root == null, as no other node exists. So when edge case is reached we simply return -1 from both ls & rs like => max(ls, rs) +1 => max(-1,-1)+1, because for the last Node, we will not count as height of deepest Node is zero, and we slowly increase count as we go up. So for last Node max(-1,-1)+1 = 0. Now we add a extra 1 to keep a count of the root as well
//    if(root==null){
//        return -1;//Here we return -1. becasue from the null Node, we want to return -1 back to the last child, and there we are adding +1 to the returned value. This last Node has a height of 0, and that is actually required.
//    }
//        int i1 = Math.max(findHeight(root.left, 0), findHeight(root.right, 0)) + 1;
//        return i1;
//    }
}

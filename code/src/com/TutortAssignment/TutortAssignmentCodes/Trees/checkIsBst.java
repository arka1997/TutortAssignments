package com.TutortAssignment.TutortAssignmentCodes.Trees;


public class checkIsBst {
    public static void main(String[] args) {
        Nodes root = null;
        Tree tree = new Tree();
//        Initialize the first Node, here root.
        String s = "2,1,3,7";
//        call the "insertNode()" method for inserting all Nodes
        root = tree.insertNode(s);
        System.out.println(isBST(root));
    }

    static Nodes prev = null;//for checking if isBST, and used as a variable to store the value of previous leftmost Node
    //Function to check whether a Binary Tree is BST or not.
    static boolean isBST(Nodes root)
    {
        // code here.
        //to check for BST, we need to do inorder traversal, and parallely check if the data is in sorted manner or not
        // for that we can use a "prev" ptr, to maintain the prev value, and check with the current one.
        if(root!=null)
        {
            if(!isBST(root.left)){//here we make the left recursion call, but if the left tree is right, while backtracking, then only we will make the right recursion call, so thatswhy we make a check if false is returned from previous recusrsion calls, then we return false
                // System.out.println(root.data);
                return false;
            }
            if(prev!=null&&prev.val>=root.val)//condition to check if prev value is smaller or not from it's current root. here we return false only if prev!=null && prev > root. Now the 1st check is for null, so that initially value of prev is null, so at that point we save it from the check and get Nullpointer exception
            {
                return false;
            }
            Nodes binaryTree = new Nodes(2);
            prev = root;//then after traversing the extreme left, we store the leftmost value in prev Node, so that when we backtrack, we can check if the root of prev is bigger then the root or not, if yes, thent true, if no, return false.
            return isBST(root.right);//recursion call to the right
        }
        return true;
    }

    static void printInorder(Nodes root)
    {
        if(root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.val+" ");

        printInorder(root.right);
    }
}

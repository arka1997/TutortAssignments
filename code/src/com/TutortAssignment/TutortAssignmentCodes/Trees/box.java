package com.TutortAssignment.TutortAssignmentCodes.Trees;

import com.TutortAssignment.TutortAssignmentCodes.Trees.HoriZontalDistanceWithNodes;
import com.TutortAssignment.TutortAssignmentCodes.Trees.Nodes;


public class box {
    // Java program to check if a given tree is BST.
    static Nodes prev;

        static Boolean isBSTUtil(Nodes root)
        {
            // traverse the tree in inorder fashion and
            // keep track of prev node
            if (root != null) {
                if (!isBSTUtil(root.left)) {
                    return false;
                }
                // Allows only distinct valued nodes
                if (prev != null && root.val <= prev.val) {
                    return false;
                }

                prev = root;

                return isBSTUtil(root.right);
            }
            return true;
        }

        // Driver Code
        public static void main(String[] args)
        {
            Nodes root = null;
            Tree tree = new Tree();
//        Initialize the first Node, here root.
            String s = "3,9,20,N,N,15,7";
//        call the "insertNode()" method for inserting all Nodes
            root = tree.insertNode(s);
            Boolean bstUtil = isBSTUtil(root);
            System.out.println(bstUtil);
        }
}

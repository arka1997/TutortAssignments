package com.TutortAssignment.TutortAssignmentCodes.Trees;

public class SumOfNodesisBst {
    public static void main(String[] args) {
        Nodes root = null;
        Tree tree = new Tree();
//        Initialize the first Node, here root.
        String s = "1,7,0,7,-8,null,null";
//        call the "insertNode()" method for inserting all Nodes
        root = tree.insertNode(s);
        System.out.println(sumOfNodes(root,0));

        printInorder(sumOfNodes(root,0));
    }
    // Function to return sum of Nodes
    static Nodes sumOfNodes(Nodes root,int sum)
    {
        // code here.
        if(root==null)
        {
            return null;
        }
        sumOfNodes(root.right,sum);
        root.val += sum;//here basically, we are making a sum of Nodes, starting from right most side, and while going above, we add the prev value of Nodes, with the current Node, and the order will be, rightSide -> rightSide+root -> rightSide+root+leftSide. Then assigning the new "Sum" as the current Node
        sum = root.val;
        System.out.println(root.val);//printing sum of Nodes from right Side, and assigning the new sum as the current root
        return sumOfNodes(root.left,sum);//recursion call to the left
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

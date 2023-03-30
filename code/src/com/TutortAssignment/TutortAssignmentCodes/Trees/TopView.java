package com.TutortAssignment.TutortAssignmentCodes.Trees;

import java.util.*;

public class TopView {

    static class Pair {
        int hd;
        Nodes root;

        Pair(int hd, Nodes root) {
            this.hd = hd;
            this.root = root;
        }
    }

    public static void main(String[] args) {
        Nodes root = null;
        Tree tree = new Tree();
//        Initialize the first Node, here root.
        String s = "3,9,20,N,N,15,7";
//        call the "insertNode()" method for inserting all Nodes
        root = tree.insertNode(s);
        topView(root);
    }
    //Function to return a list of nodes visible from the top view
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Nodes root) {
        // creating a queue, with Pair form, one is currNode, and the other is horizontal distance. Now we have
        // to use LevelOrder only, because, if we do recursion call on left & right, then order is not maintained,
        // and it may happen, that the Horizontal Distance, that should get prioritized and inserted in map earlier,
        // when we followed level by level, that doesn't happen, and we end up inserting those H.D of Nodes at deepest levels first.
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();//TreeMap so that we get our result in sorted manner
        map.values().stream().max(Integer::compare).get();
        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.root.val);
            }
            if (curr.root.left != null) {
                q.add(new Pair(curr.hd - 1, curr.root.left));
            }
            if (curr.root.right != null) {
                q.add(new Pair(curr.hd + 1, curr.root.right));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        // for(Map.Entry<Integer, Integer> entry: map.entrySet()){
        //     System.out.println(i.getValue());
        // }
        for (int i : map.keySet()) {
            ans.add(map.get(i));
        }
        return ans;
    }
}

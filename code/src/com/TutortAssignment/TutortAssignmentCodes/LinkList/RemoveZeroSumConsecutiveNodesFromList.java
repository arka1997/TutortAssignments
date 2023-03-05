package com.TutortAssignment.TutortAssignmentCodes.LinkList;
import java.util.*;
public class RemoveZeroSumConsecutiveNodesFromList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
//    NOTE:
//    Because the head ListNode can be removed in the end,
//    I create a dummy ListNode and set it as a previous node of head.
//    prefix calculates the prefix sum from the first node to the current headPtr node.
//
//    Next step, we need an important hashmap m (no good name for it),
//    It takes a prefix sum as key, and the related node as the value.
//
//    Then we scan the linked list, accumulate the node's value as prefix sum.
//
//    If it's a prefix that we've never seen, we set h.get[sum] = headPtr.
//    If we have seen this prefix, h.get[sum] is the node we achieve this prefix sum.
//    We want to skip all nodes between h.get[sum] and headPtr.next (exclusive).
//    So we simply do h.get[sum].next = headPtr.next.
//    We keep doing these and it's done.
    static ListNode head;
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int data){
            this.val = data;
            this.next = null;
        }
    }

    //  creating Node
    ListNode pushVal(int newData){
        ListNode newNode = new ListNode(newData);//Here we create a new Node and a constructor is called for settig data and address part
        newNode.next = head;//Address "head" pointer was pointing to, was stored in the "next" part of the newNode to connect it with it's previous Nodes.
        head = newNode;//And then head points to new Node
        return head;
    }

        public static ListNode removeZeroSumSublists() {
            // Start traversing the List, and add elemnts parallely, but when ever we get a zero in sum, then we
            ListNode sumPtr2 = new ListNode(0);//we crate a Node, with a data 0
            ListNode headPtr = sumPtr2;//here we create a pointer to point to the Node
            sumPtr2.next = head;//Now the new Pointer ponts to the new Node containing data = 0, and in the "address" part we store the address of head, to keep a record of the pointer head.
            HashMap<Integer, ListNode> h = new HashMap<>();
            int sum = 0;
//            2 -1 2 5
            while (headPtr != null) {
                sum += headPtr.val;
                if (h.containsKey(sum)) {
                    headPtr = h.get(sum).next;//Here we set the headPtr to point to the Node in the beginning after that element that is repeated in the beginning, here points to -3
                    int p = sum + headPtr.val;// 2 + (-3)
//                    Remove elements from HashMap while traversing between 2 repeated elemnts, one is sum, and the other will same value of "p" at some point, after we go on adding every Node's data to it
                    while (p != sum) {//Here p holds the index, from where delete will start, and we go in adding p with next elemnts, until it becomes equal to sum, which the last repeated not, upto which the elemnts will be deleted. And we remove those elemnts from list
                        h.remove(p);//One by one we will delete the elements from HashMap, withing that range
                        headPtr = headPtr.next;//Here we use headPtr to point to the next Node, so that we can add the data to "p"
                        p += headPtr.val;//Now we add p and the data of the next Node, and in this, in sometime we will reach the point, where we will get the rpeated number in "p" that sum is storing.
                    }
                    h.get(sum).next = headPtr.next;//we come out of above loop when we have p==sum, that means, we have reached the Node,upto which elemnts will be deleted.
                    // Then we obtain the value= "Some Node" from HashMap whose key = sum, which will give the repeated number,
                    // one we get at the beginning. And inside that Node, we put the address of that Node which is repeated at the end,
                    // Thus all the elements between those two rpeated elemnts are disconnected, and hence removed, and we delete the
                    // contents of HasMap in that loop becasue there may exist other pairs whose sum = 0.
                } else {
                    h.put(sum, headPtr);//here we store the sum and the respective Node with it.
                }
                // System.out.println(sum+" "+count);
                headPtr = headPtr.next;
            }
            return sumPtr2.next;
        }

    public void printVal(ListNode nodeHead){
        ListNode temp = nodeHead;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        RemoveZeroSumConsecutiveNodesFromList llist = new RemoveZeroSumConsecutiveNodesFromList();
        llist.pushVal(5);
        llist.pushVal(3);
        llist.pushVal(-3);
        llist.pushVal(2);
        ListNode nodeHead = removeZeroSumSublists();

        llist.printVal(nodeHead);
    }
}
// public ListNode removeZeroSumSublists(ListNode head) {
//         int prefix = 0;
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;
//         Map<Integer, ListNode> seen = new HashMap<>();
//         seen.put(0, dummy);
//         for (ListNode i = dummy; i != null; i = i.next) {
//             prefix += i.val;
//             seen.put(prefix, i);
//         }
//         prefix = 0;
//         for (ListNode i = dummy; i != null; i = i.next) {
//             prefix += i.val;
//             i.next = seen.get(prefix).next;
//         }
//         return dummy.next;
//     }
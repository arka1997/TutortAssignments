package com.TutortAssignment.TutortAssignmentCodes.LinkList;

public class RemoveLinkedlistElemets_EqualsToGivenNum {
    static ListNode head;
    class ListNode{
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

    public static ListNode removeElements(int val) {
        // One approach can be if, we traverse the list, and store the index where we have seen the numbers present in List == val. Then agan in another traversal, we will just remove those nodes from the list.  And if from the beginning only we encounter elemnt which is same as "Val", then we just move the head pointer by 1, And delete the nodes at the beginning.
        // Approach 2:First we check if the Node, head is pointing to, is == val, then we increase head. In while loop now our fastPtr is pointing to the some Node, now we check if the nextNode is equal to "val" or nt, if yes, then we just move the fastPtr to .next.next position, and theryby skipping a node in the middle. If no, then we simply move the pointer by 1
        // Approach3: traverse the LinkList, and whenever you get a Node, which has temp.data==val, then simply skip that and move the pointer forward. And if there is elemnt, which has temp.data !=val, then create a newNode and add it there. Thus we create a new List containing only those elemnts which is not equalto val.
        while(head!=null&&head.val==val){
            head = head.next;
        }
        if(head==null){
            return head;
        }
        ListNode fastPtr = head;
        // If we not use this "fastPtr.next", then getting NullPointer, when our fastPtr points to the last Node, then it's inner condition will check at Null Positions.'
        while(fastPtr.next!=null){
            if(fastPtr.next.val==val){
                fastPtr.next = fastPtr.next.next;
            }else{
                fastPtr = fastPtr.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        RemoveLinkedlistElemets_EqualsToGivenNum llist = new RemoveLinkedlistElemets_EqualsToGivenNum();
        llist.pushVal(20);
        llist.pushVal(30);
        llist.pushVal(40);
        llist.pushVal(50);
//        llist.printVal();
        int k=3;
        RemoveLinkedlistElemets_EqualsToGivenNum.ListNode node = removeElements(k);
        removeElements(3);
    }
}

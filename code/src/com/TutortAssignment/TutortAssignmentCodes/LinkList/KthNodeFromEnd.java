package com.TutortAssignment.TutortAssignmentCodes.LinkList;
import java.util.LinkedList;

public class KthNodeFromEnd {
    Node head;//Head is declare globally, becasue , it will be used by many function to add/insert/delete, because "head" only knows the firstNode of the Linked List to traverse it
    class Node{
        int data;
        Node next;
//      creating a constructor to create a newNode with data and address as null, in the beginning
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
//  creating Node
    Node pushVal(int newData){
        Node newNode = new Node(newData);//Here we create a new Node and a constructor is called for settig data and address part
        newNode.next = head;//Address "head" pointer was pointing to, was stored in the "next" part of the newNode to connect it with it's previous Nodes.
        head = newNode;//And then head points to new Node
        return head;
    }

    public void printVal(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public Node prob_KthNodeFromEnd(int k) {
        Node fastPtr = head;
        Node slowPtr = head;
        int count= 0;
        while(count<k){
            fastPtr = fastPtr.next;
            count++;
        }
        while(fastPtr!=null){
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }
        return slowPtr;
    }

    public static void main(String[] args) {
        KthNodeFromEnd llist = new KthNodeFromEnd();
        llist.pushVal(20);
        llist.pushVal(30);
        llist.pushVal(40);
        llist.pushVal(50);
        llist.printVal();
        int k=3;
        Node node = llist.prob_KthNodeFromEnd(k);
        System.out.println(node.data);
    }
}

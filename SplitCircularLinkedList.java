//package com.linkedlist;
//Author:Shivapreals.tech
//Spliting circular linked list in the half
class Node{
    int data;
    Node next;

}
class NodeUtilE {
    Node head=null;
    public void init(Node Head){
        this.head=head;
    }
    public void splitMiddle()
    {
        Node slow=this.head;
        Node fast=slow.next.next;
        while(fast.next!=this.head){
            slow=slow.next;
        }
        Node head2=slow.next;
        slow.next=this.head;
        Node temp2=head2;
        while(temp2.next!=this.head){
            temp2=temp2.next;

        }
        temp2.next=head2;
        System.out.println("_____________________");
      System.out.print("List1: "); print(this.head);
       System.out.println("_____________________");
        System.out.print("List2: ");  print(head2);
    }

    public void add(int data) {
        if (this.head == null) {
            this.head = CreateNode(data);
            this.head.next = this.head;

        } else
        {

            Node newNode=CreateNode(data);
            Node temp=this.head;
            while(temp.next!=this.head){
                temp=temp.next;
            }
            temp.next=newNode;
            newNode.next=this.head;

        }
    }

    public Node CreateNode(int data){
        Node newNode=new Node();
        newNode.data=data;
        return newNode;
    }
    public void print()
    {
        Node temp=this.head;
        while(temp.next!=this.head){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print(temp.data);
    }
    public void print(Node head)
    {
        Node temp=head;
        while(temp.next!=head){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print(temp.data);
    }
}
public class SplitCircularLinkedList {
    public static void main(String[] args){
        NodeUtilE nodeObj=new NodeUtilE();
        nodeObj.add(1);
        nodeObj.add(2);
        nodeObj.add(3);
       System.out.print("BEFORE MERGE: "); nodeObj.print();
        nodeObj.splitMiddle();

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinkedlist;

/**
 * This is some of my codes contributing to the subject CSD201 practice
 * exercises.
 *
 * @author nkluan
 */
public class SinglyLinkedList {

    /**
     * @param args the command line arguments
     */
    private ListNode head; //We just need head in singly linked list because
    //the tail of this list will point to null.
    
    public SinglyLinkedList() {
        head = null;
    }

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public static class ListNode {

        private int data;       //This attributes are set private because it hides internal details of
        //a class and only expose only the necessary information - Encapsulation.
        private ListNode next;

        //Constructor to get parameteres which are passed by test cases.
        public ListNode(int data) {
            this.data = data;
            this.next = null; //Point to null because the last reference of singly linked list 
            //will point to null to indicate the end of list.
        }

    }

    /**
     * Inserts a new node with the given value at the beginning of the list.
     *
     * @param value
     */
    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Inserts a new node after the given node.
     *
     * @param position
     * @param value
     */
    public void insertAfter(int position, int value) {

        //Create a new node
        ListNode node = new ListNode(value);
        //Position cannot be negative
        if (position < 1) {
            System.err.println("Invalid Position!!!");
            return;
        }

        //If position is 1 then the new node is set in front of head node.
        //Thus, we have to change the head node forward 1 position.
        if (position == 1) {
            node.next = head;
            head = node;
            return;
        }

        ListNode previous = head;
        for (int i = 1; previous != null && i < position - 1; i++) {
            previous = previous.next;

        }

        //Check if it out of bounds
        if (previous != null || previous.next == null) {
            System.err.println("Out of bounds!!!");
            return;
        }

        node.next = previous.next;
        previous.next = node;

    }

    /**
     * Delete a node at a given position.
     *
     * @param position
     */
    public void delete(int position) {
        //Position is valid and starting from 1
        //3 -> 4 -> 7 -> 8 -> 9 -> null

        //Check if the list is empty
        if (head == null) {
            System.err.println("The list is empty. Nothing to print out!!!"); // I use System.err instead because it will print the red messages in the output
            // which I think it would be cool!!!.
            return;
        }

        //Special case: If the position is 1 (first node)
        if (position == 1) {
            head = head.next;
            return;
        }
        ListNode previous = head; //Create a temporary previous node in order to keep track of the list

        // Traverse the list to find the node just before the one to be deleted.  
        for (int i = 1; previous != null && i < position - 1; i++) {
            previous = previous.next;
        }

        //Check if it is out of bounds.
        if (previous == null || previous.next == null) {
            System.err.println("Out of bound!!!");
            return;
        }

        previous.next = previous.next.next;
    }
    
    public void insertLast(int value) {
        ListNode node = new ListNode(value);
        if (head == null) {
            head = node;
            return;
        }
        ListNode current = head;
        //Traverse to the end of the list to find the last node
        while (current.next != null) {
            current = current.next;
        }
        //Set the last node of the list to the new node.
        current.next = node;
    }
    
    public void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println(" null");
        System.out.println();
    }
    
    /**
     * Traverse a list
     */
    public void traverse() {
        ListNode current = head;
        while (current.next != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(); //Print a newline to separate output from the program
    }

    public static void main(String[] args) {
        // TODO code application logic here
        SinglyLinkedList myLinkedList = new SinglyLinkedList();
        
        
        myLinkedList.insertLast(11);
        myLinkedList.insertLast(8);
        myLinkedList.insertLast(1);
        myLinkedList.insertLast(2);
        
        myLinkedList.display();
        
    }

}

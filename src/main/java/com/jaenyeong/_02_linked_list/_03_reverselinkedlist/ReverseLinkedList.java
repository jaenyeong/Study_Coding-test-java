package com.jaenyeong._02_linked_list._03_reverselinkedlist;

public class ReverseLinkedList {
    /*
    [Question]
    Reverse a singly linked list.

    [Input]
    > 1 -> 2 -> 3 -> 4 -> 5 -> NULL
    [Output]
    > 5 -> 4 -> 3 -> 2 -> 1 -> NULL

    [Follow up]
    A linked list can be reversed either iteratively or recursively. Could you implement both?

     */

    public static void main(String[] args) {
        Node current = new Node(1);
        current.setNext(new Node(2));
        current.getNext().setNext(new Node(3));
        current.getNext().getNext().setNext(new Node(4));

        print(current);
        print(solve(current));
    }

    static Node solve(Node current) {
        Node prev = null;
        Node next = null;

        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }

        return prev;
    }

    static void print(Node resultNode) {
        while (resultNode != null) {
            System.out.print("" + resultNode.getValue());
            resultNode = resultNode.getNext();
            if (resultNode != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}

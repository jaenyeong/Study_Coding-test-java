package com.jaenyeong._02_linked_list._01_addtwonumbers;

public class AddTwoNumbers {
    /*
    [Question]
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order and each of their nodes contain a single digit.
    Add the two numbers and return it as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    [Input]
    > (2 -> 4 -> 3) + (5 -> 6 -> 4)
    [Output]
    > 7 -> 0 -> 8

    [Explanation]
    342 + 465 = 807.

     */

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.setNext(new Node(4));
        node1.getNext().setNext(new Node(3));

        Node node2 = new Node(5);
        node2.setNext(new Node(6));
        node2.getNext().setNext(new Node(4));

        print(solve(node1, node2));
    }

    static Node solve(final Node node1, final Node node2) {
        // 더미 데이터
        Node returnNode = new Node(0);

        Node copyNode1 = node1;
        Node copyNode2 = node2;
        Node copyReturnNode = returnNode;

        int carry = 0;

        while (copyNode1 != null || copyNode2 != null) {
            if (copyNode1 != null) {
                carry += copyNode1.getValue();
                copyNode1 = copyNode1.getNext();
            }

            if (copyNode2 != null) {
                carry += copyNode2.getValue();
                copyNode2 = copyNode2.getNext();
            }

            copyReturnNode.setNext(new Node(carry % 10));
            copyReturnNode = copyReturnNode.getNext();

            carry /= 10;
        }

        if (carry == 1) {
            copyReturnNode.setNext(new Node(1));
        }

        return returnNode.getNext();
    }

    static void print(Node resultNode) {
        while (resultNode != null) {
            System.out.print("" + resultNode.getValue());
            resultNode = resultNode.getNext();
            if (resultNode != null) {
                System.out.print(" -> ");
            }
        }
    }
}

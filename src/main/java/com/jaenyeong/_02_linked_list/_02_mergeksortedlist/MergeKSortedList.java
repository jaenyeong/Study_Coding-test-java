package com.jaenyeong._02_linked_list._02_mergeksortedlist;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedList {
    /*
    [Question]
    Merge k sorted linked lists and return it as one sorted list.
    Analyze and describe its complexity.

    [Input]
    > [
          1 -> 4 -> 5,
          1 -> 3 -> 4,
          2 -> 6
      ]
    [Output]
    > [1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6]

     */

    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.setNext(new Node(4));
        node1.getNext().setNext(new Node(5));

        Node node2 = new Node(1);
        node2.setNext(new Node(3));
        node2.getNext().setNext(new Node(4));

        Node node3 = new Node(2);
        node3.setNext(new Node(6));

        Node[] nodeList = {node1, node2, node3};

        print(solve(nodeList));
    }

    static Node solve(final Node[] nodeList) {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getValue));

        Node returnNode = new Node(0);
        Node tempNode = returnNode;

        for (Node node : nodeList) {
            if (node != null) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            Node poppedNode = queue.poll();

            assert tempNode != null;
            tempNode.setNext(poppedNode);
            tempNode = tempNode.getNext();

            if (poppedNode.getNext() != null) {
                queue.offer(poppedNode.getNext());
            }
        }

        return returnNode;
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

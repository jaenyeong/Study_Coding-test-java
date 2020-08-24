package com.jaenyeong._03_queue_stack._03_levelorderofbinarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderOfBinaryTree {
    /*
    [Question]
    Given a binary tree, return the level order traversal of its nodes' values.
    (ie, from left to right, level by level).

    [Input]
        3
       / \
      4   5
     / \
    6   7
    [Output]
    > [[3], [4, 5], [6, 7]]

    [Note]
    Queue - bfs
    Stack - dfs

     */

    public static void main(String[] args) {
        /*
                  3
                /   \
               4     5
             /   \
            6     7
         */

        TreeNode root = new TreeNode(3);
        root.setLeft(new TreeNode(4));
        root.setRight(new TreeNode(5));
        root.getLeft().setLeft(new TreeNode(6));
        root.getLeft().setRight(new TreeNode(7));

        System.out.println(solve(root));
    }

    static List<List<Integer>> solve(final TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            final int queueSize = queue.size();
            List<Integer> tempList = new LinkedList<>();

            for (int i = 0; i < queueSize; i++) {
                TreeNode poppedNode = queue.poll();
                assert poppedNode != null;

                tempList.add(poppedNode.getValue());

                final TreeNode leftNode = poppedNode.getLeft();
                if (leftNode != null) {
                    queue.offer(leftNode);
                }

                final TreeNode rightNode = poppedNode.getRight();
                if (rightNode != null) {
                    queue.offer(rightNode);
                }
            }

            result.add(tempList);
        }

        return result;
    }
}

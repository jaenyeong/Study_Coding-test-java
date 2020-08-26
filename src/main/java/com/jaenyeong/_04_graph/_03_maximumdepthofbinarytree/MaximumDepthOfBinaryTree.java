package com.jaenyeong._04_graph._03_maximumdepthofbinarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthOfBinaryTree {
	/*
	[Question]
	Given a binary tree, find its maximum depth.
	The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

	[Input]
	> [3, 0, 20, null, null, 15, 7]
	      3
	    /   \
	  9      20
	       /    \
	     15      7
	[Output]
	> 3

	[Note]
	A leaf is a node with no children.

	 */

    public static void main(String[] args) {
		/*
		          3
		        /   \
		       1     4
		     /   \
		    5     8
		  /
		 7
		 */

        TreeNode root = new TreeNode(3);

        root.setRight(new TreeNode(4));

        root.setLeft(new TreeNode(1))
            .getLeft().setLeft(new TreeNode(5))
            .getLeft().setLeft(new TreeNode(7));

        // 1 값을 가진 Node 우측에 삽입
        root.getLeft().setRight(new TreeNode(8));

        System.out.println("solve : " + solve(root));
        System.out.println("DFS solve : " + solveDFS(root));
        System.out.println("BFS solve : " + solveBFS(root));
    }

    static int solve(final TreeNode root) {
        if ((root == null) || (root.getValue() <= 0)) {
            return 0;
        }

        final int leftMax = solve(root.getLeft());
        final int rightMax = solve(root.getRight());

        return Math.max(leftMax, rightMax) + 1;
    }

    static int solveDFS(final TreeNode root) {
        if ((root == null) || (root.getValue() == 0)) {
            return 0;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();

        nodeStack.push(root);
        depthStack.push(1);

        int depthMax = 0;
        while (!nodeStack.isEmpty()) {
            TreeNode tempNode = nodeStack.pop();
            int depthCnt = depthStack.pop();
            depthMax = Math.max(depthMax, depthCnt);

            final TreeNode tempNodeLeft = tempNode.getLeft();
            if ((tempNodeLeft != null) && (tempNodeLeft.getValue() > 0)) {
                nodeStack.push(tempNodeLeft);
                depthStack.push(depthCnt + 1);
            }

            final TreeNode tempNodeRight = tempNode.getRight();
            if ((tempNodeRight != null) && (tempNodeRight.getValue() > 0)) {
                nodeStack.push(tempNodeRight);
                depthStack.push(depthCnt + 1);
            }
        }

        return depthMax;
    }

    static int solveBFS(final TreeNode root) {
        if ((root == null) || (root.getValue() == 0)) {
            return 0;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        int depthCount = 0;

        while (!nodeQueue.isEmpty()) {
            final int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                final TreeNode tempNode = nodeQueue.poll();
                assert tempNode != null;

                final TreeNode tempNodeLeft = tempNode.getLeft();
                if ((tempNodeLeft != null) && (tempNodeLeft.getValue() > 0)) {
                    nodeQueue.offer(tempNodeLeft);
                }

                final TreeNode tempNodeRight = tempNode.getRight();
                if ((tempNodeRight != null) && (tempNodeRight.getValue() > 0)) {
                    nodeQueue.offer(tempNodeRight);
                }
            }
            depthCount++;
        }

        return depthCount;
    }
}

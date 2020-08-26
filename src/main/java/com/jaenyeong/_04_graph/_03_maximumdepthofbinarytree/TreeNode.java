package com.jaenyeong._04_graph._03_maximumdepthofbinarytree;

public class TreeNode {
    private int value;
    private TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public TreeNode setValue(int value) {
        this.value = value;
        return this;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode setLeft(TreeNode left) {
        this.left = left;
        return this;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode setRight(TreeNode right) {
        this.right = right;
        return this;
    }
}

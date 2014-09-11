package org.sheehan.algorithm.tree;

/**
 * Created by bob on 7/9/14.
 *
 * BinaryTree created using linked nodes
 */
public class BinaryTree<T> {

    TreeNode<T> root;

    public static <T> TreeNode<T> createTreeNode(T value){
        TreeNode<T> node = new TreeNode<>();
        node.value = value;
        node.left = null;
        node.right= null;

        return node;
    }

    public static <T> TreeNode<T> createTreeNode(T value, TreeNode<T> left, TreeNode<T> right){
        TreeNode<T> node = new TreeNode<>();
        node.value = value;
        node.left = left;
        node.right= right;

        if (left != null)
            left.parent = node;
        if (right != null)
            right.parent = node;

        return node;
    }

    public static class TreeNode <T> {
        public T value;
        TreeNode <T> left;
        TreeNode <T> right;
        TreeNode <T> parent; // for successor/predecessor BST traversal
    }

    public BinaryTree() {
    }

    public void print(TreeNode<T> node) {
        print(node, 0, "root");
        System.out.println();
    }

    private void print(TreeNode<T> node, int level, String side) {
        if (node == null)
            return;
        System.out.print("(");
        print(node.left, level + 1, "left");
        System.out.print(node.value);
        print(node.right, level + 1, "right");
        System.out.print(")");
    }

    public int getHeight(){
        return getHeight(this.root);
     }

    private int getHeight(TreeNode<T> node){
        if (node == null)
            return 0;
        else
            return 1 + Math.max(getHeight(node.left ), getHeight(node.right ));
    }

    public void printInOrder(){
        printInOrder(this.root);
        System.out.println();
    }

    private void printInOrder(TreeNode<T> root) {
        if (root == null)
            return;
        printInOrder(root.left);
        System.out.print(root.value + " ");
        printInOrder(root.right);
    }
}

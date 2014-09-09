package org.sheehan.algorithm.tree;

import org.sheehan.algorithm.data_structures.Queue;
import org.sheehan.algorithm.data_structures.QueueImpl;

/**
 * Created by bob on 7/9/14.
 *
 * BinaryTree created using linked nodes
 */
public class BinaryTree<T extends Comparable<T>> {

    TreeNode<T> root;

    public static <T extends Comparable<T>> TreeNode<T> createTreeNode(T value){
        TreeNode<T> node = new TreeNode<>();
        node.value = value;
        node.left = null;
        node.right= null;

        return node;
    }

    public static <T extends Comparable<T>> TreeNode<T> createTreeNode(T value, TreeNode<T> left, TreeNode<T> right){
        TreeNode<T> node = new TreeNode<>();
        node.value = value;
        node.left = left;
        node.right= right;

        return node;
    }

    public static class TreeNode <T extends Comparable<T>> implements Comparable<TreeNode<T>>{
        public T value;
        TreeNode <T> left;
        TreeNode <T> right;

        @Override
        public int compareTo(TreeNode<T> o) {
            return value.compareTo(o.value);
        }
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

    public void printLevels(TreeNode<T> root) {
        Queue<TreeNode<T>> queue = new QueueImpl<>(100);
        if (root == null)
            return;
        System.out.println();
        queue.add(root);
        int nodeCnt = 0;
        while(queue.peek() != null){
            TreeNode<T> node = queue.remove();
            nodeCnt++;
            if (powerOf2(nodeCnt))
                System.out.println();
            System.out.print(node.value + " ");
             if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        System.out.println();
    }

    private boolean powerOf2(int nodeCnt) {
        for (int i = 0; i < nodeCnt; i++) {
            if (nodeCnt == Math.pow(2,i))
                return true;
            if (nodeCnt < Math.pow(2,i))
                return false;
        }

        return false;
    }
}

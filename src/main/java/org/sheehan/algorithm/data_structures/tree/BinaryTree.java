package org.sheehan.algorithm.data_structures.tree;

import java.util.List;

/**
 * Created by bob on 7/9/14.
 *
 * BinaryTree created using linked nodes
 */
public class BinaryTree<T> {

    public TreeNode<T> root;

    public static <T> TreeNode<T> createTreeNode(T value){
        TreeNode<T> node = new TreeNode<>();
        node.value = value;
        node.left = null;
        node.right= null;

        return node;
    }

    // create node and add children
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
        public TreeNode <T> left;
        public TreeNode <T> right;
        TreeNode <T> parent; // for successor BST traversal

        @Override
        public String toString(){
            return value.toString();
        }
    }

    public BinaryTree(TreeNode<T> node) {
        this.root = node;
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

    //recursive
    private int getHeight(TreeNode<T> node){
        if (node == null)
            return 0;
        else
            return 1 + Math.max(getHeight(node.left ), getHeight(node.right ));
    }

    //recursive
    public int getMaxSum(TreeNode<Integer> node){
        if (node == null)
            return 0;
        else
            return node.value + Math.max(getMaxSum(node.left), getMaxSum(node.right));
    }

    //recursive
    public void printEndNodesAndPathSums(TreeNode<Integer> node){
        if (node == null)
            return;

        //utilize parent nodes
        if (node.left ==null && node.right==null){
            System.out.println("end node: " + node.value);
            int sum = node.value;
            TreeNode<Integer> tmp = node.parent;
            while (tmp != null){
                sum += tmp.value;
                tmp = tmp.parent;
            }
            System.out.println("sum path: " + sum);

            return;
        }
        printEndNodesAndPathSums(node.left);
        printEndNodesAndPathSums(node.right);
     }


    public void getLevelNodes(TreeNode<T> node, int cLevel, int rLevel, List<TreeNode<T>> nodes ){
;
        if (node == null)
            return;
        if (cLevel == rLevel) // add to container if level is met
            nodes.add(node);
        else {
            getLevelNodes(node.left, cLevel+1, rLevel, nodes);
            getLevelNodes(node.right, cLevel+1, rLevel, nodes);
        }
    }

    // swap left and right at each level
    public void mirror(TreeNode<T> node){
        if (node == null)
            return;
        else { //swap
            TreeNode<T> tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }

        //recurse
        if (node.left != null)
            mirror(node.left);
        if (node.right != null)
            mirror(node.right);
    }

    public void mirror(){
        mirror(root);
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

    public boolean compare(TreeNode<T> node){
        return compare(this.root, node);
    }

    private boolean compare(TreeNode<T> node1, TreeNode<T> node2){

        if (node1 == null && node2 == null)
            return true;

        if (node1 != null && node2 == null)
            return false;
        if (node1 == null && node2 != null)
            return false;

        if (node1 != null & node2 != null)
            if (!node1.value.equals(node2.value))
                return false;

        boolean value = true;
        value &= compare(node1.left, node2.left);
        value &= compare(node1.right, node2.right);

        return value;
    }
}

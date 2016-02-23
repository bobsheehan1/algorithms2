package org.sheehan.algorithm.data_structures.tree;

import java.util.List;

/**
 * Created by bob on 7/9/14.
 *
 * BinaryTree created using linked nodes
 */
public class BinaryTree<K extends Comparable<? super K>, V> {

    protected static final boolean RED   = true;
    protected static final boolean BLACK = false;

    public TreeNode<K, V> root;

    public static <K extends Comparable<? super K>, V> TreeNode<K,V> createTreeNode(K key, V value){
        TreeNode<K,V> node = new TreeNode<>();
        node.value = value;
        node.key = key;
        node.left = null;
        node.right= null;
        //node.N = 0;
        node.color = RED;
        return node;
    }

    // create node and enqueue children
    public static <K extends Comparable<? super K>, V> TreeNode<K,V> createTreeNode(K key, V value, TreeNode<K,V> left, TreeNode<K,V> right){
        TreeNode<K,V> node = new TreeNode<>();
        node.value = value;
        node.key = key;
        node.left = left;
        node.right= right;

        if (left != null)
            left.parent = node;
        if (right != null)
            right.parent = node;

        return node;
    }

    public static class TreeNode <K extends Comparable<? super K>, V> {
        K key;
        V value;
        TreeNode <K,V> left;
        TreeNode <K,V> right;

        TreeNode <K,V> parent; // for successor BST traversal

        boolean color;     // RB TREE color of parent link
        //int N;             // RB TREE subtree count


        @Override
        public String toString(){
            return "key:" + key.toString() + " value:" + value.toString() + " color:" + color;
        }
    }

    public BinaryTree(TreeNode<K,V> node) {
        this.root = node;
    }

    public void print() {
        print(this.root);
    }

    public void print(TreeNode<K,V> node) {
        print(node, 0, "root");
        System.out.println();
    }



    private void print(TreeNode<K,V> node, int level, String side) {
        if (node == null)
            return;
        System.out.print("(");
        print(node.left, level + 1, "left");
        System.out.print(node.toString());
        print(node.right, level + 1, "right");
        System.out.print(")");
    }

    // print level with either right to left or left to right direction
    public void printLevel(TreeNode<K,V> node, int level, int rLevel, Boolean dir) {
        if (node == null)
            return;
        if (level == rLevel)
            System.out.print(node.toString() + " ");

        if (dir) {
            printLevel(node.left, level + 1, rLevel, dir);
            printLevel(node.right, level + 1, rLevel, dir);
        } else if (!dir) {
            printLevel(node.right, level + 1, rLevel, dir);
            printLevel(node.left, level + 1, rLevel, dir);
        }
    }

    public void printLevelSimple(TreeNode<K,V> node, int level, int rLevel, int height) {

        if (node == null ) {
            if (level == rLevel) {
                 System.out.print("- ");
            } else {
                //System.out.print(" ");
             }

            return;
        }
        if (level == rLevel) {
            if (node.parent != null)
                System.out.print(node.key + " " + node.parent.key  + " " + node.color + " ");
            else
                System.out.print(node.key + " null " + node.color + " ");
        }

        printLevelSimple(node.left, level + 1, rLevel,height);
        printLevelSimple(node.right, level + 1, rLevel,height);
    }

    public int getHeight(){
        return getMaxHeight(this.root);
     }

    //recursive
    private int getMaxHeight(TreeNode<K,V> node){
        if (node == null)
            return 0;
        else
            return 1 + Math.max(getMaxHeight(node.left), getMaxHeight(node.right ));
    }

    //recursive
    private int getMinHeight(TreeNode<K,V> node){
        if (node == null)
            return 0;
        else
            return 1 + Math.min(getMaxHeight(node.left), getMaxHeight(node.right));
    }

    public boolean isBalanced()
    {
        int min = getMinHeight(this.root);
        int max = getMaxHeight(this.root);

        return max-min<= 1;
    }

    //recursive
    public int getMaxSum(TreeNode<Integer, Integer> node){
        if (node == null)
            return 0;
        else
            return node.value + Math.max(getMaxSum(node.left), getMaxSum(node.right));
    }

    //recursive to print all end node path tot root  node sums
    public void printEndNodesAndPathSums(TreeNode<Integer, Integer> node){
        if (node == null)
            return;

        //when we get to the end then back propoagate utilize parent nodes
        if (node.left == null && node.right== null){
            System.out.println("end node: " + node.value);
            int sum = node.value;
            TreeNode<Integer, Integer> tmp = node.parent;
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

    public void getLevelNodes(TreeNode<K,V> node, int cLevel, int rLevel, List<TreeNode<K,V>> nodes ){
        if (node == null)
            return;
        if (cLevel == rLevel) // enqueue to container if level is met
            nodes.add(node);
        else {
            getLevelNodes(node.left, cLevel+1, rLevel, nodes);
            getLevelNodes(node.right, cLevel+1, rLevel, nodes);
        }
    }

    // swap left and right at each level
    public void mirror(TreeNode<K,V> node){
        if (node == null)
            return;
        else { //swap
            TreeNode<K,V> tmp = node.left;
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

    private void printInOrder(TreeNode<K,V> root) {
        if (root == null)
            return;
        printInOrder(root.left);
        System.out.print(root.value + " ");
        printInOrder(root.right);
    }

    public boolean compare(TreeNode<K,V> node){
        return compare(this.root, node);
    }

    private boolean compare(TreeNode<K,V> node1, TreeNode<K,V> node2){

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

package org.sheehan.algorithm.data_structures.tree;

import org.sheehan.algorithm.data_structures.QueueInterface;
import org.sheehan.algorithm.data_structures.QueueListImpl;

import java.util.function.IntConsumer;

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

    public BinaryTree(TreeNode<K,V> node) {
        this.root = node;
    }

    public static class  Deepest{
        int depth;
        TreeNode node;
    };

    public void getDeepestNode(Deepest result, TreeNode<K,V> node, int depth) {
        if (node == null) {
            // nothing to do
            return;
        }
        if (node.left == null && node.right == null) {
            // we are the left leaf node
            if (depth > result.depth) {
                result.depth = depth;
                result.node = node;
            }
        }
        getDeepestNode(result, node.left, depth + 1);
        getDeepestNode(result, node.right, depth + 1);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        else if (left == null || right == null)
            return false;
        else if (left.key != right.key)
            return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

    }

    public void insertSortedArray(K []sortedArray){
       this.root = insertSortedArray(sortedArray, 0, sortedArray.length-1);
    }

    private TreeNode<K,V> insertSortedArray(K[] sortedArray, int l, int r) {
        if (l >= r)
            return null;

        int mid = l + (r-l)/2;

        TreeNode<K,V> node = new TreeNode<>();
        node.key = sortedArray[mid];
        node.left = insertSortedArray(sortedArray, l, mid);
        if (node.left != null)
            node.left.parent = node;
        node.right = insertSortedArray(sortedArray, mid+1, r);
        if (node.right != null)
            node.right.parent = node;
        return node;
    }

    public int getMaxDepth(TreeNode<K,V> root) {
        if(root == null)
            return 0;

        return 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
    }

    public int getMinDepth(TreeNode<K,V> node) {
        if(node == null)
            return 0;

        return 1 + Math.min(getMinDepth(node.left), getMinDepth(node.right));
    }

    //  no leaf nodes are > 1 apart.
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return getMaxDepth(root) - getMinDepth(root) <= 1 ? true:false;
    }


    public boolean isAllBalanced(TreeNode root) {
        if (root == null)
            return true;

        int diff = (int)(Math.abs(getMaxDepth(root.left) - getMaxDepth(root.right)));
        boolean balanced = diff <= 1 ? true:false;
        if (!balanced)
            return false;
        return isAllBalanced(root.left) && isAllBalanced(root.right);

    }

    //recursive
    public int getMaxSum(TreeNode<Integer, Integer> node){
        if (node == null)
            return 0;
        else
            return node.value + Math.max(getMaxSum(node.left), getMaxSum(node.right));
    }


    // pass is accumlated path and list to add it too
    public void getPaths(TreeNode<Integer, Integer> node, List<String> paths, String path) {
        if (node == null)
            return;

        // accumulate path for this stack frame
        path += node.key.toString() + " ";
        // we have reached and end path node so add the accumlated path here
        if (node.left==null && node.right==null)
            paths.add(path);

        getPaths(node.left, paths, path);
        getPaths(node.right,paths, path);
    }

    //recursive to print all end node path tot root  node sums
    public void printEndNodesAndPathSums(TreeNode<Integer, Integer> node){
        if (node == null)
            return;

        //when we get to the end then back propagate utilize parent nodes
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
        mirror(node.left);
        mirror(node.right);
    }

    public void mirror(){
        mirror(root);
    }

    public void printInOrder(){
        printInOrder(this.root);
        System.out.println();
    }

    //one of 3 DFS traversals
    private void printInOrder(TreeNode<K,V> root) {
        if (root == null)
            return;
        printInOrder(root.left);
        System.out.print(root.value + " ");
        printInOrder(root.right);
    }

    //processs left to right
    public void traverseBfs(IntConsumer op){
        traverseBfs(this.root, op);
        System.out.println();
    }

    // 'level order traversal' use QUEUE
    private void traverseBfs(TreeNode<K,V> root, IntConsumer op) {
        if (root == null)
            return;
        QueueInterface<TreeNode<K,V>> q = new QueueListImpl<>();
        q.enqueue(root);
        while (q.peek() != null){

            // get node
            TreeNode<K,V> node = q.dequeue();

            // do something with it
            op.accept((Integer)node.key);

            // add children
            if (node.left != null)
                q.enqueue(node.left);
            if (node.right != null)
                q.enqueue(node.right);
        }

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

        if (!node1.value.equals(node2.value))
            return false;

        boolean value = true;
        value &= compare(node1.left, node2.left);
        value &= compare(node1.right, node2.right);

        return value;
    }

    //===========================================================================

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

    public static class TreeNode <K extends Comparable<? super K>, V> implements Comparable<TreeNode<K, V>> {
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

        @Override
        public int compareTo(TreeNode<K, V> o) {
            return 0;
        }
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

    public void printLevelSimple(TreeNode<K,V> node, int level, int rLevel) {

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

        printLevelSimple(node.left, level + 1, rLevel);
        printLevelSimple(node.right, level + 1, rLevel);
    }
}

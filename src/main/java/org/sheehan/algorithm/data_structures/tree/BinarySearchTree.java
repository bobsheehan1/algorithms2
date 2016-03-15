package org.sheehan.algorithm.data_structures.tree;

/**
 * Created by bob on 7/9/14.
 *
 * A tree that is compactly formed with no holes from left to right.
 *
 *
 */
public class BinarySearchTree<K extends Comparable<?super K>, V> extends BinaryTree<K,V>{

    public BinarySearchTree() {
        super(null);
    }

    //iterative
    public int closestValue(TreeNode<Integer,Integer> node, double target) {
        int minVal = node.key; //initial value

        // loopy loop NO recursion
        while(node != null){
            if(Math.abs(target - node.key) < Math.abs(target - minVal))
                minVal = node.key;
            node = node.key > target?node.left:node.right;
        }
        return minVal;
    }

    //recursive
    public int closestValue2(TreeNode<Integer,Integer> root, double target) {
        return closest(root, target, root.key);
    }

    private int closest(TreeNode<Integer,Integer> node, double target, int closestVal) {

        // base
        if (node == null)
            return closestVal;

        // compare and set
        if (Math.abs(node.key - target) < Math.abs(closestVal - target))
            closestVal = node.key;

        if (node.key < target)
            closestVal = closest(node.right, target, closestVal);
        else if (node.key > target)
            closestVal = closest(node.left, target, closestVal);

        return closestVal;

    }

    public boolean isValidBST(TreeNode<Integer,V> root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode<Integer,V> node, Long min, Long max) {
        if (node == null)
            return true;

        if (node.key <= min || node.key >= max)
            return false;

        boolean lhs = isValidBST(node.left, min, node.key.longValue());
        boolean rhs = isValidBST(node.right, node.key.longValue(), max);

        return lhs && rhs;

    }

    //recursive pass in root node
    public static <K extends Comparable<K>, V> boolean isBst(TreeNode<K,V> node){
        if (node == null)
            return true;
        if (node.left != null) {
            if (node.key.compareTo(node.left.key) < 0)
                return false;
            return isBst(node.left);
        } else if (node.right != null) {
             if (node.key.compareTo(node.right.key) > 0)
                 return false;
             return isBst(node.right);
         }

        return true;
    }

    protected TreeNode<K,V> insert(K key, V value) {
        if (root == null){
            root = createTreeNode(key, value);
            return root;
        }
        return insert(root, key, value);
    }

//    private TreeNode<K,V> insert(TreeNode<K,V> node, K key, V value) {
//
//        if (node == null)
//            return createTreeNode(key, value);
//
//        if (node.key.compareTo(key) < 0) {
//            node.right = insert(node.right, key, value);
//            node.right.parent = node;
//        } else if (node.key.compareTo(key) > 0) {
//            node.left = insert(node.left, key, value);
//            node.left.parent = node;
//        } else {
//            node.value = value;
//        }
//        return node;
//    }

    private TreeNode<K,V> insert(TreeNode<K,V> node, K key, V value) {

        if (node.key.compareTo(key) < 0) {
            if (node.right != null)
                return insert(node.right, key, value);
            else {
                node.right = createTreeNode(key, value);
                node.right.parent = node;
                return node.right;
            }
        } else if (node.key.compareTo(key) > 0) {
            if (node.left != null)
                return insert(node.left, key, value);
            else {
                node.left = createTreeNode(key, value);
                node.left.parent = node;
                return node.left;
            }
        }
        return null;
    }


    // O(height of tree)
    // three cases
    // 1. no children - remove
    // 2. one child - splice it out
    // 3. two children - splice out successor, replace with successor

    protected TreeNode<K,V> delete(TreeNode<K,V> node) {
        TreeNode<K,V> spliceNode = null; // either replacement or deleted !

        //case 1, 2
        if (node.left == null || node.right == null){
            spliceNode = node;
        } else //case 3
            spliceNode = successor(node); // at most one node ?

        // now do the splice botch
        TreeNode<K,V> spliceChild = null;
        if (spliceNode.left != null){
            spliceChild = spliceNode.left;
        } else {
            spliceChild = spliceNode.right;
        }
        // point orphaned child to grandparent (new parent)
        if (spliceChild != null)
            spliceChild.parent = spliceNode.parent;

        // point new parent at new child
        if (spliceNode.parent == null) { //root
            root = spliceChild;
        } else if (spliceNode == spliceNode.parent.left) {
            spliceNode.parent.left = spliceChild;
        } else {
            spliceNode.parent.right = spliceChild;
        }

        // case 3
        if (node != spliceNode) {
            node.key = spliceNode.key;
            node.value = spliceNode.value;
        }

        return spliceNode;
    }

    // find node with next highest value
    // STEP 1. left most node in right subtree OR
    // STEP 2 if no right subtree go up until you go right !
    TreeNode<K,V> successor(TreeNode<K,V> node){

        // STEP 1.  if right child then get min of that right tree !
        if (node.right != null)
            return minimum(node.right);

        // STEP 2.
        TreeNode<K,V> parent = node.parent;
        TreeNode<K,V> curr = node;

        // if there is a parent AND the node is the right child,
        // we look up getting smaller for parents to left so get them out of the way
        // then return the first parent to the RIGHT (child is left of parent)--> will be successor
        while(parent != null && curr.equals(parent.right)){
            curr = parent; // may not be right
            parent = parent.parent;
        }

        // rightmost node special case
        if (parent != null && parent.key.compareTo(node.key) < 0 && node.key.equals(maximum(this.root).key))
            return node;

        return parent;
    }

    // find node with next smallest value
    // STEP 1. right most node in left subtree OR
    // STEP 2. if no left subtree go up until you go left !
    TreeNode<K,V> predecessor(TreeNode<K,V> node){

        // STEP 1. if left child then get max of that left tree !
        if (node.left != null)
            return maximum(node.left);

        //STEP 2...
        TreeNode<K,V> parent = node.parent;
        TreeNode<K,V> curr = node;

        // if there is a parent AND the node is the right ancestor,
        // we look up getting smaller for parents to left so get them out of the way
        // then return the first parent to the LEFT (child is right of parent)--> will be successor
        while(parent != null && curr.equals(parent.left)){
            curr = parent;
            parent = parent.parent;
        }

        // leftmost node special case
        if (parent != null && parent.key.compareTo(node.key) > 0 && node.value.equals(minimum(this.root).key))
            return node;

        return parent;
    }

    TreeNode<K,V> minimum(TreeNode<K,V> node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    TreeNode<K,V> maximum(TreeNode<K,V> node) {
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    // start at top root node and drill down comparing tree parent nodes to node1 and node2
    TreeNode<K,V> leastCommonAncestor(TreeNode<K,V> root, TreeNode<K,V> node1, TreeNode<K,V> node2){
        if (root == null)
            return null;
        if (node1.key.compareTo(root.key) < 0 && node2.key.compareTo(root.key) < 0){
            return leastCommonAncestor(root.left, node1, node2);
        }
        else if (node1.key.compareTo(root.key) > 0 && node2.key.compareTo(root.key) > 0){
            return leastCommonAncestor(root.right, node1, node2);
        }

        return root;
    }

    TreeNode<K,V> get(TreeNode<K,V> node, K key){
        if (node == null)
            return null;
        if (node.key.compareTo(key) < 0){
            return get(node.right, key);
        }
        else if (node.key.compareTo(key) > 0){
            return get(node.left, key);
        }
        return node;
    }
}

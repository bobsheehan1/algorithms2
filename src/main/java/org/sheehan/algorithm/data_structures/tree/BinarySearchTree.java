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

    public TreeNode<K,V> insert2(K key,V value) {
        if (root == null){
            root = createTreeNode(key, value);
            return root;
        }
        return insert2(root, key, value);
    }

    private TreeNode<K,V> insert2(TreeNode<K,V> node, K key,V value) {
        if (node == null)
            return createTreeNode(key, value);

        if (node.key.compareTo(key) < 0)
            if (node.right != null)
                return insert2(node.right, key, value);
            else {
                node.right = createTreeNode(key, value);
                node.right.parent = node;
            }
        else if (node.key.compareTo(key) > 0)
            if (node.left != null)
                return insert2(node.left, key, value);
            else {
                node.left = createTreeNode(key, value);
                node.left.parent = node;
            }

        return node;
    }

    TreeNode<K,V> successor(TreeNode<K,V> node){

        // if right child then get min of that right tree !
        if (node.right != null)
            return minimum(node.right);

        TreeNode<K,V> parent = node.parent;
        TreeNode<K,V> right = node;


        // if there is a parent AND the node is the right child,
        // we look up getting smaller for parents to left so get them out of the way
        // then return the first parent to the RIGHT --> will be successor
        while(parent != null && right.equals(parent.right)){
            right = parent; // may not be right
            parent = parent.parent;
        }

        // rightmost node special case
        if (parent != null && parent.key.compareTo(node.key) < 0 && node.key.equals(maximum(this.root).key))
            return node;

        return parent;
    }

    TreeNode<K,V> predecessor(TreeNode<K,V> node){

        // if left child then get max of that left tree !
        if (node.left != null)
            return maximum(node.left);

        TreeNode<K,V> parent = node.parent;
        TreeNode<K,V> left = node;

        // if there is a parent AND the node is the right ancestor,
        // we look up getting smaller for parents to left so get them out of the way
        // then return the first parent to the LEFT --> will be successor
        while(parent != null && left.equals(parent.left)){
            left = parent;
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
}

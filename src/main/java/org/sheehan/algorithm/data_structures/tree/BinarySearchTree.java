package org.sheehan.algorithm.data_structures.tree;

/**
 * Created by bob on 7/9/14.
 *
 * A tree that is compactly formed with no holes from left to right.
 *
 *
 */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T>{


    public BinarySearchTree() {
        super(null);
    }

    //recursive pass in root node
    public static <T extends Comparable<T>> boolean isBst(TreeNode<T> node){
        if (node == null)
            return true;
        if (node.left != null) {
            if (node.value.compareTo(node.left.value) < 0)
                return false;
            return isBst(node.left);
        } else if (node.right != null) {
             if (node.value.compareTo(node.right.value) > 0)
                 return false;
             return isBst(node.right);
         }

        return true;
    }

    public TreeNode<T> insert2(T value) {
        if (root == null){
            root = createTreeNode(value);
            return root;
        }
        return insert2(root, value);
    }

    private TreeNode<T> insert2(TreeNode<T> node, T value) {
        if (node == null)
            return createTreeNode(value);

        if (node.value.compareTo(value) < 0)
            if (node.right != null)
                return insert2(node.right, value);
            else {
                node.right = createTreeNode(value);
                node.right.parent = node;
            }
        else if (node.value.compareTo(value) > 0)
            if (node.left != null)
                return insert2(node.left, value);
            else {
                node.left = createTreeNode(value);
                node.left.parent = node;
            }

        return node;
    }

    TreeNode<T> successor(TreeNode<T> node){

        // if right child then get min of that right tree !
        if (node.right != null)
            return minimum(node.right);

        TreeNode<T> parent = node.parent;
        TreeNode<T> right = node;


        // if there is a parent AND the node is the right child,
        // we look up getting smaller for parents to left so get them out of the way
        // then return the first parent to the RIGHT --> will be successor
        while(parent != null && right.equals(parent.right)){
            right = parent; // may not be right
            parent = parent.parent;
        }

        // rightmost node special case
        if (parent != null && parent.value.compareTo(node.value) < 0 && node.value.equals(maximum(this.root).value))
            return node;

        return parent;
    }

    TreeNode<T> predecessor(TreeNode<T> node){

        // if left child then get max of that left tree !
        if (node.left != null)
            return maximum(node.left);

        TreeNode<T> parent = node.parent;
        TreeNode<T> left = node;

        // if there is a parent AND the node is the right ancestor,
        // we look up getting smaller for parents to left so get them out of the way
        // then return the first parent to the LEFT --> will be successor
        while(parent != null && left.equals(parent.left)){
            left = parent;
            parent = parent.parent;
        }

        // leftmost node special case
        if (parent != null && parent.value.compareTo(node.value) > 0 && node.value.equals(minimum(this.root).value))
            return node;

        return parent;
    }

    TreeNode<T> minimum(TreeNode<T> node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    TreeNode<T> maximum(TreeNode<T> node) {
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    TreeNode<T> leastCommonAncestor(TreeNode<T> root, TreeNode<T> node1, TreeNode<T> node2){
        if (root == null)
            return null;
        if (node1.value.compareTo(root.value) < 0 && node2.value.compareTo(root.value) < 0){
            return leastCommonAncestor(root.left, node1, node2);
        }
        else if (node1.value.compareTo(root.value) > 0 && node2.value.compareTo(root.value) > 0){
            return leastCommonAncestor(root.right, node1, node2);
        }

        return root;

    }



}

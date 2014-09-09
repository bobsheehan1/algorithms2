package org.sheehan.algorithm.tree;

import java.util.Arrays;

/**
 * Created by bob on 7/9/14.
 *
 * A tree that is compactly formed with no holes from left to right.
 *
 *
 */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T>{


    public BinarySearchTree() {
        super();
    }

    public static <T extends Comparable<T>> boolean isBst(TreeNode<T> root){
        if (root == null)
            return true;
        if (root.left != null) {
            if (root.value.compareTo(root.left.value) < 0)
                return false;
            return isBst(root.left);
        } else if (root.right != null) {
             if (root.value.compareTo(root.right.value) > 0)
                 return false;
             return isBst(root.right);
         }

        return true;

    }

    public void insert(TreeNode<T> node) {
        if (root == null){
            root = node;
        }
        insert(root, node);
    }

    // recursive
    private TreeNode<T> insert(TreeNode<T> parent, TreeNode<T> node) {
        if (parent == null)
            return node;
        else
            node.parent = parent;

        if (parent.value.compareTo(node.value) < 0) {
            parent.right = insert(parent.right, node);
        }else if (parent.value.compareTo(node.value) > 0) {
            parent.left = insert(parent.left, node);
        }

        return parent;
    }

    TreeNode<T> successor(TreeNode<T> node){

        if (node.right != null)
            return minimum(node.right);

        TreeNode<T> parent = node.parent;
        TreeNode<T> right = node;
        // if there is a parent AND the node is the right ancestor,
        // we look up getting smaller for parents to left so get them out of the way
        // then return the first parent to the RIGHT --> will be successor
        while(parent != null && right.equals(parent.right)){
            right = parent;
            parent = parent.parent;
        }

        // rightmost node special case
        if (parent.value.compareTo(node.value) < 0 && node.value.equals(maximum(this.root).value))
            return node;

        return parent;
    }

    TreeNode<T> predecessor(TreeNode<T> node){

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
        if (parent.value.compareTo(node.value) > 0 && node.value.equals(minimum(this.root).value))
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

}

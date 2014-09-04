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
        else if (parent.value.compareTo(node.value) < 0)
            parent.right = insert(parent.right, node);
        else if (parent.value.compareTo(node.value) > 0)
            parent.left = insert(parent.left, node);

        return parent;
    }


}

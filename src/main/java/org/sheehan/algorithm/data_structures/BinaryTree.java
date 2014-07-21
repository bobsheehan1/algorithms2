package org.sheehan.algorithm.data_structures;

/**
 * Created by bob on 7/9/14.
 *
 * BinaryTree created using linked nodes
 */
public class BinaryTree<T> {

    public TreeNode<T> createTreeNode(T value, TreeNode<T> left, TreeNode<T> right){
        TreeNode<T> node = new TreeNode<>();
        node.value = value;
        node.left = left;
        node.right= right;

        return node;
    }

    public class TreeNode <T> {
        public T value;
        TreeNode <T> left;
        TreeNode <T> right;
    }

    public BinaryTree() {
    }

    public void print(TreeNode<T> node) {
        if (node == null)
            return;
        System.out.println(node.value);
        print(node.left);
        print(node.right);
    }
}

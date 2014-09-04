package org.sheehan.algorithm.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void testIsBst() throws Exception {
        BinaryTree.TreeNode node2 = BinaryTree.createTreeNode(2);
        BinaryTree.TreeNode node4 = BinaryTree.createTreeNode(4);
        BinaryTree.TreeNode node5 = BinaryTree.createTreeNode(5);
        BinaryTree.TreeNode node6 = BinaryTree.createTreeNode(6);
        BinaryTree.TreeNode node8 = BinaryTree.createTreeNode(8);
        BinaryTree.TreeNode node9= BinaryTree.createTreeNode(9);
        BinaryTree.TreeNode node10= BinaryTree.createTreeNode(10);

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(node6);
        bst.insert(node4);
        bst.insert(node8);
        bst.insert(node2);
        bst.insert(node10);
        bst.insert(node5);
        bst.insert(node9);

        bst.print(bst.root);

        assertTrue(BinarySearchTree.isBst(bst.root));

        System.out.println("tree height: " + bst.getHeight());
        bst.printInOrder();

    }
}
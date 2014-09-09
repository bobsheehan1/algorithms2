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

        System.out.println("min " + node2.value + " is " + bst.minimum(node2).value);
        System.out.println("min " + node4.value + " is " + bst.minimum(node4).value);
        System.out.println("min " + node5.value + " is " + bst.minimum(node5).value);
        System.out.println("min " + node6.value + " is " + bst.minimum(node6).value);
        System.out.println("min " + node8.value + " is " + bst.minimum(node8).value);
        System.out.println("min " + node9.value + " is " + bst.minimum(node9).value);
        System.out.println("min " + node10.value + " is " + bst.maximum(node10).value);

        System.out.println("max " + node2.value + " is " + bst.maximum(node2).value);
        System.out.println("max " + node4.value + " is " + bst.maximum(node4).value);
        System.out.println("max " + node5.value + " is " + bst.maximum(node5).value);
        System.out.println("max " + node6.value + " is " + bst.maximum(node6).value);
        System.out.println("max " + node8.value + " is " + bst.maximum(node8).value);
        System.out.println("max " + node9.value + " is " + bst.maximum(node9).value);
        System.out.println("max " + node10.value + " is " + bst.maximum(node10).value);

        System.out.println("successor " + node2.value + " is " + bst.successor(node2).value);
        System.out.println("successor " + node4.value + " is " + bst.successor(node4).value);
        System.out.println("successor " + node5.value + " is " + bst.successor(node5).value);
        System.out.println("successor " + node6.value + " is " + bst.successor(node6).value);
        System.out.println("successor " + node8.value + " is " + bst.successor(node8).value);
        System.out.println("successor " + node9.value + " is " + bst.successor(node9).value);
        System.out.println("successor " + node10.value + " is " + bst.successor(node10).value);

        System.out.println("predecessor " + node2.value + " is " + bst.predecessor(node2).value);
        System.out.println("predecessor " + node4.value + " is " + bst.predecessor(node4).value);
        System.out.println("predecessor " + node5.value + " is " + bst.predecessor(node5).value);
        System.out.println("predecessor " + node6.value + " is " + bst.predecessor(node6).value);
        System.out.println("predecessor " + node8.value + " is " + bst.predecessor(node8).value);
        System.out.println("predecessor " + node9.value + " is " + bst.predecessor(node9).value);
        System.out.println("predecessor " + node10.value + " is " + bst.predecessor(node10).value);


    }
}
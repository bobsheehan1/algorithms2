package org.sheehan.algorithm.data_structures.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void testPrintLevel() throws Exception {

        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<>();

        BinaryTree.TreeNode node6 = bst.insert2(6,6);
        BinaryTree.TreeNode node4 = bst.insert2(4,4);
        BinaryTree.TreeNode node8 = bst.insert2(8,8);
        BinaryTree.TreeNode node2 = bst.insert2(2,2);
        BinaryTree.TreeNode node10 = bst.insert2(10,10);
        BinaryTree.TreeNode node5 = bst.insert2(5,5);
        BinaryTree.TreeNode node9 = bst.insert2(9,9);

        int height = bst.getHeight();
        boolean dir = true;
        for (int i = 0; i < height; ++i){
            bst.printLevel(bst.root, 0, i, dir);
            System.out.println();
            dir = !dir;
        }
    }

    @Test
    public void testIsBst() throws Exception {

        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<>();

        BinaryTree.TreeNode node6 = bst.insert2(6,6);
        BinaryTree.TreeNode node4 = bst.insert2(4,4);
        BinaryTree.TreeNode node8 = bst.insert2(8,8);
        BinaryTree.TreeNode node2 = bst.insert2(2,2);
        BinaryTree.TreeNode node10 = bst.insert2(10,10);
        BinaryTree.TreeNode node5 = bst.insert2(5,5);
        BinaryTree.TreeNode node9 = bst.insert2(9,9);

        bst.print(bst.root);

        assertTrue(BinarySearchTree.isBst(bst.root));

        System.out.println("tree height: " + bst.getHeight());
        bst.printInOrder();

        printStuff(bst, node6);
        printStuff(bst, node4);
        printStuff(bst, node8);
        printStuff(bst, node2);
        printStuff(bst, node10);
        printStuff(bst, node5);
        printStuff(bst, node9);

        BinaryTree.TreeNode<Integer,Integer>  lca = bst.leastCommonAncestor(bst.root, node9, node10);
        System.out.println("lca: " + lca);

        bst.mirror(bst.root);
        bst.printInOrder();
    }

    private void printStuff(BinarySearchTree<Integer,Integer> bst, BinaryTree.TreeNode node) {
        if (bst.successor(node) != null) {
            System.out.println("successor " + node.toString() + " is " + bst.successor(node).toString());
        } else {
            System.out.println("successor " + node.toString() + " is null");
        }

        if (bst.predecessor(node) != null) {
            System.out.println("predecessor " + node.toString() + " is " + bst.predecessor(node).toString());

        } else {
            System.out.println("predecessor " + node.toString() + " is null");
        }

        if (bst.minimum(node) != null) {
            System.out.println("min " + node.toString() + " is " + bst.minimum(node).toString());

        } else {
            System.out.println("min " + node.toString() + " is null");
        }

        if (bst.maximum(node) != null) {
            System.out.println("max " + node.toString() + " is " + bst.maximum(node).toString());
        } else {
            System.out.println("maximum " + node.toString() + " is null");
        }

        System.out.println();
    }


    @Test
    public void testInsert() throws Exception {

        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();


        BinaryTree.TreeNode node6 = bst.insert2(6,6);
        BinaryTree.TreeNode node4 = bst.insert2(4,4);
        BinaryTree.TreeNode node8 = bst.insert2(8,8);
        BinaryTree.TreeNode node2 = bst.insert2(2,2);
        BinaryTree.TreeNode node10 = bst.insert2(10,10);
        BinaryTree.TreeNode node5 = bst.insert2(5,5);
        BinaryTree.TreeNode node9 = bst.insert2(9,9);

        bst.print(bst.root);

        BinarySearchTree<Integer,Integer> bst2 = new BinarySearchTree<>();

        bst2.insert2(6,6);
        bst2.insert2(4,4);
        bst2.insert2(8,8);
        bst2.insert2(2,2);
        bst2.insert2(10,10);
        bst2.insert2(5,5);
        bst2.insert2(9,9);

        bst.print(bst2.root);
    }
}
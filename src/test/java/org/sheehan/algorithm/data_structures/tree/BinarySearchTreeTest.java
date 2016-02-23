package org.sheehan.algorithm.data_structures.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void testPrintLevel() throws Exception {

        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<>();

        BinaryTree.TreeNode node6 = bst.insert(6,6);
        BinaryTree.TreeNode node4 = bst.insert(4,4);
        BinaryTree.TreeNode node8 = bst.insert(8,8);
        BinaryTree.TreeNode node2 = bst.insert(2,2);
        BinaryTree.TreeNode node10 = bst.insert(10,10);
        BinaryTree.TreeNode node5 = bst.insert(5,5);
        BinaryTree.TreeNode node9 = bst.insert(9,9);

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

        BinaryTree.TreeNode node6 = bst.insert(6,6);
        BinaryTree.TreeNode node4 = bst.insert(4,4);
        BinaryTree.TreeNode node8 = bst.insert(8,8);
        BinaryTree.TreeNode node2 = bst.insert(2,2);
        BinaryTree.TreeNode node10 = bst.insert(10,10);
        BinaryTree.TreeNode node5 = bst.insert(5,5);
        BinaryTree.TreeNode node9 = bst.insert(9,9);

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
    public void testInsertDelete() throws Exception {

        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<>();

        bst.insert(100,100);
        bst.insert(90,90);
        bst.insert(110,110);
        bst.insert(80,80);
        bst.insert(95,95);
        bst.insert(92,92);
        bst.insert(93,93);
        bst.insert(91,91);

        int height = bst.getHeight();
        for (int i = 0; i < height; ++i) {
            bst.printLevelSimple(bst.root, 0, i, height);
            System.out.println();
        }
        System.out.println();
        System.out.println();

        BinaryTree.TreeNode<Integer,Integer> node = bst.get(bst.root,90);
        bst.delete(node);
        height = bst.getHeight();
        for (int i = 0; i < height; ++i) {
            bst.printLevelSimple(bst.root, 0, i, height);
            System.out.println();
        }
    }
}
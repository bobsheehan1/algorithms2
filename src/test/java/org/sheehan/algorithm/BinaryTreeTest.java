package org.sheehan.algorithm;

import org.junit.Test;
import org.sheehan.algorithm.data_structures.BinaryTree;

public class BinaryTreeTest {

    @Test
    public void testCreateTreeNode() throws Exception {
        BinaryTree<Integer> tree = new BinaryTree<>();
        BinaryTree.TreeNode node1 = tree.createTreeNode(1, null, null);
        BinaryTree.TreeNode node2 = tree.createTreeNode(2, node1, null);
        BinaryTree.TreeNode node3 = tree.createTreeNode(3, null, null);
        BinaryTree.TreeNode node4 = tree.createTreeNode(4, node3, node2);
        tree.print(node4);
    }
}
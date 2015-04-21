package org.sheehan.algorithm.data_structures.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTest {

    @Test
    public void testCreateTreeNode() throws Exception {
        BinaryTree<Integer> tree = new BinaryTree<>(null);
        BinaryTree.TreeNode node1 = tree.createTreeNode(1, null, null);
        BinaryTree.TreeNode node2 = tree.createTreeNode(2, node1, null);
        BinaryTree.TreeNode node3 = tree.createTreeNode(3, null, null);
        BinaryTree.TreeNode node4 = tree.createTreeNode(4, node3, node2);
        tree.print(node4);
        tree.printInOrder();

        List<BinaryTree.TreeNode<Integer>> nodes = new ArrayList<>();
        tree.getLevelNodes(node4, 0, 0, nodes);

        for (BinaryTree.TreeNode<Integer> node: nodes){
            System.out.println(node.toString());
        }

    }
}
package org.sheehan.algorithm.data_structures.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTest {

    @Test
    public void testCreateTreeNode() throws Exception {

        BinaryTree.TreeNode node1 = BinaryTree.createTreeNode(1, null, null);
        BinaryTree.TreeNode node2 = BinaryTree.createTreeNode(3, node1, null);
        BinaryTree.TreeNode node3 = BinaryTree.createTreeNode(6, null, null);
        BinaryTree.TreeNode node4 = BinaryTree.createTreeNode(9, node3, node2);
        BinaryTree<Integer> tree = new BinaryTree<>(node4);
        //tree.printInOrder();

        List<BinaryTree.TreeNode<Integer>> nodes = new ArrayList<>();
        tree.getLevelNodes(node4, 0, 0, nodes);

        //for (BinaryTree.TreeNode<Integer> node: nodes){
        //    System.out.println(node.toString());
        //}
        System.out.println("max path: " + tree.getMaxSum(node4));
        tree.printEndNodesAndPathSums(node4);


    }
}
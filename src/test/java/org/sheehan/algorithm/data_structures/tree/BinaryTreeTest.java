package org.sheehan.algorithm.data_structures.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTest {

    @Test
    public void testCreateTreeNode() throws Exception {

        BinaryTree.TreeNode node1 = BinaryTree.createTreeNode(1, 1, null, null);
        BinaryTree.TreeNode node2 = BinaryTree.createTreeNode(3, 3, node1, null);
        BinaryTree.TreeNode node3 = BinaryTree.createTreeNode(6, 6, null, null);
        BinaryTree.TreeNode node4 = BinaryTree.createTreeNode(9, 9, node3, node2);
        BinaryTree<Integer,Integer> tree = new BinaryTree<>(node4);

        BinaryTree.TreeNode node11 = BinaryTree.createTreeNode(1, 1, null, null);
        BinaryTree.TreeNode node22 = BinaryTree.createTreeNode(3, 3, node11, null);
        BinaryTree.TreeNode node33 = BinaryTree.createTreeNode(6, 6, null, null);
        BinaryTree.TreeNode node44 = BinaryTree.createTreeNode(9, 9, node33, node22);
        BinaryTree<Integer,Integer> tree2 = new BinaryTree<>(node44);

        List<BinaryTree.TreeNode<Integer,Integer>> nodes = new ArrayList<>();
        tree.getLevelNodes(node4, 0, 0, nodes);

        for (BinaryTree.TreeNode<Integer,Integer> node: nodes){
            System.out.println(node.toString());
        }
        System.out.println("max path: " + tree.getMaxSum(node4));
        tree.printEndNodesAndPathSums(node4);


        System.out.println(tree.compare(tree2.root));

        node1.right = BinarySearchTree.createTreeNode(5,5);

        tree.print();
        System.out.println(tree.isBalanced());

    }
}
package org.sheehan.algorithm.data_structures.tree;

import org.junit.Test;
import org.sheehan.algorithm.Array;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTest {

    @Test
    public void testCreateTreeNode() throws Exception {

        BinaryTree.TreeNode node1 = BinaryTree.createTreeNode(1, 1, null, null);
        BinaryTree.TreeNode node2 = BinaryTree.createTreeNode(3, 3, node1, null);
        BinaryTree.TreeNode node3 = BinaryTree.createTreeNode(6, 6, null, null);
        BinaryTree.TreeNode node4 = BinaryTree.createTreeNode(9, 9, node3, node2);
        BinaryTree<Integer, Integer> tree = new BinaryTree<>(node4);

        BinaryTree.TreeNode node11 = BinaryTree.createTreeNode(1, 1, null, null);
        BinaryTree.TreeNode node22 = BinaryTree.createTreeNode(3, 3, node11, null);
        BinaryTree.TreeNode node33 = BinaryTree.createTreeNode(6, 6, null, null);
        BinaryTree.TreeNode node44 = BinaryTree.createTreeNode(9, 9, node33, node22);
        BinaryTree<Integer, Integer> tree2 = new BinaryTree<>(node44);

        List<BinaryTree.TreeNode<Integer, Integer>> nodes = new ArrayList<>();
        tree.getLevelNodes(node4, 0, 0, nodes);

        for (BinaryTree.TreeNode<Integer, Integer> node : nodes) {
            System.out.println(node.toString());
        }
        System.out.println("max path: " + tree.getMaxSum(node4));
        tree.printEndNodesAndPathSums(node4);


        System.out.println(tree.compare(tree2.root));

        node1.right = BinarySearchTree.createTreeNode(5, 5);

        tree.print();
        System.out.println(tree.isAllBalanced(tree.root));

        int height = tree.getMaxDepth(tree2.root);
        for (int i = 0; i < height; ++i) {
            tree.printLevelSimple(tree2.root, 0, i);
            System.out.println();
        }

        BinaryTree.Deepest deepestNode = new BinaryTree.Deepest();
        tree.getDeepestNode(deepestNode,tree2.root,0);
        System.out.println(deepestNode.node.toString());
    }

    @Test
    public void testBalanced() throws Exception {

        BinaryTree.TreeNode node1 = BinaryTree.createTreeNode(1, 1, null, null);
        BinaryTree.TreeNode node3 = BinaryTree.createTreeNode(3, 3, node1, null);
        BinaryTree.TreeNode node5 = BinaryTree.createTreeNode(5, 5, node3, null);
        BinaryTree.TreeNode node7 = BinaryTree.createTreeNode(7, 7, node5, null);

        BinaryTree.TreeNode node2 = BinaryTree.createTreeNode(2, 2, null, null);
        BinaryTree.TreeNode node4 = BinaryTree.createTreeNode(4, 4, null, node2);
        BinaryTree.TreeNode node6 = BinaryTree.createTreeNode(6, 6, null, node4);
        BinaryTree.TreeNode node8 = BinaryTree.createTreeNode(8, 8, node7, node6);
        BinaryTree<Integer, Integer> tree = new BinaryTree<>(node8);

        List<BinaryTree.TreeNode<Integer, Integer>> nodes = new ArrayList<>();
        tree.getLevelNodes(node4, 0, 0, nodes);

        for (BinaryTree.TreeNode<Integer, Integer> node : nodes) {
            System.out.println(node.toString());
        }
        System.out.println("max path: " + tree.getMaxSum(node4));
        tree.printEndNodesAndPathSums(node4);

        int height = tree.getMaxDepth(tree.root);
        for (int i = 0; i < height; ++i) {
            tree.printLevelSimple(tree.root, 0, i);
            System.out.println();
        }
        ;
        System.out.println(tree.getMinDepth(tree.root));
        System.out.println(tree.getMaxDepth(tree.root));
        System.out.println(tree.isBalanced(tree.root));

        List<String> paths = new ArrayList<String>();
        tree.getPaths(tree.root, paths, "");

        System.out.println("PATHS");
        for (String s : paths) {
            System.out.println(s);
        }
    }

    @Test
    public void testFromSortedArray() throws Exception {
        Array.createArray(10,10,true);
        BinaryTree<Integer, Integer> tree = new BinaryTree<Integer, Integer>(null);
        tree.insertSortedArray(Array.createArray(10,10,true));

        int height = tree.getMaxDepth(tree.root);
        for (int i = 0; i < height; ++i) {
            tree.printLevelSimple(tree.root, 0, i);
            System.out.println();
        }
    }


        @Test
    public void testTraversBfs() throws Exception {

        BinaryTree.TreeNode node1 = BinaryTree.createTreeNode(1, 1, null, null);
        BinaryTree.TreeNode node2 = BinaryTree.createTreeNode(3, 3, node1, null);
        BinaryTree.TreeNode node3 = BinaryTree.createTreeNode(6, 6, null, null);
        BinaryTree.TreeNode node4 = BinaryTree.createTreeNode(9, 9, node3, node2);
        BinaryTree<Integer, Integer> tree = new BinaryTree<>(node4);

        tree.traverseBfs(x -> System.out.print(x + " "));

    }

    @Test
    public void testMirror() throws Exception {
        BinaryTree.TreeNode node1 = BinaryTree.createTreeNode(1, 1, null, null);
        BinaryTree.TreeNode node2 = BinaryTree.createTreeNode(3, 3, node1, null);
        BinaryTree.TreeNode node3 = BinaryTree.createTreeNode(6, 6, null, null);
        BinaryTree.TreeNode node4 = BinaryTree.createTreeNode(9, 9, node3, node2);
        BinaryTree<Integer, Integer> tree = new BinaryTree<>(node4);
        tree.traverseBfs(x -> System.out.print(x + " "));

        int height = tree.getMaxDepth(tree.root);
        for (int i = 0; i < height; ++i) {
            tree.printLevelSimple(tree.root, 0, i);
            System.out.println();
        }

        tree.mirror();

        for (int i = 0; i < height; ++i) {
            tree.printLevelSimple(tree.root, 0, i);
            System.out.println();
        }

    }
}
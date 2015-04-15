package org.sheehan.algorithm;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static class TreeNode <T> {
        public T value;
        public TreeNode <T> left;
        public TreeNode <T> right;
        TreeNode <T> parent; // for successor BST traversal

        @Override
        public String toString(){
            return value.toString();
        }
    }

    static <T> TreeNode<T>  createTreeNode(T value){
        TreeNode<T> node = new TreeNode<>();
        node.value = value;
        node.left = null;
        node.right= null;

        return node;
    }

    static private <T> int getHeight(TreeNode<T> node){
        if (node == null)
            return 0;
        else
            return 1 + Math.max(getHeight(node.left ), getHeight(node.right ));
    }

    static public <T> void getLevelNodes(TreeNode<T> node, int cLevel, int rLevel, List<TreeNode<T>> nodes ){

        if (node == null)
            return;
        if (cLevel == rLevel)
            nodes.add(node);
        else {
            getLevelNodes(node.left, cLevel+1, rLevel, nodes);
            getLevelNodes(node.right, cLevel+1, rLevel, nodes);
        }
    }

    static public  <T> void mirror(TreeNode<T> node){
        if (node == null)
            return;
        else { //swap
            TreeNode<T> tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }

        //recurse
        if (node.left != null)
            mirror(node.left);
        if (node.right != null)
            mirror(node.right);
    }

    static private <T> void printInOrder(TreeNode<T> root) {
        if (root == null)
            return;
        printInOrder(root.left);
        System.out.print(root.value + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int tree[] = new int[2*n];
        Map<Integer, TreeNode<Integer>> map = new HashMap<>();
        map.put(0, Solution.createTreeNode(1));
        for (int i = 0; i < 2*n; ++i) {
            tree[i] = in.nextInt();
            if (tree[i] != -1)
                map.put(i+1, Solution.createTreeNode(tree[i]));
            else
                map.put(i+1, null);
        }

        for (int i = 0; i < n; ++i) {
            TreeNode<Integer> node = map.get(i);
            if (node == null)
                continue;
            int left = 2*i+1;
            int right  = 2*i+2;
            if (left > map.hashCode())
                node.left = null;
            else
                node.left = map.get(left);
            if (left > map.hashCode())
                node.right = null;
            else
                node.right = map.get(right);
        }

        int t = in.nextInt();
        int levels[] = new int[t];
        for (int i = 0; i < t; ++i){
            levels[i] = in.nextInt();
        }

        TreeNode<Integer> root = map.get(0);
        printInOrder(root);

        int height = Solution.getHeight(root);

        for (int level : levels) {
            for (int i=1; i < height; ++i) {
                int rLevel = level*i;
                if (rLevel > height)
                    break;
                List<TreeNode<Integer>> nodes = new ArrayList<>();
                Solution.getLevelNodes(root, 1, rLevel, nodes);

                for (TreeNode<Integer> node : nodes) {
                    mirror(node);
                }
                System.out.println(level + " " + i);

                printInOrder(root);
                System.out.println();
            }
        }
    }
}
package org.sheehan.algorithm.data_structures.tree;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by bsheehan on 2/18/16.
 */
public class RedBlackBinarySearchTreeTest extends TestCase {

    @Test
    public void testRightBalance() throws Exception {

        RedBlackBinarySearchTree<Integer, Integer> bst = new RedBlackBinarySearchTree<>();

        bst.insert2(1, 1);
        bst.insert2(2, 2);
        bst.insert2(3, 3);
        bst.insert2(4, 4);
        bst.insert2(5, 5);
        bst.insert2(6, 6);

        int height = bst.getHeight();
        boolean dir = true;
        for (int i = 0; i < height; ++i) {
            bst.printLevel(bst.root, 0, i, dir);
            System.out.println();
            dir = !dir;
        }
    }
}
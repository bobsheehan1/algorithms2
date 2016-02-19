package org.sheehan.algorithm.data_structures.tree;

/* constraints

1. root is BLACK
2. no 2 REDS adjacent (i.e every RED node has BLACK children)
3. same # of black nodes in each path
4. every null leaf is BLACK

different cases involve left right rotations and node color changes

first node is root and is BLACK
new nodes are colored RED -> if new node has any RED children -> rebalance

sometimes just change color no rotations !

 */
public class RedBlackBinarySearchTree<K extends Comparable<?super K>, V> extends BinarySearchTree<K,V>{

    public RedBlackBinarySearchTree() {
        super();
    }

    public boolean isBalanced() {
        return isBalanced(this.root);
    }

    // count number
    public boolean isBalanced(TreeNode<K,V> node) {

        return isBalanced(this.root);
    }

    private TreeNode<K,V> grandparent(TreeNode<K,V> node) {
        if (node == null)
            return null;
        if (node.parent == null)
            return null;
        return node.parent.parent;
    }

    private TreeNode<K,V> uncle(TreeNode<K,V> node) {
        TreeNode<K,V> gp = grandparent(node);

        if (gp != null) {
            if (gp.left != node.parent)
                return gp.left;
            else
                return gp.right;
        }
        return null;
    }

    // Case 1: The current node N is at the root of the tree.
    // In this case, it is repainted black to satisfy property 2 (the root is black).
    // Since this adds one black node to every path at once,
    // property 5 (all paths from any given node to its leaf nodes contain the same number of black nodes)
    // is not violated.
    private void postInsertCase1(TreeNode<K,V> node) {
        if (node.parent == null) {
            node.color = BLACK;
        }
        else
            postInsertCase2(node);
    }

    // Case 2: The current node's parent P is black, so property 4 (both children of every red node are black)
    // is not invalidated. In this case, the tree is still valid.
    // Property 5 (all paths from any given node to its leaf nodes contain the same number of black nodes)
    // is not threatened, because the current node N has two black leaf children,
    // but because N is red, the paths through each of its children have the same number of black nodes as
    // the path through the leaf it replaced, which was black, and so this property remains satisfied.
    private void postInsertCase2(TreeNode<K,V> node) {
        if (node.parent.color == BLACK) {
            return;
        }
        else
            postInsertCase3(node);
    }

    // Case 3: If both the parent P and the uncle U are red, then both of them can be repainted black and
    // the grandparent G becomes red (to maintain property 5
    // (all paths from any given node to its leaf nodes contain the same number of black nodes)).
    private void postInsertCase3(TreeNode<K,V> node) {
        TreeNode<K,V> uncle = uncle(node);
        if (node.parent.color == BLACK) {
            return;
        }
        else
            postInsertCase4(node);
    }

    @Override
    protected TreeNode<K,V> insert2(K key,V value) {
        TreeNode<K, V> newNode = super.insert2(key, value);

        //rebalance the tree !!!!
        postInsertCase1(newNode);




        return newNode;
    }



    }

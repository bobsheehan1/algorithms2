package org.sheehan.algorithm.graph;

import org.sheehan.algorithm.data_structures.Queue;
import org.sheehan.algorithm.data_structures.QueueImpl;

/**
 * Created by bob on 7/8/14.
 */
public class BFS {
    private boolean marked[];
    private boolean added[];
    private final GraphMatrix graph;

    public BFS(GraphMatrix graph){
        marked = new boolean[graph.getNumV()];
        added = new boolean[graph.getNumV()];
        this.graph = graph;
    }

    // use a queue for BFS
    public void visitIterative(Integer sourceNode){
        Queue<Comparable> queue = new QueueImpl<>(graph.getNumV());
        queue.add(sourceNode);
        while (queue.peek() != null) {
            Comparable node = queue.remove();
            marked[graph.getNodeIndex(node)] = true;
            for (int i = 0; i < graph.getNumV(); ++i) {
                Comparable neighborNode = graph.getNode(i);
                if (!added[i] && graph.isEdge(node, neighborNode)) {
                    queue.add(neighborNode);
                    added[i] = true;
                }
            }
        }
    }

    public void printCoverage() {
        System.out.print("covered ");
        for (int i = 0; i < graph.getNumV(); ++i) {
            if (marked[i])
                System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("uncovered ");
        for (int i = 0; i < graph.getNumV(); ++i) {
            if (!marked[i])
                System.out.print(i + " ");
        }
        System.out.println();
    }

}

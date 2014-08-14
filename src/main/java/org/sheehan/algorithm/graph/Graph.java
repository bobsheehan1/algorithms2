package org.sheehan.algorithm.graph;

import org.sheehan.algorithm.data_structures.List;

/**
 * Created by bob on 8/12/14.
 */
public interface Graph<T extends Comparable<T>> {

    // add directed edge weighted
    void addDirectedEdge(T node1, T node2, int weight);

    void addUndirectedEdge(T node1, T node2, int weight);

    boolean isEdge(T node1, T node2);

    void printGraph();

    int getNumV();

    List<T> getNeighbors(int sourceIndex);

    Integer getEdgeWeight(T node1, T node2);

    T getNode(int i);

    int getNodeIndex(Comparable node);
}

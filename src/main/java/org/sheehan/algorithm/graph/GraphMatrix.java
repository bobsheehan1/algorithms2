package org.sheehan.algorithm.graph;

import org.sheehan.algorithm.data_structures.List;
import org.sheehan.algorithm.data_structures.ListImpl;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by bob on 7/8/14.
 *
 */
public class GraphMatrix <T extends Comparable<T>> {
    private int graph[][];
    private int numE = 0;
    private T [] nodes;

    public GraphMatrix(T []nodes) {
        this.nodes = nodes;
        //sort so we can look up index with binary search
        Arrays.sort(this.nodes);
        graph = new int[nodes.length][nodes.length];
        for (int i = 0; i < this.nodes.length; ++i) {
            for (int j = 0; j < this.nodes.length; ++j) {
                graph[i][j] = 0;
            }
        }
    }

    // add directed edge no weight
    public void addDirectedEdge(T node1, T node2) {
        int i = Arrays.binarySearch(this.nodes, node1);
        int j = Arrays.binarySearch(this.nodes, node2);
        if (i < nodes.length && i >= 0 && j < nodes.length && j >= 0) {
            if (!isEdge(nodes[i],nodes[j])) {
                graph[i][j] = 1;
                numE++;
            }
            else {
                System.err.println("already an edge: " + i + "-" + j );
            }
        }else
            throw new IndexOutOfBoundsException(i + "-" + j);
    }

    // add directed edge weighted
    public void addDirectedEdge(T node1, T node2, int weight) {
        int i = Arrays.binarySearch(this.nodes, node1);
        int j = Arrays.binarySearch(this.nodes, node2);
        if (i < nodes.length && i >= 0 && j < nodes.length && j >= 0) {
            if (!isEdge(nodes[i],nodes[j])) {
                graph[i][j] = weight;
                numE++;
            }
            else {
                System.err.println("already an edge: " + i + "-" + j );
            }
        }else
            throw new IndexOutOfBoundsException(i + "-" + j);
    }

    public void addUndirectedEdge(T node1, T node2) {
        int i = Arrays.binarySearch(this.nodes, node1);
        int j = Arrays.binarySearch(this.nodes, node2);
        if (i < nodes.length && i >= 0 && j < nodes.length && j >= 0) {
            if (!isEdge(nodes[i],nodes[j])) {
                graph[i][j] = 1;
                graph[j][i] = 1;
                numE++;
            }
            else {
                System.err.println("already an edge: " + i + "-" + j );
            }
        }else
            throw new IndexOutOfBoundsException(i + "-" + j);
    }

    public void addUndirectedEdge(T node1, T node2, int weight) {
        int i = Arrays.binarySearch(this.nodes, node1);
        int j = Arrays.binarySearch(this.nodes, node2);
        if (i < nodes.length && i >= 0 && j < nodes.length && j >= 0) {
            if (!isEdge(nodes[i],nodes[j])) {
                graph[i][j] = weight;
                graph[j][i] = weight;
                numE++;
            }
            else {
                System.err.println("already an edge: " + i + "-" + j );
            }
        }else
            throw new IndexOutOfBoundsException(i + "-" + j);
    }

    public boolean isEdge(T node1, T node2) {
        int i = Arrays.binarySearch(this.nodes, node1);
        int j = Arrays.binarySearch(this.nodes, node2);
        if (i < nodes.length && i >= 0 && j < nodes.length && j >= 0)
            return (graph[i][j] != 0);
        return false;

    }

    public void printGraph() {
        System.out.println("vertices: " + nodes.length + " edges: " + numE);
        for (int i = 0; i < this.nodes.length; ++i){
            System.out.print(i + " :");
            for (int j = 0; j < this.nodes.length; ++j) {
                if (isEdge(nodes[i], nodes[j])) {
                    System.out.print(j + "("+ graph[i][j] + ") ");
                }
            }
            System.out.println();
        }
    }

    public int getNumV() {
        return nodes.length;
    }

    public List<T> getNeighbors(int sourceIndex) {
        List<T> neighbors = new ListImpl<T>();
        for (int j = 0; j < this.nodes.length; ++j) {
            if (isEdge(nodes[sourceIndex],nodes[j])) {
                neighbors.append(nodes[j]);
            }
        }
        return neighbors;
    }

    public Integer getEdgeWeight(T node1, T node2) {
        int i = Arrays.binarySearch(this.nodes, node1);
        int j = Arrays.binarySearch(this.nodes, node2);
        if (isEdge(nodes[i], nodes[j])){
            return graph[i][j];
        }
        return Integer.MAX_VALUE; // no edge
    }

    public T getNode(int i) {
        return this.nodes[i];
    }

    public int getNodeIndex(Comparable node) {
        return Arrays.binarySearch(this.nodes, node);
    }
}

package org.sheehan.algorithm.data_structures;

import java.util.ArrayList;

/**
 * Created by bob on 7/8/14.
 */
public class GraphMatrix {
    private int graph[][];
    private final int numV;
    private int numE = 0;

    public GraphMatrix(int numV) {
        this.numV = numV;
        graph = new int[numV][numV];
        for (int i = 0; i < this.numV; ++i) {
            for (int j = 0; j < this.numV; ++j) {
                graph[i][j] = 0;
            }
        }
    }

    public void addDirectedEdge(int i, int j) {
        if (i < numV && i >= 0 && j < numV && j >= 0) {
            if (!isEdge(i,j)) {
                graph[i][j] = 1;
                numE++;
            }
            else {
                System.err.println("already an edge: " + i + "-" + j );
            }
        }else
            throw new IndexOutOfBoundsException(i + "-" + j);
    }

    public void addDirectedEdge(int i, int j, int weight) {
        if (i < numV && i >= 0 && j < numV && j >= 0) {
            if (!isEdge(i,j)) {
                graph[i][j] = weight;
                numE++;
            }
            else {
                System.err.println("already an edge: " + i + "-" + j );
            }
        }else
            throw new IndexOutOfBoundsException(i + "-" + j);
    }

    public void addUndirectedEdge(int i, int j) {
        if (i < numV && i >= 0 && j < numV && j >= 0) {
            if (!isEdge(i,j)) {
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

    public void addUndirectedEdge(int i, int j, int weight) {
        if (i < numV && i >= 0 && j < numV && j >= 0) {
            if (!isEdge(i,j)) {
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

    public boolean isEdge(int i, int j) {
        if (i < numV && i >= 0 && j < numV && j >= 0)
            return (graph[i][j] != 0);
        return false;

    }

    public void printGraph() {
        System.out.println("vertices: " + numV + " edges: " + numE);
        for (int i = 0; i < this.numV; ++i){
            System.out.print(i + " :");
            for (int j = 0; j < this.numV; ++j) {
                if (isEdge(i, j)) {
                    System.out.print(j + "("+ graph[i][j] + ") ");
                }
            }
            System.out.println();
        }
    }

    public int getNumV() {
        return numV;
    }

    public List<Integer> getNeighbors(int source) {
        List<Integer> neighbors = new ListImpl<Integer>();
        for (int i = 0; i < this.numV; ++i) {
            if (isEdge(source, i)) {
                neighbors.append(i);
            }
        }
        return neighbors;
    }

    public Integer getEdgeWeight(int i, Integer j) {
        if (isEdge(i, j)){
            return graph[i][j];
        }
        return Integer.MAX_VALUE; // no edge
    }
}

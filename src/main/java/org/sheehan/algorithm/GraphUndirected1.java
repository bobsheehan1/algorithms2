package org.sheehan.algorithm;

/**
 * Created by bob on 7/8/14.
 */
public class GraphUndirected1 {
    private boolean graph[][];
    private final int numV;
    private int numE = 0;

    public GraphUndirected1(int numV) {
        this.numV = numV;
        graph = new boolean[numV][numV];
    }

    public void addEdge(int i, int j) {
        if (i < numV && i >= 0 && j < numV && j >= 0) {
            if (!isEdge(i,j)) {
                graph[i][j] = true;
                graph[j][i] = true;
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
            return graph[i][j];
        return false;

    }

    public void printGraph() {
        System.out.println("vertices: " + numV + " edges: " + numE);
        for (int i = 0; i < this.numV; ++i){
            System.out.print(i + " :");
            for (int j = 0; j <= this.numV; ++j) {
                if (isEdge(i, j))
                    System.out.print(" " + j);
            }
            System.out.println();
        }
    }

    public int getNumV() {
        return numV;
    }
}

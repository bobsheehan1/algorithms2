package org.sheehan.algorithm.graph;

import org.junit.Test;
import org.sheehan.algorithm.data_structures.GraphMatrix;

public class GraphMatrixTest {

    @Test
    public void testAddEdge() throws Exception {
        GraphMatrix graph = new GraphMatrix(5);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(0, 4);
        graph.addUndirectedEdge(2, 1);
        graph.addUndirectedEdge(2, 0);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(2, 4);
        graph.printGraph();
    }

    @Test
    public void testAddDirectedWeightedEdge() throws Exception {
        GraphMatrix graph = new GraphMatrix(7);
        graph.addDirectedEdge(0, 1, 5);
        graph.addDirectedEdge(0, 2, 10);
        graph.addDirectedEdge(1, 3, 6);
        graph.addDirectedEdge(1, 4, 3);
        graph.addDirectedEdge(3, 5, 6);
        graph.addDirectedEdge(4, 3, 2);
        graph.addDirectedEdge(4, 6, 2);
        graph.addDirectedEdge(6, 5, 2);
        graph.printGraph();
    }
}
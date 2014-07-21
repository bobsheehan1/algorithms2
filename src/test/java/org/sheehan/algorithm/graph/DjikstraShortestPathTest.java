package org.sheehan.algorithm.graph;

import org.junit.Test;
import org.sheehan.algorithm.data_structures.GraphMatrix;

import static org.junit.Assert.*;


public class DjikstraShortestPathTest {

    @Test
    public void testShortestPath() {
        GraphMatrix graph = new GraphMatrix(7);
        graph.addDirectedEdge(0, 1, 5);
        graph.addDirectedEdge(0, 2, 10);
        graph.addDirectedEdge(1, 3, 6);
        graph.addDirectedEdge(1, 4, 3);
        graph.addDirectedEdge(3, 5, 6);
        graph.addDirectedEdge(4, 3, 2);
        graph.addDirectedEdge(4, 6, 2);
        graph.addDirectedEdge(6, 5, 2);
        DjikstraShortestPath alg = new DjikstraShortestPath(graph);
        alg.execute(0);
    }


}
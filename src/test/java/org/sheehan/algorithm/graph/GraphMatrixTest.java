package org.sheehan.algorithm.graph;

import org.junit.Test;

public class GraphMatrixTest {

    @Test
    public void testAddEdge() throws Exception {
        Integer nodes[] = {0,1,2,3,4};
        GraphMatrix<Integer> graph = new GraphMatrix<Integer>(nodes);
        graph.addUndirectedEdge(nodes[0], nodes[1]);
        graph.addUndirectedEdge(nodes[0], nodes[2]);
        graph.addUndirectedEdge(nodes[0], nodes[3]);
        graph.addUndirectedEdge(nodes[0], nodes[4]);
        graph.addUndirectedEdge(nodes[2], nodes[1]);
        graph.addUndirectedEdge(nodes[2], nodes[0]);
        graph.addUndirectedEdge(nodes[2], nodes[3]);
        graph.addUndirectedEdge(nodes[2], nodes[4]);
        graph.printGraph();
    }

    @Test
    public void testAddDirectedWeightedEdge() throws Exception {
        Integer nodes[] = {0,1,2,3,4,5,6};
        GraphMatrix<Integer> graph = new GraphMatrix<Integer>(nodes);
        graph.addDirectedEdge(nodes[0], nodes[1], 5);
        graph.addDirectedEdge(nodes[0], nodes[2], 10);
        graph.addDirectedEdge(nodes[1], nodes[3], 6);
        graph.addDirectedEdge(nodes[1], nodes[4], 3);
        graph.addDirectedEdge(nodes[3], nodes[5], 6);
        graph.addDirectedEdge(nodes[4], nodes[3], 2);
        graph.addDirectedEdge(nodes[4], nodes[6], 2);
        graph.addDirectedEdge(nodes[6], nodes[5], 2);
        graph.printGraph();
    }
}
package org.sheehan.algorithm;

import org.junit.Test;

public class GraphUndirected1Test {

    @Test
    public void testAddEdge() throws Exception {
        GraphUndirected1 graph = new GraphUndirected1(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(2, 1);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.printGraph();


    }

    @Test
    public void testIsEdge() throws Exception {

    }

    @Test
    public void testPrintGraph() throws Exception {

    }
}
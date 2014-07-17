package org.sheehan.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class BFSTest {

    @Test
    public void testVisit() throws Exception {
        GraphUndirected1 graph = new GraphUndirected1(10);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(1, 9);
        //graph.printGraph();

        BFS bfs = new BFS(graph);
        bfs.visitIterative(1);
        bfs.printCoverage();
    }
}
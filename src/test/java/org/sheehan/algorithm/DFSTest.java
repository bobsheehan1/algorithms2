package org.sheehan.algorithm;

import org.junit.Test;

public class DFSTest {

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

        DFS dfs = new DFS(graph);
        dfs.visitRecursion(1);
        dfs.printCoverage();
    }

    @Test
    public void testVisit2() throws Exception {
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

        DFS dfs = new DFS(graph);
        dfs.visitIterative(1);
        dfs.printCoverage();
    }
}
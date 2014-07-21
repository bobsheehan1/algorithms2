package org.sheehan.algorithm.graph;

import org.junit.Test;
import org.sheehan.algorithm.data_structures.GraphMatrix;
import org.sheehan.algorithm.graph.DFS;

public class DFSTest {

    @Test
    public void testVisit() throws Exception {
        GraphMatrix graph = new GraphMatrix(10);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(0, 4);
        graph.addUndirectedEdge(2, 1);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(2, 4);
        graph.addUndirectedEdge(1, 9);
        //graph.printGraph();

        DFS dfs = new DFS(graph);
        dfs.visitRecursion(1);
        dfs.printCoverage();
    }

    @Test
    public void testVisit2() throws Exception {
        GraphMatrix graph = new GraphMatrix(10);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(0, 4);
        graph.addUndirectedEdge(2, 1);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(2, 4);
        graph.addUndirectedEdge(1, 9);
        //graph.printGraph();

        DFS dfs = new DFS(graph);
        dfs.visitIterative(1);
        dfs.printCoverage();
    }
}
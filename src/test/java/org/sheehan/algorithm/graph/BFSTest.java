package org.sheehan.algorithm.graph;

import org.junit.Test;
import org.sheehan.algorithm.data_structures.GraphMatrix;
import org.sheehan.algorithm.graph.BFS;

public class BFSTest {

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

        BFS bfs = new BFS(graph);
        bfs.visitIterative(1);
        bfs.printCoverage();
    }
}
package org.sheehan.algorithm.graph;

import org.junit.Test;

public class BFSTest {

    @Test
    public void testVisit() throws Exception {
        Integer nodes[] = {0,1,2,3,4,9};
        Graph graph = new GraphMatrix(nodes);
        graph.addUndirectedEdge(nodes[0], nodes[1], 1);
        graph.addUndirectedEdge(nodes[0], nodes[2], 1);
        graph.addUndirectedEdge(nodes[0], nodes[3], 1);
        graph.addUndirectedEdge(nodes[0], nodes[4], 1);
        graph.addUndirectedEdge(nodes[2], nodes[1], 1);
        graph.addUndirectedEdge(nodes[2], nodes[3], 1);
        graph.addUndirectedEdge(nodes[2], nodes[4], 1);
        graph.addUndirectedEdge(nodes[1], nodes[5], 1);
        //graph.printGraph();

        BFS bfs = new BFS(graph);
        bfs.visitIterative(nodes[1]);
        bfs.printCoverage();
    }
}
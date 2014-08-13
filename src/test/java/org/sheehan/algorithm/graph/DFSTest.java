package org.sheehan.algorithm.graph;

import org.junit.Test;

public class DFSTest {

    @Test
    public void testVisit() throws Exception {
        Integer nodes[] = {0,1,2,3,4,9};
        GraphMatrix graph = new GraphMatrix(nodes);
        graph.addUndirectedEdge(nodes[0], nodes[1]);
        graph.addUndirectedEdge(nodes[0], nodes[2]);
        graph.addUndirectedEdge(nodes[0], nodes[3]);
        graph.addUndirectedEdge(nodes[0], nodes[4]);
        graph.addUndirectedEdge(nodes[2], nodes[1]);
        graph.addUndirectedEdge(nodes[2], nodes[3]);
        graph.addUndirectedEdge(nodes[2], nodes[4]);
        graph.addUndirectedEdge(nodes[1], nodes[5]);
        //graph.printGraph();

        DFS dfs = new DFS(graph);
        dfs.visitRecursion(1);
        dfs.printCoverage();
    }

    @Test
    public void testVisit2() throws Exception {
        Integer nodes[] = {0,1,2,3,4,9};
        GraphMatrix graph = new GraphMatrix(nodes);
        graph.addUndirectedEdge(nodes[0], nodes[1]);
        graph.addUndirectedEdge(nodes[0], nodes[2]);
        graph.addUndirectedEdge(nodes[0], nodes[3]);
        graph.addUndirectedEdge(nodes[0], nodes[4]);
        graph.addUndirectedEdge(nodes[2], nodes[1]);
        graph.addUndirectedEdge(nodes[2], nodes[3]);
        graph.addUndirectedEdge(nodes[2], nodes[4]);
        graph.addUndirectedEdge(nodes[1], nodes[5]);
       //graph.printGraph();

        DFS dfs = new DFS(graph);
        dfs.visitIterative(1);
        dfs.printCoverage();
    }
}
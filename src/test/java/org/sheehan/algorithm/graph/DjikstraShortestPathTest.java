package org.sheehan.algorithm.graph;

import org.junit.Test;


public class DjikstraShortestPathTest {

    @Test
    public void testShortestPath() {
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
        DjikstraShortestPath alg = new DjikstraShortestPath(graph);
        alg.execute(0);
        alg.printPath(0, 5);
    }

    @Test
    public void testShortestPathPQ() {
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
        DjikstraShortestPath alg = new DjikstraShortestPath(graph);
        alg.execute2(0);
        alg.printPath(0, 5);
    }

    @Test
    public void testShortestPath2() {
        Integer nodes[] = {0,1,2,3,4,9};
        Graph graph = new GraphList(nodes);
        graph.addUndirectedEdge(nodes[0], nodes[1], 10);
        graph.addUndirectedEdge(nodes[0], nodes[2], 1);
        graph.addUndirectedEdge(nodes[0], nodes[3], 1);
        graph.addUndirectedEdge(nodes[0], nodes[4], 10);
        graph.addUndirectedEdge(nodes[2], nodes[1], 1);
        graph.addUndirectedEdge(nodes[2], nodes[3], 1);
        graph.addUndirectedEdge(nodes[2], nodes[4], 1);
        graph.addUndirectedEdge(nodes[1], nodes[5], 10);
        graph.addUndirectedEdge(nodes[4], nodes[5], 1);
        DjikstraShortestPath alg = new DjikstraShortestPath(graph);
        alg.execute(0);
        alg.printPath(0, 5);
    }

    @Test
    public void testShortestPathPQ2() {
        Integer nodes[] = {0,1,2,3,4,9};
        Graph graph = new GraphMatrix(nodes);
        graph.addUndirectedEdge(nodes[0], nodes[1], 10);
        graph.addUndirectedEdge(nodes[0], nodes[2], 1);
        graph.addUndirectedEdge(nodes[0], nodes[3], 1);
        graph.addUndirectedEdge(nodes[0], nodes[4], 10);
        graph.addUndirectedEdge(nodes[2], nodes[1], 1);
        graph.addUndirectedEdge(nodes[2], nodes[3], 1);
        graph.addUndirectedEdge(nodes[2], nodes[4], 1);
        graph.addUndirectedEdge(nodes[1], nodes[5], 10);
        graph.addUndirectedEdge(nodes[4], nodes[5], 1);
        DjikstraShortestPath alg = new DjikstraShortestPath(graph);
        alg.execute2(0);
        alg.printPath(0, 5);
    }


}
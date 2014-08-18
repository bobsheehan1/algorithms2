package org.sheehan.algorithm.graph;

import org.sheehan.algorithm.data_structures.List;
import org.sheehan.algorithm.data_structures.ListImpl;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by bob on 8/15/14.
 */

/*
public class KruskalMinSpanningTree <T extends Comparable<T>> {

    private PriorityQueue<GraphList.Edge<T>> queue = new PriorityQueue<>();
    Set<GraphList.Edge<T>> mstEdges = new LinkedHashSet<>();


    public KruskalMinSpanningTree(Graph<T> graph) {
        Set<GraphList.Edge<T>> usedEdges = new HashSet<>();
        for (int i=0; i < graph.getNumV(); ++i) {
            List<T> neighbors = graph.getNeighbors(i);
            for (T neighbor: neighbors) {
                GraphList.Edge<T> edge = graph.getEdge(graph.getNode(i), neighbor);
                if (!usedEdges.contains(edge)) {
                    usedEdges.add(edge);
                    queue.add(edge);
                }
            }
        }
    }

    public void execute(){
        Set<T> visited = new LinkedHashSet<>();

        while (queue.peek() != null){
            GraphList.Edge<T> edge = queue.remove();
            //check for cycles of dst node
            if (!checkCycles(edge, visited)) {
                visited.add(edge.dstNode);
                mstEdges.add(edge);
            }


            //System.out.println("edge:" + edge.srcNode + " " + edge.dstNode + "(" + edge.weight + ")");
        }
    }

    // use BFS to search if cycle
    private boolean checkCycles(GraphList.Edge<T> edge, Set<T> visited) {
        for (T node:visited){
            if (edge.dstNode.equals(node))
                return true;
        }

        return false;
    }

    public boolean printMst() {
        for (GraphList.Edge<T> edge:mstEdges){
            System.out.println("edge:" + edge.srcNode + " " + edge.dstNode + "(" + edge.weight + ")");
        }

        return false;
    }


}
*/
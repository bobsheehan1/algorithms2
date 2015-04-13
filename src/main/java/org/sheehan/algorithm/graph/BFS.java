package org.sheehan.algorithm.graph;

import org.sheehan.algorithm.data_structures.List;
import org.sheehan.algorithm.data_structures.ListImpl;
import org.sheehan.algorithm.data_structures.Queue;
import org.sheehan.algorithm.data_structures.QueueImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bob on 7/8/14.
 */
public class BFS <T extends Comparable<T>>{
    private final Graph<T> graph;

    public BFS(Graph<T> graph){
        this.graph = graph;
    }

    // use a queue for BFS
    public void visitIterative(GraphNode<T> sourceNode){;
        clearVisited();
        Queue<GraphNode<T>> queue = new QueueImpl<>(100);
        queue.add(sourceNode);
        while (queue.peek() != null) {
            GraphNode<T> node = queue.remove();
            node.visited = true;
            List<GraphNode<T>> neighbors = graph.getNeighbors(node);
            for (GraphNode<T> neighbor: neighbors){
                if (!neighbor.visited) {
                    queue.add(neighbor);
                    neighbor.visited = true;
                }
            }
        }
    }

    private void clearVisited() {
        for (GraphNode<T> node : graph.getNodes()) {
            node.visited = false;
        }
    }

    public void printConnected() {
        System.out.print("connected: ");
        for (GraphNode<T> node: graph.getNodes()){
           if (node.visited)
                System.out.print(node + " ");
        }
        System.out.println();
        System.out.print("not connected: ");
        for (GraphNode<T> node: graph.getNodes()){
            if (!node.visited)
                System.out.print(node + " ");
        }
        System.out.println();
    }

    public Set<GraphNode> getConnected() {
        Set<GraphNode> visitedNodes = new HashSet<>();
        for (GraphNode<T> node: graph.getNodes()){
            if (node.visited)
                visitedNodes.add(node);
        }
        return visitedNodes;
    }




}

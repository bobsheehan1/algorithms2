package org.sheehan.algorithm.graph;

import org.sheehan.algorithm.data_structures.*;
import org.sheehan.algorithm.tree.BinaryHeap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by bob on 7/8/14.
 */
public class DjikstraShortestPath <T extends Comparable<T>>{
    private final Graph<T> graph;
    private Map<GraphNode<T>, GraphNode<T>> predecessorMap;

    public DjikstraShortestPath(Graph<T> graph){
        this.graph = graph;
        predecessorMap = new LinkedHashMap<>();
    }

    // not optimized with PQ
    public void execute(GraphNode<T> sourceNode) {
        for (GraphNode<T> node:graph.getNodes()){
            node.distance = Integer.MAX_VALUE;
            node.visited = false;

        }
        sourceNode.distance = 0;

        // calculate shortest distance to each node from source
        for (int i = 0; i < graph.getNumV(); ++i) {
            // of all unvisited nodes which one has the minimal distance
            GraphNode<T> minDistanceNode = getMinDistanceNode();
            // set this to visited
            minDistanceNode.visited = true;
            // starting at this node look at all neighbors and update distance cost and predecessor
            // if improved.
            List<GraphNode<T>> neighborNodes = this.graph.getNeighbors(minDistanceNode);
            for (GraphNode<T> neighborNode : neighborNodes) {
                // if whatever the neighbor had as a distance is improved by connecting from this new node and edge
                // then update the neighbor of this new node with better distance
                int newEdgeDistance = this.graph.getEdgeWeight(minDistanceNode, neighborNode);
                int newTotalDistanceFromSource = minDistanceNode.distance + newEdgeDistance;
                if (neighborNode.distance > newTotalDistanceFromSource){
                    neighborNode.distance = newTotalDistanceFromSource;
                    predecessorMap.put(neighborNode, minDistanceNode);
                }
            }
        }
    }

    // optimized with PQ
    public void executePQ(GraphNode<T> sourceNode) {
        BinaryHeap<GraphNode<T>> minHeap = new BinaryHeap<>(graph.getNumV(), BinaryHeap.HeapType.MIN_HEAP);

        minHeap.add(sourceNode);

        for (GraphNode<T> node:graph.getNodes()){
            node.distance = Integer.MAX_VALUE;
        }
        sourceNode.distance = 0;

        // calculate shortest distance to each node from source
        while(!minHeap.isEmpty()) {
            // of all unvisited nodes which one has the minimal distance
            GraphNode<T> minDistanceNode = minHeap.remove();
            minDistanceNode.visited = true;
            // starting at this node look at all neighbors and update distance cost and predecessor
            // if improved.
            List<GraphNode<T>> neighborNodes = this.graph.getNeighbors(minDistanceNode);
            for (GraphNode<T> neighborNode : neighborNodes) {
                // if whatever the neighbor had as a distance is improved by connecting from this new node and edge
                // then update the neighbor of this new node with better distance
                int newEdgeDistance = this.graph.getEdgeWeight(minDistanceNode, neighborNode);
                int newTotalDistanceFromSource = minDistanceNode.distance + newEdgeDistance;
                if (neighborNode.distance > newTotalDistanceFromSource){
                    neighborNode.distance = newTotalDistanceFromSource;
                    predecessorMap.put(neighborNode,minDistanceNode);
                    minHeap.add(neighborNode);
                }
            }
        }
    }

    public void printPath(GraphNode<T> srcNode, GraphNode<T> dstNode) {
        Stack<GraphNode<T>> path = new StackImpl<>(predecessorMap.size());
        path.push(dstNode);

        while (dstNode != null){
            dstNode = predecessorMap.get(dstNode);
            if (dstNode != null)
                path.push(dstNode);
        }

        System.out.print("path: ");
        while(path.peek() != null){
            System.out.print(path.pop() + " ");
        }
        System.out.println();
    }

    // how about use PQ instead !
    private GraphNode<T> getMinDistanceNode() {
        int minDistance = Integer.MAX_VALUE;
        GraphNode<T> minDistanceNode = null; // -1 if not found.
        for (GraphNode<T> node : graph.getNodes()) {
            if (!node.visited && node.distance < minDistance){
                minDistanceNode = node;
                minDistance = minDistanceNode.distance;
            }
        }

        return minDistanceNode;
    }
}

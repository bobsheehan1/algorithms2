package org.sheehan.algorithm.graph;

import org.sheehan.algorithm.data_structures.*;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by bob on 7/8/14.
 */
public class PrimMinSpanningTree <T extends Comparable<T>> {
    private final Graph graph;
    private Boolean visited[];
    private Integer distance[];
    private Integer predecessor[];

    //for Prim
    private Set<Comparable<T>> minSpanningNodes;

    public PrimMinSpanningTree(Graph<T> graph){
        this.graph = graph;
        visited = new Boolean[graph.getNumV()];
        distance = new Integer[graph.getNumV()];
        predecessor = new Integer[graph.getNumV()];

        minSpanningNodes = new LinkedHashSet<>();
        for (int i=0; i < graph.getNumV(); ++i){
            visited[i] = false;
        }
    }

    class PQNode implements Comparable<PQNode>{
        public Integer index;
        public Integer distance = Integer.MAX_VALUE;

        public PQNode(Integer index, Integer distance){
            this.index = index;
        }

        @Override
        public int compareTo(PQNode node) {
            return this.distance.compareTo(node.distance);
        }
    }

    // optimized with PQ
    public void execute2(int sourceIndex) {
        BinaryHeap<PQNode> minHeap = new BinaryHeap<>(graph.getNumV(), BinaryHeap.HeapType.MIN_HEAP);

        minHeap.add(new PQNode(sourceIndex, 0));

        for (int i=0; i<distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[sourceIndex] = 0;

        minSpanningNodes.add(graph.getNode(sourceIndex));
        visited[sourceIndex] = true;

        // calculate shortest distance to each node from source
        while(!minHeap.isEmpty()) {
            // of all unvisited nodes which one has the minimal distance
            PQNode minDistanceNode = minHeap.remove();


            // starting at this node look at all neighbors and update distance cost and predecessor
            // if improved.
            int overallMinimumEdgeWeight = Integer.MAX_VALUE;
            int overallMinimumEdgeWeightIndex = 0;

            List<Integer> neighborNodes = this.graph.getNeighbors(minDistanceNode.index);
            for (Integer neighborNode : neighborNodes) {
                int neighborIndex = graph.getNodeIndex(neighborNode);
                // if whatever the neighbor had as a distance is improved by connecting from this new node and edge
                // then update the neighbor of this new node with better distance
                int newEdgeDistance = this.graph.getEdgeWeight(graph.getNode(minDistanceNode.index), graph.getNode(neighborIndex));
                if (!visited[neighborIndex] &&overallMinimumEdgeWeight > newEdgeDistance) {
                    overallMinimumEdgeWeight = newEdgeDistance;
                    overallMinimumEdgeWeightIndex = neighborIndex;
                }

            }
            if (!visited[overallMinimumEdgeWeightIndex]) {
                minHeap.add(new PQNode(overallMinimumEdgeWeightIndex,overallMinimumEdgeWeight));
                minSpanningNodes.add(graph.getNode(overallMinimumEdgeWeightIndex));
                visited[overallMinimumEdgeWeightIndex] = true;
            }

        }
    }

    public void printPath(int srcIndex, int destIndex) {

        System.out.print("MST: ");
        for (Comparable c : minSpanningNodes){
            T node = (T)c;
            System.out.print(node.toString() + " ");
        }

        System.out.println();
    }

    // how about use PQ instead !
    private int getMinDistanceNodeIndex(Boolean[] visited, Integer[] distance) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceIndex = -1; // -1 if not found.
        for (int i = 0; i < distance.length; ++i) {
            if (!visited[i] && distance[i] < minDistance){
                minDistanceIndex = i;
                minDistance = distance[i];
            }
        }

        return minDistanceIndex;
    }
}

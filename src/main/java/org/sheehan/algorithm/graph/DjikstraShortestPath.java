package org.sheehan.algorithm.graph;

import org.sheehan.algorithm.data_structures.*;

/**
 * Created by bob on 7/8/14.
 */
public class DjikstraShortestPath {
    private final Graph graph;
    private Boolean visited[];
    private Integer distance[];
    private Integer predecessor[];

    public DjikstraShortestPath(Graph graph){
        this.graph = graph;
        visited = new Boolean[graph.getNumV()];
        distance = new Integer[graph.getNumV()];
        predecessor = new Integer[graph.getNumV()];

    }

    // not optimized with PQ
    public void execute(int sourceIndex) {
        for (int i=0; i<distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;

        }
        distance[sourceIndex] = 0;

        // calculate shortest distance to each node from source
        for (int i = 0; i < distance.length; ++i) {
            // of all unvisited nodes which one has the minimal distance
            int minDistanceNodeIndex = getMinDistanceNodeIndex(visited, distance);

            // set this to visited
            visited[minDistanceNodeIndex] = true;

            // starting at this node look at all neighbors and update distance cost and predecessor
            // if improved.
            List<Integer> neighborNodes = this.graph.getNeighbors(minDistanceNodeIndex);
            for (Integer neighborNode : neighborNodes) {
                int neighborIndex = graph.getNodeIndex(neighborNode);
                // update and compare distance from source
                int newEdgeDistance = this.graph.getEdgeWeight(graph.getNode(minDistanceNodeIndex), graph.getNode(neighborIndex));
                if (distance[neighborIndex] > distance[minDistanceNodeIndex] + newEdgeDistance){
                    distance[neighborIndex] = distance[minDistanceNodeIndex] + newEdgeDistance;
                    predecessor[neighborIndex] = minDistanceNodeIndex;
                }
            }
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
        boolean optimizeWithPriorityQueue = false;
        BinaryHeap<PQNode> minHeap = new BinaryHeap<>(graph.getNumV(), BinaryHeap.HeapType.MIN_HEAP);

        minHeap.add(new PQNode(sourceIndex, 0));

        for (int i=0; i<distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[sourceIndex] = 0;

        // calculate shortest distance to each node from source
        while(!minHeap.isEmpty()) {
            // of all unvisited nodes which one has the minimal distance
            PQNode minDistanceNode = minHeap.remove();

            // starting at this node look at all neighbors and update distance cost and predecessor
            // if improved.
            List<Integer> neighborNodes = this.graph.getNeighbors(minDistanceNode.index);
            for (Integer neighborNode : neighborNodes) {
                int neighborIndex = graph.getNodeIndex(neighborNode);
                // update and compare distance from source
                int newEdgeDistance = this.graph.getEdgeWeight(graph.getNode(minDistanceNode.index), graph.getNode(neighborIndex));
                if (distance[neighborIndex]> distance[minDistanceNode.index]  + newEdgeDistance){
                    distance[neighborIndex] = distance[minDistanceNode.index]  + newEdgeDistance;
                    predecessor[neighborIndex] = minDistanceNode.index;
                    minHeap.add(new PQNode(neighborIndex,newEdgeDistance ));
                }
            }
        }
    }

    public void printPath(int srcIndex, int destIndex) {
        Stack<Integer> path = new StackImpl<>(predecessor.length);
        int i = destIndex;
        path.push(destIndex);
        while(predecessor[i] != srcIndex){
            path.push(predecessor[i]);
            i = predecessor[i];
        }
        path.push(srcIndex);

        System.out.print("path: ");
        while(path.peek() != null){
            System.out.print(graph.getNode(path.pop()) + " ");
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

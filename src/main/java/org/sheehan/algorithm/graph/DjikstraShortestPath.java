package org.sheehan.algorithm.graph;

import org.sheehan.algorithm.data_structures.*;

/**
 * Created by bob on 7/8/14.
 */
public class DjikstraShortestPath {
    private final GraphMatrix graph;
    private Boolean visited[];
    private Integer distance[];
    private Integer predecessor[];

    public DjikstraShortestPath(GraphMatrix graph){
        this.graph = graph;
        visited = new Boolean[graph.getNumV()];
        distance = new Integer[graph.getNumV()];
        predecessor = new Integer[graph.getNumV()];

    }

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
            List<Integer> neighbors = this.graph.getNeighbors(minDistanceNodeIndex);
            for (Integer neighborIndex : neighbors) {
                // update and compare distance from source
                int newEdgeDistance = this.graph.getEdgeWeight(minDistanceNodeIndex, neighborIndex);
                if (distance[neighborIndex]> distance[minDistanceNodeIndex]  + newEdgeDistance){
                    distance[neighborIndex] = distance[minDistanceNodeIndex]  + newEdgeDistance;
                    predecessor[neighborIndex] = minDistanceNodeIndex;
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

        while(path.peek() != null){
            System.out.println(path.pop());
        }
    }

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

package org.sheehan.algorithm.graph;

import org.sheehan.algorithm.data_structures.List;
import org.sheehan.algorithm.data_structures.ListImpl;
import org.sheehan.algorithm.data_structures.Queue;
import org.sheehan.algorithm.data_structures.QueueImpl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by bob on 9/2/14.
 */
public class TopologicalSortDag <T extends Comparable<T>> {

     public List<GraphNode<T> > topologicalSort(Graph<T> inputDag){
        List<GraphNode<T> > sortedList = new ListImpl<>();

        // could not use HashSet iterator here because alg removes and adds below
        Queue<GraphNode<T> > noIncomingEdgeNodes = new QueueImpl<>(inputDag.getNumV());

        for (GraphNode<T> node:inputDag.getNodes()){
            System.out.println("check incoming: " + node);
            if (!inputDag.hasIncomingEdges(node))
                noIncomingEdgeNodes.add(node);
         }

          while(noIncomingEdgeNodes.peek() != null){
             GraphNode<T> noIncomingEdgesNode = noIncomingEdgeNodes.remove();
             sortedList.append(noIncomingEdgesNode);
             for (GraphNode<T> neighbor:inputDag.getNeighbors(noIncomingEdgesNode)){
                 GraphEdge<T> edge = inputDag.getEdge(noIncomingEdgesNode, neighbor);
                 edge.visited = true;
                 if (!inputDag.hasIncomingEdges(neighbor)) {
                     noIncomingEdgeNodes.add(neighbor);
                  }

             }
         }

         return sortedList;
      }
}

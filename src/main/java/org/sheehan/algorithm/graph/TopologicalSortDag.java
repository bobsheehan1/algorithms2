package org.sheehan.algorithm.graph;

import org.sheehan.algorithm.data_structures.List;
import org.sheehan.algorithm.data_structures.ListImpl;
import org.sheehan.algorithm.data_structures.Queue;
import org.sheehan.algorithm.data_structures.QueueArrayImpl;
import org.sheehan.algorithm.data_structures.graph.Graph;
import org.sheehan.algorithm.data_structures.graph.GraphEdge;
import org.sheehan.algorithm.data_structures.graph.GraphNode;

/**
 * Created by bob on 9/2/14.
 */
public class TopologicalSortDag <T extends Comparable<T>> {

     public List<GraphNode<T>> topologicalSort(Graph<T> inputDag){
        List<GraphNode<T> > sortedList = new ListImpl<>();

        // could not use HashSet iterator here because alg removes and adds below
        Queue<GraphNode<T> > noIncomingEdgeNodes = new QueueArrayImpl<>(inputDag.getNumV());

        for (GraphNode<T> node:inputDag.getNodes()){
            System.out.println("check incoming: " + node);
            if (!inputDag.hasIncomingEdges(node))
                noIncomingEdgeNodes.enqueue(node);
         }

          while(noIncomingEdgeNodes.peek() != null){
             GraphNode<T> noIncomingEdgesNode = noIncomingEdgeNodes.dequeue();
             sortedList.appendBack(noIncomingEdgesNode);
             for (GraphNode<T> neighbor:inputDag.getNeighbors(noIncomingEdgesNode)){
                 GraphEdge<T> edge = inputDag.getEdge(noIncomingEdgesNode, neighbor);
                 edge.visited = true;
                 if (!inputDag.hasIncomingEdges(neighbor)) {
                     noIncomingEdgeNodes.enqueue(neighbor);
                  }

             }
         }

         return sortedList;
      }
}

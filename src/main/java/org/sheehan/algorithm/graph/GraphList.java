package org.sheehan.algorithm.graph;

import org.sheehan.algorithm.data_structures.List;
import org.sheehan.algorithm.data_structures.ListImpl;

import java.util.*;

/**
 * Created by bob on 7/8/14.
 *
 */
public class GraphList<T extends Comparable<T>> implements Graph<T> {
    private Map<GraphNode<T>, List<GraphEdge<T>>> graphAdjacencyList;
    private java.util.Set<GraphNode<T>> graphNodes = new HashSet<>();



    /*public GraphList(T[] nodes) {
        //TODO make method to init with array
        for (int i = 0; i < nodes.length; ++i) {
            graphNodes.add(nodes[i]);
        }
        //sort so we can look up index with binary search
        Collections.sort(graphNodes);
        graphAdjacencyList = new HashMap<T, List<GraphEdge<T>>>();
       
        for (int i = 0; i < this.graphNodes.size(); ++i) {
            graphAdjacencyList.put(this.graphNodes.get(i), new ListImpl<GraphEdge<T>>());
        }
    }*/

    public GraphList() {
        graphAdjacencyList = new HashMap<GraphNode<T>, List<GraphEdge<T>>>();
    }

    @Override
    public GraphNode<T> addNode( GraphNode<T> node) {
       // GraphNode<T> node = new GraphNode<T>(payload);

        graphNodes.add(node);
        //Collections.sort(graphNodes);
        graphAdjacencyList.put(node, new ListImpl<GraphEdge<T>>());

        return node;


    }

    // add directed edge weighted
    @Override
    public GraphEdge<T>  addDirectedEdge( GraphNode<T> node1,  GraphNode<T>node2, int weight) {
        if (!graphNodes.contains(node1))
            addNode(node1);
        if (!graphNodes.contains(node2))
            addNode(node2);
        GraphEdge<T> edge = new GraphEdge<>(node1, node2, weight);

        //int i = Collections.binarySearch(this.graphNodes, node1);
        //int j = Collections.binarySearch(this.graphNodes, node2);
        //if (i < this.graphNodes.size() && i >= 0 && j < this.graphNodes.size() && j >= 0) {
            if (!isEdge(edge.srcNode,edge.dstNode)) {
                graphAdjacencyList.get(node1).append(edge);
            }
            else {
                System.err.println("already an edge: " + node1 + " " + node2 );
            }
        //}else
        //    throw new IndexOutOfBoundsException(i + "-" + j);

        return edge;
    }


    @Override
    public java.util.List<GraphEdge<T>> addUndirectedEdge(GraphNode<T> node1, GraphNode<T> node2, int weight) {
        if (!graphNodes.contains(node1))
            addNode(node1);
        if (!graphNodes.contains(node2))
            addNode(node2);
        GraphEdge<T> edge1 = new GraphEdge<>(node1, node2, weight);
        GraphEdge<T> edge2 = new GraphEdge<>(node2, node1, weight);
        edge2.id = edge1.id; //undirected edge (2 parallel edges)
        //int i = Collections.binarySearch(this.graphNodes, node1);
        //int j = Collections.binarySearch(this.graphNodes, node2);
        //if (i < this.graphNodes.size() && i >= 0 && j < this.graphNodes.size() && j >= 0) {
        if (!isEdge(edge1.srcNode,edge1.dstNode)) {
            graphAdjacencyList.get(node1).append(edge1);
            }
            else {
                System.err.println("already an edge: " + node1 + " " + node2 );
            }
   //     if (!isEdge(edge2.dstNode,edge2.srcNode)) {
                graphAdjacencyList.get(node2).append(edge2);
     //       }
     //       else {
     //           System.err.println("already an edge: " + node1 + " " + node2 );
     //       }
        //}else
        //    throw new IndexOutOfBoundsException(i + "-" + j);

        java.util.List<GraphEdge<T>> edges = new ArrayList<GraphEdge<T>>();
        edges.add(edge1);
        edges.add(edge2);

        return edges;
    }

    public Set<GraphNode<T>> getNodes(){
        return graphNodes;
    }


    @Override
    public boolean isEdge(GraphNode<T> node1, GraphNode<T> node2) {
       // int i = Collections.binarySearch(this.graphNodes, node1);
       // int j = Collections.binarySearch(this.graphNodes, node2);
       // if (i < this.graphNodes.size() && i >= 0 && j < this.graphNodes.size() && j >= 0){
            List<GraphEdge<T>> edges = graphAdjacencyList.get(node1);
            for (GraphEdge edge : edges){
                if (edge.dstNode.equals(node2))
                    return true;
            }
        //}
        return false;
    }


    public GraphEdge<T> getEdge(GraphNode<T> node1, GraphNode<T> node2) {
       // int i = Collections.binarySearch(this.graphNodes, node1);
        //int j = Collections.binarySearch(this.graphNodes, node2);
        //if (i < this.graphNodes.size() && i >= 0 && j < this.graphNodes.size() && j >= 0){
            List<GraphEdge<T>> edges = graphAdjacencyList.get(node1);
            for (GraphEdge edge : edges){
                if (edge.dstNode.equals(node2))
                    return edge;
            }
       // }
        return null;
    }

    @Override
    public void printGraph() {
        System.out.println("vertices: " + this.graphNodes.size() );
        for (GraphNode<T> node : this.graphNodes){
            List<GraphEdge<T>> graphEdges = graphAdjacencyList.get(node);
            if (graphEdges.size() > 0 ) {
                System.out.print(node.toString() + " -> ");
                for (GraphEdge edge : graphEdges) {
                    System.out.print(edge + " ");
                }
                System.out.println();
            }
        }
    }

    @Override
    public int getNumV() {
        return this.graphNodes.size();
    }

    @Override
    public List<GraphNode<T>> getNeighbors(GraphNode<T> node) {
        List<GraphNode<T>> neighbors = new ListImpl<>();
        List<GraphEdge<T>> edges = graphAdjacencyList.get(node);
        if (edges != null) {
            for (GraphEdge<T> edge : edges)
                neighbors.append(edge.dstNode);
        }
        return neighbors;

    }

    @Override
    public Integer getEdgeWeight(GraphNode<T> node1, GraphNode<T> node2) {
        //int i = Collections.binarySearch(this.graphNodes, node1);
        //int j = Collections.binarySearch(this.graphNodes, node2);
        if (isEdge(node1, node2)){
            return getEdge(node1, node2).weight;
        }
        return Integer.MAX_VALUE; // no edge
    }

    /*@Override
    public GraphNode<T> getNode(int i) {
        for (GraphNode<T> node : graphNodes){
            if (node.equals())
        }

        return this.graphNodes.
    }*/

   /* @Override
    public int getNodeIndex(T node) {
        return Collections.binarySearch(this.graphNodes, node);
    }*/
}

package org.sheehan.algorithm.graph;

import org.sheehan.algorithm.data_structures.List;
import org.sheehan.algorithm.data_structures.ListImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bob on 7/8/14.
 *
 */
public class GraphList<T extends Comparable<T>> implements Graph<T> {

    public class Edge<T> implements Comparable<Edge<T>> {
        public T node;
        public Integer weight = 1;

        @Override
        public int compareTo(Edge<T> edge) {
            return this.weight.compareTo(edge.weight);
        }
    }

    private Map<T,List<Edge<T>>> graphAdjacencyList;
    private T []graphNodes;

    public GraphList(T[] nodes) {
        this.graphNodes = nodes;
        //sort so we can look up index with binary search
        Arrays.sort(this.graphNodes);
        graphAdjacencyList = new HashMap<T, List<Edge<T>>>();
       
        for (int i = 0; i < this.graphNodes.length; ++i) {
            graphAdjacencyList.put(this.graphNodes[i], new ListImpl<Edge<T>>());
        }
    }

    // add directed edge weighted
    @Override
    public void addDirectedEdge(T node1, T node2, int weight) {
        Edge<T> edge = new Edge<>();
        edge.node = node2;

        edge.weight = weight;

        int i = Arrays.binarySearch(this.graphNodes, node1);
        int j = Arrays.binarySearch(this.graphNodes, node2);
        if (i < graphNodes.length && i >= 0 && j < graphNodes.length && j >= 0) {
            if (!isEdge(node1,node2)) {
                graphAdjacencyList.get(node1).append(edge);
            }
            else {
                System.err.println("already an edge: " + i + "-" + j );
            }
        }else
            throw new IndexOutOfBoundsException(i + "-" + j);
    }


    @Override
    public void addUndirectedEdge(T node1, T node2, int weight) {
        Edge<T> edge1 = new Edge<>();
        edge1.node = node2;
        edge1.weight = weight;
        Edge<T> edge2 = new Edge<>();
        edge2.node = node1;
        edge2.weight = weight;
        int i = Arrays.binarySearch(this.graphNodes, node1);
        int j = Arrays.binarySearch(this.graphNodes, node2);
        if (i < graphNodes.length && i >= 0 && j < graphNodes.length && j >= 0) {
            if (!isEdge(node1,node2)) {
                graphAdjacencyList.get(node1).append(edge1);
            }
            else {
                System.err.println("already an edge: " + i + "-" + j );
            }
            if (!isEdge(node2,node1)) {
                graphAdjacencyList.get(node2).append(edge2);
            }
            else {
                System.err.println("already an edge: " + i + "-" + j );
            }
        }else
            throw new IndexOutOfBoundsException(i + "-" + j);
    }

    @Override
    public boolean isEdge(T node1, T node2) {
        int i = Arrays.binarySearch(this.graphNodes, node1);
        int j = Arrays.binarySearch(this.graphNodes, node2);
        if (i < graphNodes.length && i >= 0 && j < graphNodes.length && j >= 0){
            List<Edge<T>> edges = graphAdjacencyList.get(node1);
            for (Edge edge : edges){
                if (edge.node.equals(node2))
                    return true;
            }
        }
        return false;
    }


    private Edge<T> getEdge(T node1, T node2) {
        int i = Arrays.binarySearch(this.graphNodes, node1);
        int j = Arrays.binarySearch(this.graphNodes, node2);
        if (i < graphNodes.length && i >= 0 && j < graphNodes.length && j >= 0){
            List<Edge<T>> edges = graphAdjacencyList.get(node1);
            for (Edge edge : edges){
                if (edge.node.equals(node2))
                    return edge;
            }
        }
        return null;
    }

    @Override
    public void printGraph() {
        System.out.println("vertices: " + graphNodes.length );
        for (int i = 0; i < this.graphNodes.length; ++i){
            System.out.print(this.graphNodes[i].toString() + " :");
            List<Edge<T>> edges = graphAdjacencyList.get(this.graphNodes[i]);
            for (Edge edge : edges){
                System.out.print(edge.node.toString() + "("+ edge.weight + ") ");
            }
            System.out.println();
        }
    }

    @Override
    public int getNumV() {
        return graphNodes.length;
    }

    @Override
    public List<T> getNeighbors(int sourceIndex) {
        List<T> neighbors = new ListImpl<T>();
        for (int j = 0; j < this.graphNodes.length; ++j) {
            if (isEdge(graphNodes[sourceIndex],graphNodes[j])) {
                neighbors.append(graphNodes[j]);
            }
        }
        return neighbors;
    }

    @Override
    public Integer getEdgeWeight(T node1, T node2) {
        int i = Arrays.binarySearch(this.graphNodes, node1);
        int j = Arrays.binarySearch(this.graphNodes, node2);
        if (isEdge(graphNodes[i], graphNodes[j])){
            return getEdge(graphNodes[i], graphNodes[j]).weight;
        }
        return Integer.MAX_VALUE; // no edge
    }

    @Override
    public T getNode(int i) {
        return this.graphNodes[i];
    }

    @Override
    public int getNodeIndex(Comparable node) {
        return Arrays.binarySearch(this.graphNodes, node);
    }
}

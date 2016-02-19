package org.sheehan.algorithm.graph;

import org.sheehan.algorithm.data_structures.Stack;
import org.sheehan.algorithm.data_structures.StackImpl;
import org.sheehan.algorithm.data_structures.graph.Graph;
import org.sheehan.algorithm.data_structures.graph.GraphNode;

/**
 * Created by bob on 7/8/14.
 *
 * DFS - stack - mark after pop
 *
 * no shortest paths
 */
public class DFS <T extends Comparable<T>>{
    private boolean marked[];
    private final Graph<T> graph;

    public DFS(Graph graph){
        marked = new boolean[graph.getNumV()];
        this.graph = graph;
    }

    public void visitRecursion(GraphNode<T> v){
        v.visited = true;
        for(GraphNode<T> node: graph.getNeighbors(v)){
            if (!node.visited && graph.isEdge(v, node))
                visitRecursion(node);
        }
    }

    // use a stack for DFS
    public void visitIterative(GraphNode<T> v){
        Stack<GraphNode<T>> stack = new StackImpl<>(graph.getNumV());

        stack.push(v);
        while (stack.peek() != null) {
            GraphNode<T> v1 = stack.pop();
            if (!v1.visited) {
                v1.visited = true; // mark after pop
                for(GraphNode<T> neighbor : graph.getNeighbors(v1)){
                    if (!neighbor.visited && graph.isEdge(v1, neighbor))
                        stack.push(neighbor);
                }
            }
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


}

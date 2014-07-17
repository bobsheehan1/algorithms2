package org.sheehan.algorithm;

/**
 * Created by bob on 7/8/14.
 */
public class DFS {
    private boolean marked[];
    private final GraphUndirected1 graph;

    public DFS(GraphUndirected1 graph){
        marked = new boolean[graph.getNumV()];
        this.graph = graph;
    }

    public void visitRecursion(int v){
        marked[v] = true;
        for (int i = 0; i < graph.getNumV(); ++i){
            if (!marked[i] && graph.isEdge(v, i))
                visitRecursion(i);
        }
    }

    // use a stack for DFS
    public void visitIterative(int v){
        Stack<Integer> stack = new StackImpl<>(graph.getNumV());
        stack.push(v);
        while (stack.peek() != null) {
            int v1 = stack.pop();
            if (!marked[v1]) {
                marked[v1] = true;
                for (int i = 0; i < graph.getNumV(); ++i) {
                    if (!marked[i] && graph.isEdge(v1, i))
                        stack.push(i);
                }
            }
        }
    }

    public void printCoverage() {
        System.out.print("covered ");
        for (int i = 0; i < graph.getNumV(); ++i) {
            if (marked[i])
                System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("uncovered ");
        for (int i = 0; i < graph.getNumV(); ++i) {
            if (!marked[i])
                System.out.print(i + " ");
        }
        System.out.println();
    }

}

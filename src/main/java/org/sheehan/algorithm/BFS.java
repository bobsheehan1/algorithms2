package org.sheehan.algorithm;

/**
 * Created by bob on 7/8/14.
 */
public class BFS {
    private boolean marked[];
    private boolean added[];
    private final GraphUndirected1 graph;

    public BFS(GraphUndirected1 graph){
        marked = new boolean[graph.getNumV()];
        added = new boolean[graph.getNumV()];
        this.graph = graph;
    }

    // use a queue for BFS
    public void visitIterative(int v){
        Queue<Integer> queue = new QueueImpl<>(graph.getNumV());
        queue.add(v);
        while (queue.peek() != null) {
            int v1 = queue.remove();
            marked[v1] = true;
            for (int i = 0; i < graph.getNumV(); ++i) {
                if (!added[i] && graph.isEdge(v1, i)) {
                    queue.add(i);
                    added[i] = true;
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

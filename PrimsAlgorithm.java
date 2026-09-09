import java.util.Arrays;

/**
 * Prim's Algorithm - Minimum Spanning Tree (MST)
 *
 * Graph is represented using an adjacency matrix.
 */
public class PrimsAlgorithm {

    private static final int V = 5;

    /**
     * Finds the vertex with the minimum key value that
     * is not yet included in the MST.
     */
    private static int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    /**
     * Constructs and prints the Minimum Spanning Tree
     * using Prim's Algorithm.
     */
    public static void primMST(int[][] graph) {
        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];

        // Initialize keys as infinity
        // and mark all vertices as not included.
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mstSet, false);

        // Start from vertex 0.
        key[0] = 0;
        parent[0] = -1;

        // MST contains V vertices.
        for (int count = 0; count < V - 1; count++) {

            // Pick the minimum key vertex.
            int u = minKey(key, mstSet);

            // Add the vertex to MST.
            mstSet[u] = true;

            // Update key and parent for adjacent vertices.
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0
                        && !mstSet[v]
                        && graph[u][v] < key[v]) {

                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print the MST.
        System.out.println("Edge \tWeight");

        int totalWeight = 0;

        for (int i = 1; i < V; i++) {
            System.out.println(
                    parent[i] + " - " + i + "\t" + graph[i][parent[i]]
            );

            totalWeight += graph[i][parent[i]];
        }

        System.out.println("Total Weight: " + totalWeight);
    }

    public static void main(String[] args) {

        // Adjacency matrix representation of the graph.
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        primMST(graph);
    }
}

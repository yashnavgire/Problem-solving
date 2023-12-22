import java.util.*;
import java.lang.*;

public class Solution {

    class Node {
        
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static int[] shortestPath(int n, int [][]edges, int src) {
        int i = 0, j = 0;
        boolean[]vis = new boolean[n];
        int[]dis = new int[n];
        Queue<Node> q = new LinkedList<>();

        for (i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        q.offer(new Node(0,0));

        while (!q.isEmpty()) {
            int size = q.size();

            for (i = 0; i < size; i++) {
                Node node = q.poll();
                vis[node] = true;

                for (int adj : edges[node]) {

                    if (dist[adj] > (dist[node] + 1)) {
                        dist[adj] = dist[node] + 1;
                    }

                    q.offer(new Node(adj, dist[adj]));
                }

            }

        }

        return dist;


    }
}

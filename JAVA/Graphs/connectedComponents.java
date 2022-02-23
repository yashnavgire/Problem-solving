import java.util.*;

class Graph {
    int v;
    ArrayList<ArrayList<Integer>> list;

    public Graph(int v) {
        this.v = v;
        this.list = new ArrayList<>();

        for (int i = 0; i <= this.v; i++) {
            list.add(i, new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        this.list.get(src).add(dest);
        this.list.get(dest).add(src);
        return;
    }

    public void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;

        ArrayList<Integer> edges = this.list.get(vertex);

        for (int v : edges) {
            System.out.println(v);
            if (!visited[v]) {
                dfs(v, visited);
            }
        }

        return;
    }

    public int connectedComponent() {
        int i = 0, components = 0;
        boolean[] visited = new boolean[this.v + 1];

        for (i = 1; i <= this.v; i++) {
            if (!visited[i]) {
                dfs(i, visited);
                components++;
            }
        }

        return components;
    }
}

class connectedComponents {
    public static void main(String[] args) {
        Graph g = new Graph(10);

        g.addEdge(1, 2);
        g.addEdge(4, 3);
        g.addEdge(3, 5);
        g.addEdge(6, 7);
        g.addEdge(8, 9);
        g.addEdge(9, 10);

        int comp = g.connectedComponent();

        System.out.println("Connected Comp" + " " + comp);
    }
}

// Problem Link :- https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/#

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCycleDetectedDFS(i, -1, adj, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean isCycleDetectedDFS(int vertex, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[vertex] = true;
        ArrayList<Integer>edges = adj.get(vertex);
        
        for (int edge : edges) {
            if (!visited[edge]) {
                if (isCycleDetectedDFS(edge, vertex, adj, visited)) {
                    return true;
                }
            }
            else if(parent != edge) {
                return true;
            }
        }
        
        return false;
    }
    
}

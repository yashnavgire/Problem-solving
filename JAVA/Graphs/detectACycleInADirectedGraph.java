class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] dfsVis = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (checkCycle(i, adj, vis, dfsVis)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] dfsVis) {
        vis[node] = true;
        dfsVis[node] = true;
        
        for (int ele : adj.get(node)) {
            if (!vis[ele]) {
                if (checkCycle(ele, adj, vis, dfsVis)) {
                    return true;
                }
            }
            else if (dfsVis[ele]) {
                return true;
            }
        }
        
        dfsVis[node] = false;
        
        return false;
    }
}

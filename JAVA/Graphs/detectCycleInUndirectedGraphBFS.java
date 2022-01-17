// Problem Link :- https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/

class Node {
    int current;
    int parent;
    
    Node(int current, int parent) {
        this.current = current;
        this.parent = parent;
    }
}

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCycleDetected(i, adj, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean isCycleDetected(int vertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Node>q = new LinkedList<>();
        q.add(new Node(vertex, -1));
        visited[vertex] = true;
        
        while (!q.isEmpty()) {
            int curr = q.peek().current;
            int parent = q.peek().parent;
            
            q.remove();
            
            for (int ele : adj.get(curr)) {
                if (visited[ele] == false) {
                    q.add(new Node(ele, curr));
                    visited[ele] = true;
                }
                else if (parent != ele) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

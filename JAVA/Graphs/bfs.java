// Problem Link :- https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer>result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        visited[0] = true;
        
        while (!q.isEmpty()) {
            int vertex = q.poll();
            result.add(vertex);
            
            List<Integer> edges = adj.get(vertex);
            
            for (int ele : edges) {
                if (!visited[ele]) {
                    q.add(ele);
                    visited[ele] = true;
                }    
            }
        }
        
        return result;
    }
}

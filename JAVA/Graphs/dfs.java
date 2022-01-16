// Problem Link :- https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1#

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer>result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        
        dfsUtil(0, result, visited, adj);
        
        return result;
    }
    
    public void dfsUtil(int vertex, ArrayList<Integer> result, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[vertex] = true;
        result.add(vertex);
        //System.out.println(vertex);
        List<Integer> list = adj.get(vertex);
        
        for (int ele : list) {
            if (!visited[ele])
                dfsUtil(ele, result, visited, adj);
        }
    }
}

class Solution
{
    public boolean checkBipartite(int node, ArrayList<ArrayList<Integer>>adj, int[] visited) {
        Queue<Integer>q = new LinkedList<>();
        q.add(node);
        visited[node] = 1;
        
        while(!q.isEmpty()) {
            int vertex = q.poll();
            //System.out.println(vertex);
            int parentColour = visited[vertex];
            
            List<Integer>edge = adj.get(vertex);
            
            for (int ele : edge) {
                int colour = visited[ele];
                
                if (colour != -1) {
                    if (parentColour == colour) {
                        return false;
                    }
                }
                else {
                    q.add(ele);
                    
                    if (parentColour == 1) {
                        visited[ele] = 2;    
                    }
                    else {
                        visited[ele] = 1; 
                    }
                }
            }
        }
        
        return true;
    }
    
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj) {
        int[] visited = new int[V];
        Arrays.fill(visited, -1);
        
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == -1) {
                if (!checkBipartite(i, adj, visited)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}

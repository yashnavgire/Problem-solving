// Problem Link :- https://leetcode.com/problems/is-graph-bipartite/submissions/

class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0) {
            return false;
        }
        
        int i = 0, j = 0;
        List<List<Integer>> adj = new ArrayList<>();
        int[] colour = new int[graph.length];
        
        Arrays.fill(colour, -1);
        
        for (int[] ele : graph) {
            List<Integer> tempList = new ArrayList<>();
            
            for (int itr : ele) {
                tempList.add(itr);
            }
            
            adj.add(i, tempList);
            i++;
        }
        
        for (i = 0; i < graph.length; i++) {
            if (colour[i] == -1) {
                boolean val = dfs(adj, i, colour);
                
                if (!val) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean dfs(List<List<Integer>> adj, int node, int[] colour) {
        for (int it : adj.get(node)) {
            if (colour[it] == -1) {
                colour[it] = 1 - colour[node];
                
                if (!dfs(adj, it, colour)) {
                    return false;
                }
            } else if (colour[it] == colour[node]) {
                return false;
            }
        }
        
        return true;
    }
}

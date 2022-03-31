class Solution {
    public int minReorder(int n, int[][] connections) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i  = 1 ; i <= n; i++) {
            List<Integer> edge = new ArrayList<>();
            adj.add(edge);
        }
        
        for (int[] arr : connections) {
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(-arr[0]);
        }
        
        return dfs(adj, visited, 0);
    }
    
    public int dfs(List<List<Integer>> adj, boolean[] visited, int from) {
        int v = Math.abs(from);
        int change = 0;
        visited[v] = true;
        
        for (int to : adj.get(from)) {
            if (!visited[Math.abs(to)]) {
                change += dfs(adj, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
            } 
        }
        
        return change;
    }
}

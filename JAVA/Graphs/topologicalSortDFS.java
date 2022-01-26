class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int index = 0;
        Stack<Integer> st = new Stack<Integer>();
        int[] vis = new int[V];
        
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }   
        }
        
        int[] topo = new int[V];
        
        while (!st.isEmpty()) {
            topo[index++] = st.pop();
        }
        
        return topo;
    }
    
    static void dfs(int node, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        
        for (int ele : adj.get(node)) {
            if (vis[ele] == 0) {
                dfs(ele, vis, st, adj);
            }
        }
        
        st.push(node);
    }
}

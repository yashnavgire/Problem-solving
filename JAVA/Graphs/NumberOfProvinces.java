class Solution {
    public int findCircleNum(int[][] isConnected) {
        int i = 0, provinces = 0;
        boolean[]visited = new boolean[isConnected.length+1];

        for (i = 0; i < isConnected.length; i++) {
            if (visited[i] == false) {
                traverse(i, visited, isConnected);
                provinces++;
            }
        }

        return provinces;
    }

    public void traverse(int node, boolean[] visited, int[][] isConnected) {
        visited[node] = true;

        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visited[i]) {
                traverse(i, visited, isConnected);
            }
        }
    }
}

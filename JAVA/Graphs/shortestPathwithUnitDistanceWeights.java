public void shortestPath(List<List<Integer>> adj, int[] dist, int src) {
    int i = 0, top = 0, parent = 0;
    Arrays.fill(dist, Integer.MAX_VALUE);

    Queue<Integer> q = new LinkedList<>();

    q.offer(src);
    dist[src] = 0;

    while (!q.isempty()) {
        top = q.poll();
        parent = dist[top];

        List<Integer> list = adj.get(top);

        for (int ele : list) {
            if (dist[ele] == Integer.MAX_VALUE) {
                dist[ele] = parent + 1;
                q.offer(ele);
            }
            else {
                dist[ele] = Math.min(parent + 1, dist[ele]);
            }
        }
    }
}

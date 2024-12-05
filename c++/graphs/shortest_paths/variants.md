1. Single source shortest path (SSSP) 
    - Given source node find the shortest path to all nodes/destination nodes
    - unweighted -> BFS
    - weighted -> Djikstra's(+ve edges) TC: O((E+V).log(E)), Bellman ford(-ve edge) TC: O(V.E)

2. Multi source shortest path (MSSP)
    - Find shortest path from multiple source to all nodes/destination nodes
    - unweighted -> Multi source BFS
    - weighted -> 0-1 BFS (2 weights), MSSP on Djikstra, MSSP on Bellman ford 

    Trick for solving MSSP using SSSP strategy on any algorithm:
    Here is the trick that always works for MSSP: 
    1. create a new source, S0, and add an edge (with length 0) from S0 to each of your starting vertices. 
    2. Then, run any shortest-paths algorithm starting from S0 to compute the distance from S0
    to each other vertex. 

3. All pair shortest path (APSP)
    - Find shortest b/w all pairs within the graph
    - Floyd warshall's


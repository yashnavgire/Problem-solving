### Bellman ford algorithm

1. Used for finding single source shortest path when -ve edge present in the graph
2. Used to check if -ve cycle exits in graph
3. USed to find nodes in the -ve cycles in the graph


### Why don't Djikstra;s work on -ve edge & limitations of Djikstra's -

1. djikstra's is a greedy + BFS algorithm, where greedy following part
    // relaxing an edge
    1. if (dist[dest] > dest[current_node] + edge_weight_between_current_dest) {
        dist[dest] =  dest[current_node] + edge_weight_between_current_dest
    }
    2. and we apply visited check and mark visited when we pop node from queue to avoid O(V.E) nodes in queue

    Above assumption will give correct answer only if we consider all edges are +ve

    - If we want to use Djikstra for graph with -ve edge (but no -ve cycles) then we need to remove step 2 of maintaining visited array from above normal Djikstra algo, but that will anyway lead to O(V.E) algorithm
    But when there is -ve cycle in graph this algorithm will not work and we will run into infine loop as in -ve cycle greedy check 1. will keep on finding less distance edges and will be filled in queue indefinitely.

    - Therefore we use bellman ford.


### What is bellman ford algo:

1. Actually bellman ford is brute force algo for finding shortest path for both +ve and -ve edges in weighted graphs
2. Djisktra is optimised for special case when graph only contains +ve edge using greedy to reduce TC

algo -
distance[source] = 0
distance[all_other] = infinity
for |V|-1:
    //relax each edge
    for edge: edges:
        if (distance[edge.to] > distance[edge.from] + edge.cost)
            update distance[edge.to]

Since it is sure that relaxing each edge for length(V)-1, by initialising start nodes distance to zero, all other nodes distance from start will be optimised one's as all edges will get chance to relax

To find if -ve cycle exists we relax all edges one more time and check if the distance of any node still reduces, if it does there is a -ve cycle and that node is part of -ve cycle

To find all nodes across -ve cycles - 
run relaxation again |V|-1 times on top of earlier run, and mark nodes whose distance still reduces.


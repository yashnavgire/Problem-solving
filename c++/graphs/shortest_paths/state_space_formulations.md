### state space formulations in implicit graph problems

Every graph needs - 
1. nodes - which needs states
2. edges - directed/undirected, weighted/unweighted, if weighted then what will decide the weight

In shortest path problem 
- The parameter which needs to be minimised should be modelled to be represented as weights in edge (either as same weights or 0-1 weights or 0..n weights based on problem)

- The additional constraint in the problem is added to the state along with the base state. 

`Ex1: Given n cities and m edges to connect the various cities with each edge having distance and petrol required required to travel that edge. Find following -` 

1. Minimum distance required to travel from node a to node b?
ans ->
- here we want to minimise distance therefore in our graph the edges will be distance and state will be curr_city, therefore we can simply run djikstra on above graph.

2. Minimum petrol required to travel from node a to node b?
- here we want to minimise the petrol required, therefore the edges of our graph will represent the petrol required from node 1 to node 2 and state will be (curr_city), and running djikstra on this graph will give us minimum petrol required

3. If the capacity of vehicle is `k` litre and at each city to refill 1litre of petrol it takes Ci cost then what is the minimum cost required to travel from node a to node b (consider initial petrol as 0 litres at node a) 
- here we have 2 things minimuse the cost and constraint of max k litres.
- in this case it is clear that to travel an edge we need 2 things, 1. at which city we are in and 2. how much petrol current the vehicle contains. Therefore in our state we will need to maintain atleast both of this (city, current_petrol_in_vehicle) and there can be multiple ways to reach this state
- now to identify what should be edge representing, we want to minimise the cost -> therefore edge in our graph would represent the cost required to travel from one state to another state based on the petrol required to go node a to node b in original graph
(note here state includes both (city,current_petrol_in_vehicle) therefore there can be multiple ways to go from node 1 -> node 2 with various possibility of [current_petrol_in_vehicle] at node2 coming from node1 and bounded by k as max capacity).
In this case for implementation we can maintain edge in original graph with weight as given in problem(dist, petrol) but based on what to optimise in djikstra we can push the required parameter in priority queue. 


`Ex2: Virtual Junction node pattern`

Given an array having n elements, the cost to move from ith element to its adjacent element (if exist) at i+1 and i−1 is b and the cost to move to other same valued index is a. Find min cost to reach every index from a given source index of the array.

here to make all edges from one same value node to another same value node with weight `a` will lead to n^2 (nC2) edges in worst case and since the shortest path algorithm depends on edges it will impact TC. Therefore to reduce the number of edges in such scenario `where we want to connect all pairs of same value nodes` we can use `junction node concept`, where we will create one dummy node junction to which all same value nodes will connect with `0` weight and there will be edge from junction node to all same nodes with weight `a`. Now we can reach from one same value node to other same value node through this junction node with same weight(0+a) and also there number of edges will be `2*n` (reduced from n^2)


#### Leetcode problems and patterns/tricks

1. leetcode 2045: new idea to pick -> how to find top k min distance from source to destination in djikstra/BFS, allow visited to that node multiple times and relax its neighbours with the curr distance to that node (if top k min distance to that node is obtained then don't allow to visit that node again) 

2. leetcode 2203: 
    1. new idea to pick ->  in a directed graph if we want to find the shortest distance from all nodes to some node(say target node) then we can reverse the graph and run djikstra/bfs by considering the source as target node. since distance[a->b] = distance[b->a]
    2. In the given problem there are multiple cases for path b/w src1->target  & src2->target and we want to minise the sum of 2 paths we choose. optimal cases could
        1. both optimal paths are independent i.e common node in 2 paths is target
        2. both optimal paths is from some common node and from common node to target it will be common path. i.e common node here some node != src1, src2, target
        3. both optimal path is from either src1 or src2. i.e common node = src1/src2
        4. Therefore, generically we want to consider all nodes as common node and find sum of paths = distance_src1[common_node] + distance_src2[common_node] + distance_common_node[target], for all common_node: 1->n
    3. Therefore in above equation to identify -
        1. distance_src1[common_node] - run djikstra from src1 to get shortest path to all nodes
        2. distance_src2[common_node] - run djikstra from src2 to get shortest path to all nodes
        3. distance_common_node[target] is also equal to distance of target to common node. therefore instead of running djisktra from all possible common node to get shortest path from common node to target, we can use the new idea mentioned in pt1, by reversing the graph and running djisktra on target node as source, so in one run we get shortest path to all possible common nodes from target.
        4. once we have 3.1, 3.2, 3.3 we can find 2.4 equation and take min value


#### other techniques
1. GIven a graph, find number of shortest paths from source to destination -
    1. maintain a state for number of shortest path at each node, going from node1 -> node2 
        1. if distance[node1->node2] < dist[node2] => number_sp[node2] = number_sp[node1]
        2. if distance[node1->node2] == dist[node2] => number_sp[node2] += number_sp[node1]

2. Pseudo junction node trick/concept
    1. when number of edges in given problem seems to go quite huge then try to add these junction node for connecting similar property nodes through this junction (node->junction with weight 0 and junction->node with weight), node all similar nodes (n) are connected with only 2*n edges and not nC2 or n^2 edges.

3. Modelling bit string based nodes to number nodes with bitwise manipulation (storing string in each state of node in grp would memory exceed / time limit on string operations), therefore try to see if nodes & states can be modelled in numbers for string problems to where graph is to be used


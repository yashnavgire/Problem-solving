### state space formulations in implicit graph problems

Every graph needs - 
1. nodes - which needs states
2. edges - directed/undirected, weighted/unweighted, if weighted then what will decide the weight

In shortest path problem 
- The parameter which needs to be minimised should be modelled to be represented as weights in edge (either as same weights or 0-1 weights or 0..n weights based on problem)

- The additional constraint in the problem is added to the state along with the base state. 

`Ex1: Given n cities and m edges to connect the various cities with each edge having distance and petrol required required to travel that edge. Find following -` 

1. minimum distance required to travel from node a to node b?
ans ->
- here we want to minimise distance therefore in our graph the edges will be distance and state will be curr_city, therefore we can simply run djikstra on above graph.

2. minimum petrol required to travel from node a to node b?
- here we want to minimise the petrol required, therefore the edges of our graph will represent the petrol required from node 1 to node 2 and state will be (curr_city), and running djikstra on this graph will give us minimum petrol required

3. If the capacity of vehicle is `k` litre and at each city to refill 1litre of petrol it takes Ci cost then what is the minimum cost required to travel from node a to node b (consider initial petrol as 0 litres at node a) 
- Here we have 2 things minimuse the cost and constraint of max k litres.
- In this case it is clear that to travel an edge we need 2 things, 1. at which city we are in and 2. how much petrol current the vehicle contains. Therefore in our state we will need to maintain atleast both of this (city, current_petrol_in_vehicle) and there can be multiple ways to reach this state
- Now to identify what should be edge representing, we want to minimise the cost -> therefore edge in our graph would represent the cost required to travel from one state to another state based on the petrol required to go node a to node b in original graph
(note here state includes both (city,current_petrol_in_vehicle) therefore there can be multiple ways to go from node 1 -> node 2 with various possibility of [current_petrol_in_vehicle] at node2 coming from node1 and bounded by k as max capacity).
In this case for implementation we can maintain edge in original graph with weight as given in problem(dist, petrol) but based on what to optimise in djikstra we can push the required parameter in priority queue. 


`Ex2: Virtual Junction node pattern`

Given an array having n elements, the cost to move from ith element to its adjacent element (if exist) at i+1 and i−1 is b and the cost to move to other same valued index is a. Find min cost to reach every index from a given source index of the array.

here to make all edges from one same value node to another same value node with weight `a` will lead to n^2 (nC2) edges in worst case and since the shortest path algorithm depends on edges it will impact TC. Therefore to reduce the number of edges in such scenario `where we want to connect all pairs of same value nodes` we can use `junction node concept`, where we will create one dummy node junction to which all same value nodes will connect with `0` weight and there will be edge from junction node to all same nodes with weight `a`. Now we can reach from one same value node to other same value node through this junction node with same weight(0+a) and also there number of edges will be `2*n` (reduced from n^2)

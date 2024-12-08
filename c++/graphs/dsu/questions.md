### AZ DSU module

#### Edge removal

Given a graph with n nodes and m edges, there are Q queries with following 2 operations - 
1. remove an edge x
2. number of connected components in current graph

Brute force-
1. remove edge and run DFS for each find # of CC queries TC: Q*O(V+E)

Optimise: using DSU
In DSU we can only merge and cannot decompose to original graph with remove operation.

Therefore here to use DSU, somehow we need to think if merging the edges can lead to optimal result.

1. We can pre-process all the edges which are going to be removed and while building initial graph those edges will not be connected.
2. This configuration is nothing but the config when all the given edges are removed. Therefore in this configutation the number of connected components will be the one after removing all edges.
3. Now we will merge(rank compression) each edge in reverse order of that obtained from Queries and update base number of connected components obtained in step2 (reduce if parent are different / keep same of parent are same) 


### Find number of paths passing through an edge by considering size of component associated with the edge nodes.

problem: given a weighted tree with n nodes and m edges, find the smallest weight edge for each path between all nodes 

1. Initially all nodes are disconnected and their component size=1

2. We process edge in descending order and start with larger weight edge, to calculate the number of paths passing through this edge(node1-node2) would be `component_size_node_1*component_size_node_2`
Here as the edges are processed in descending order, we are sure that all current edge length would be minimum for all paths from all components from one edge node to all components of other edge node

3. Merge nodes(with its component size) of that edge   
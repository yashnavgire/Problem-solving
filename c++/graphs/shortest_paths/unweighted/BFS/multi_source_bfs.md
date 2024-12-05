Problem statement- 
- Given multiple source and multiple exits find any nearest exit for each source
- This can be a weighted or unweighted graph
- For unweighted we will apply BFS, for weighted we will apply Djisktra/Bellman ford with following strategy

Unweighted - 

Brute-force:
1. Perform BFS from each source node and consider 1st exit reached.
TC: O(#s.(n+e)), where #s: number of sources, n: number of nodes, e: number of edges
for grid based problems -> TC: O(#s.n.m)

Multi-Source BFS:

- Identify what redundant thing we are doing in brute force? -> we travel common path in individual BFS(Djikstra/Bellman ford) of each source multiple times

equation we want to solve: 
- For every source(s[i]) find any of nearest exit(from exit[i]...exit[j])
i.e: source is constant and exit is variable, therefore to ensure every source has only one nearest exit path,
- We can start the BFS from exit & to optimise we can consider all exit nodes at level 0.

Now while running BFS parallely at each step from every exit we will span out and mark cells visited. Therefore we eliminate the redundant path being traversed in brute-force since if one cell is already visited from other exit we do not need other path from exit as it will always have greater distance.

In this case the source of the BFS was the exits and not the source given in problem. 
---------------------------------------------------------------------------------------
Weighted or run MSSP on any other shortest path algo, following is the common trick

Here is the trick that always works for MSSP: 
1. create a new source, S0, and add an edge (with length 0) from S0 to each of your starting vertices. 
2. Then, run any shortest-paths algorithm starting from S0 to compute the distance from S0
 to each other vertex.

--------------------------------------------------------------------------------------- 
To identify which nodes to be source in MSSP BFS i.e which nodes at 0th level / to which nodes we need to connect the virtual node -

1. analyse problem and see on what type of nodes the constraint is any
2. in above case we wanted to 
    find shortest path for every source to any of exit
   therefore the 0th level nodes in our BFS became exits







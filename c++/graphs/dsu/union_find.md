### union find

direct problem: given Q queries for join components and find number of components.

If we try with normal DFS to find number of components for each query we will need O(V+E)
and for Q queries Q.O(V+E)

To optimise lets analyse what are the 2 operations we are performing for above queries - 

1. findParent -> number of distinct parents = number of components
following takes O(N) for 1st query/whenever new component added as it will perform recursion n times but for subsequent queries without merge it will perform in constant time as all nodes will be the first child of parent.
So in average for Q queries it will take O(logN) time
findParent(node a):
    if (parent[a] == a) return a;
    return findParent(parent[a]);

2. merge -> merge one component to other
following brute force way for merging would take O(N) as we call find operation internally
merge(node a, node b):
    parent a = findParent(a);
    parent b = findParent(b);

    parent[a] = b; //merge


optimisations:

1. rank compression:
- instead of naively merging the 2 components in merge operation try to get the balanced tree after merging, which leads to O(logN) to time traverse from leaf to node(without path compression).

merge_rank_compression(node a, node b):
    parent a = findParent(a);
    parent b = findParent(b);

    if (rank[b] > rank[a]): //small to large
        parent[b] = parent[a]
        rank[b] += rank[a]
    else:
        parent[a] = parent[b]
        rank[a] += rank[b]

2. path compression: 
- memoize the parent while finding parent first time after merge, so in next find call these nodes will be immediate child of parent
- following takes O(N) for 1st query/whenever new component added as it will perform recursion n times but for subsequent queries without merge it will perform in constant time as all nodes will be the first child of parent.
- So in average for Q queries it will take O(logN) time (without rank compression)
- With rank compression + path compression overall amortized TC: O(log(logN)) ~ constant time (as in worst case we need to traverse logN in find operation)

findParent_path_compression(node a):
    if (parent[a] == a) return a;
    parent[a] = findParent(parent[a]); //path compression
    return parent[a]













/*
1. use queue
2. mark visited array when adding in queue itself

*/

class BFSTraversals {

  /*
    - works for undirected and directed unweighted graphs
    - SC : O(2N)
      TC : O(N) + O(2E) 

    - Input
      1. number of nodes
      2. adj list

    Note: 
      - In many cases like graph in matrix we only know the starting node(not the total nodes and the adjacency list)
        In such case,  edges-> directions in which we need to traverse from each node
          start from first node
            to identify nodes at particular level, 
              check current size of queue and add for loop to pop those many elements(at particular level) from queue and perform bfs
              do this until q is not empty
        
  */
  vector<int> unweightedBfs(int n, vector<int> adj[]) {
    bool visited[n] = {false};
    queue<int> q;

    //start bfs from node 0 
    q.push(0);
    visited[0] = 1;

    vector<int> bfs;

    while(!q.empty()) {
      int node = q.front();
      q.pop();

      bfs.push_back(node);

      for(auto it : adj[node]) {
        if(!visited[it]) {
          q.push(it);
          visited[it] = 1;
        }
      }
    }

    return bfs;
  }


/*
  - For weighted graph the input will be pair/node
*/



}


/*
 *
 *
Given an undirected and disconnected graph G(V, E), containing 'V' vertices and 'E' edges, the information about edges is given using 'GRAPH' matrix, where i-th edge is between GRAPH[i][0] and GRAPH[i][1]. print its DFS traversal.

V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.

E is the number of edges present in graph G.

Note :

The Graph may not be connected i.e there may exist multiple components in a graph.



Sample Input 1:

5 4
0 2
0 1
1 2
3 4

Sample Output 1:

2
0 1 2
3 4

*
*
*/



void dfs(vector<vector<int>>& adj,int node,vector<bool>& visited,vector<int>& component){
	if(visited[node])
		return;
	
	visited[node] = true;
	component.push_back(node);
	
	//dfs over all adjacent cells of that node
	for(int i=0;i<adj[node].size();i++)
	{
		dfs(adj,adj[node][i],visited,component);
	}
}

vector<vector<int>> depthFirstSearch(int V, int E, vector<vector<int>> &graph)
{
    
	vector<vector<int>> ans;
	
	//create adjacency list
	// graph edges :   
	//0 4
	//2 0
	//2 4
	//3 0
	//3 2
	//4 3

	//adjacency list :
	// 0 -> 4,3,2
	// 1 -> 
	// 2 -> 0,4,3
	// 3 -> 0,2,4
	// 4 -> 0,2,3
	
	vector<vector<int>> adj(V);
	vector<bool> visited(V,false);
	
	for(int i=0;i<E;i++)    			// adj ->    
	{								   //
		adj[graph[i][0]].push_back(graph[i][1]);
		adj[graph[i][1]].push_back(graph[i][0]);
	}
	
	//find components
	for(int i=0;i<adj.size();i++){
		if(!visited[i])
		{
			vector<int> component;
			dfs(adj,i,visited,component);
			sort(component.begin(),component.end());
 			
			ans.push_back(component);
		}
	}
	
	return ans;
}




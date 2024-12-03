/*
 *Problem Statement
You are given an undirected graph in the form of an adjacency matrix along with an integer M. You need to tell if you can color the vertices of the graph using at most M colors such that no two adjacent vertices are of the same color.
For example:

If the given adjacency matrix is:
[0 1 0]
[1 0 1]
[0 1 0] and M = 3.
The given adjacency matrix tells us that 1 is connected to 2 and 2 is connected to 3. So if we color vertex 1 with 2, vertex 2 with 1, and vertex 3 with 2, it is possible to color the given graph with 2 colors: M.



1 ≤ T ≤ 1000
1 ≤ V ≤ 20
1 ≤ M ≤ V

Time Limit : 1 sec 

Sample Input 1:

3
3 3
0 1 0
1 0 1
0 1 0
3 1
0 1 0
1 0 1
0 1 0
2 1
0 1
1 0

Sample Output 1:

YES
NO
NO

*
*/

bool isPossible(vector<vector<int>> &mat,vector<int>& colour,int vertex,int selected)
{
    for(int j=0;j<mat[vertex].size();j++)
    {
        if(mat[vertex][j]==1 && colour[j] == selected)
            return false;
    }
    
    return true;
}

bool dfs(vector<vector<int>> &mat,vector<int>& colour,int vertex,int m)
{
    //if reached this pt that means all nodes can be coloured according to rules,therefore return true
    if(vertex >= mat.size())
        return true;
    
    for(int i=0;i<m;i++)
    {
    	if(isPossible(mat,colour,vertex,i))
        {
            colour[vertex] = i;
            if(dfs(mat,colour,vertex+1,m))
                return true;
            
            colour[vertex] = -1;
        }
    }
    
    return false;
}

string graphColoring(vector<vector<int>> &mat, int m) {
    // Write your code here
    if(mat.size() == 0 || m == 0 )
        return "NO";
    
    vector<int> colour(mat.size(),-1);
    
    int ret = dfs(mat,colour,0,m);
    
    return ret == true ?  "YES" :  "NO";
}

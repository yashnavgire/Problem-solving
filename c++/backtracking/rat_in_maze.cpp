
/*
 *
 * Problem Statement
You are given a 'N' * 'N' maze with a rat placed at 'MAZE[0][0]'. Find and print all paths that rat can follow to reach its destination i.e. 'MAZE['N' - 1]['N' - 1]'. Rat can move in any direc­tion ( left, right, up and down).
Value of every cell in the 'MAZE' can either be 0 or 1. Cells with value 0 are blocked means the rat can­not enter into those cells and those with value 1 are open.


Sample Input 1 :

3
1 0 1
1 0 1
1 1 1

Sample Output 1 :

1 0 0 1 0 0 1 1 1 

*
*/

#include<bits/stdc++.h>

vector<vector<int>> ans;

void path(vector<vector<int>> &maze,int row,int col,vector<vector<int>>& currpath)
{
    //-ve base
    if(row < 0 || col <0 || row >= maze.size() || col >= maze.size() || maze[row][col] == 0 || currpath[row][col] == 1)
        return;
    
    //+ve base
    if(row == maze.size()-1 && col == maze.size()-1 && maze[row][col]==1)
    {
        currpath[row][col] = 1;
        vector<int> tmp;
        for(int i=0;i<currpath.size();i++)
        {
            for(int j=0;j<currpath[i].size();j++)
            {
                tmp.push_back(currpath[i][j]);
            }
        }
        ans.push_back(tmp);
        currpath[row][col] = 0;
        return;
    }
    
    currpath[row][col] = 1;
    
    path(maze,row,col+1,currpath);
    path(maze,row,col-1,currpath);
    path(maze,row+1,col,currpath);
    path(maze,row-1,col,currpath);
    
    currpath[row][col] = 0;
}

vector<vector<int> > ratInAMaze(vector<vector<int> > &maze, int n){
  // Write your code here.
    vector<vector<int>> currpath(maze.size(),vector<int>(maze.size(),0));
    path(maze,0,0,currpath);
    
    return ans;
    
}

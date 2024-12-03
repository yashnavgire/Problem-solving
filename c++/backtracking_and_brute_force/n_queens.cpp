/*
 *
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.



Example 1:

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

*/

class Solution {
public:
    vector<vector<string>> ans;
    
    bool chkBoard(vector<string>& chess,int row,int col,vector<bool>& cols,vector<bool>& diagonal,
                  vector<bool>& rdiagonal)
    {
        //chk in cols , if that coloumn has a queen filled already
        if(cols[col] == true)
            return false;
        
        //chk in diagonal(traditional matrix diagonals)
        else if(diagonal[chess.size()-1 - (row-col)] == true)
            return false;
        
        //chk in reverse diagonal
        else if(rdiagonal[row+col] == true)
            return false;
        
        return true;
    }
    
    void set_cd(int row,int col,int n,vector<bool>& cols,vector<bool>& diagonal,vector<bool>& rdiagonal,bool value)
    {
        cols[col] = value;
        diagonal[ (n-1) - (row-col)] = value;
        rdiagonal[row+col] = value;
    }
    
    
    void combination(vector<string>& chess,int row,vector<bool> cols,
                     vector<bool> diagonal,vector<bool> rdiagonal)
    {
        if(row == chess.size())
        {
            ans.push_back(chess);
        }
        
        for(int j=0;j<chess.size();j++)
        {
            //check if chessboard is valid by considering current position as a queen.
            if(chkBoard(chess,row,j,cols,diagonal,rdiagonal))
            {
                //set the cols and diagonals .
                set_cd(row,j,chess.size(),cols,diagonal,rdiagonal,true);
                chess[row][j] = 'Q';
                
                combination(chess,row+1,cols,diagonal,rdiagonal);
                
                //reset(backtrack)
                chess[row][j] = '.';
                set_cd(row,j,chess.size(),cols,diagonal,rdiagonal,false);
            }
        }
    }
    
    vector<vector<string>> solveNQueens(int n) {
           vector<bool> cols(n,false);
           vector<bool> diagonal(2*n-1,false);
           vector<bool> rdiagonal(2*n-1,false);
        
           vector<string> chess(n);
           string s(n,'.');
            for(int i=0;i<n;i++)
            {
                chess[i] = s;
            }
        
            combination(chess,0,cols,diagonal,rdiagonal);
            
        return ans;
    }
};

// Problem Link :- https://leetcode.com/problems/n-queens/submissions/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        dfs(board, res, 0);
        
        return res;
    }
    
    public void dfs(char[][] board, List<List<String>> res, int col) {
        if (col == board.length) {
            res.add(build(board));
            return;
        }
        
        for(int row = 0; row <  board.length; row++) {
            if (validate(board, row, col)) {
                board[row][col] = 'Q';
                dfs(board, res, col+1);
                board[row][col] = '.';
            }
        }
    }
    
    public boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;
        
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            
            col--;
        }
        
        row = duprow;
        col = dupcol;
        
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
            
        }
        
        row = duprow;
        col = dupcol;
        
         while (row < board.length && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }
        
        return true;
    }
    
    public List<String> build(char[][] board) {
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        
        return res;
    }
}

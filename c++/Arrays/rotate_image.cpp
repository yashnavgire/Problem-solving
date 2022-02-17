class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        //swap the upper and lower triangular matrix
        for(int i=0;i<matrix.size();i++)
        {
            for(int j=i+1;j<matrix[i].size();j++)
            {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        
        //swap column elements of each row
        for(int i=0;i<matrix.size();i++){
            int len = matrix[i].size();
            for(int j=0;j<len/2;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len-j-1];
                matrix[i][len-j-1] = tmp;
            }
        }
    }
};

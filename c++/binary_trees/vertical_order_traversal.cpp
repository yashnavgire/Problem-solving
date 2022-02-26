/*
 *
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.


https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

*/




/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}it
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */


class Solution {
public:
    static bool compare(pair<int,int> p1,pair<int,int> p2)
    {
        if(p1.second < p2.second)
            return true;
        
        else if(p1.second == p2.second)
        {
            return p1.first < p2.first ? true : false;
        }
        
        return false;
    }
    
    void verticalOrderDfs(TreeNode * node,map<int,vector<pair<int,int>>>& mp,int distance,int level)
    {
        if(node == nullptr)
            return;

        if(mp.find(distance)!=mp.end())
        {
            mp[distance].push_back({node->val,level});
        }
        else{
            mp[distance] = vector<pair<int,int>>(1,{node->val,level});
        }

        verticalOrderDfs(node->left,mp,distance-1,level+1);
        verticalOrderDfs(node->right,mp,distance+1,level+1);
        
    }

    vector<vector<int>> verticalTraversal(TreeNode* root) {
        vector<vector<int>> ans;
        map<int,vector<pair<int,int>>> mp;
            
        verticalOrderDfs(root,mp,0,0);
        
        for(auto it:mp)
        {
            sort(it.second.begin(),it.second.end(),compare);
            
            vector<int> tmp;
            for(int i=0;i<(it.second.size());i++)
            {
                tmp.push_back((it.second[i]).first);
            }
            
            ans.push_back(tmp);
        }
        
        return ans;
    }
};

/*
-keep mapping of distance(use ordered map) and list of nodes at that distance(node should also contain the level to later sort it). 
-custom sort each vector according to level and values as mentioned in question. 

*/

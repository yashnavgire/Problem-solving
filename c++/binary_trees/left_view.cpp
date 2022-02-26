/*
 *
 * problem link : https://www.codingninjas.com/codestudio/problems/920519?leftPanelTab=0
 *
 */



/************************************************************

    Following is the TreeNode class structure

    template <typename T>
    class TreeNode {
       public:
        T data;
        TreeNode<T> *left;
        TreeNode<T> *right;

        TreeNode(T data) {
            this->data = data;
            left = NULL;
            right = NULL;
        }
    };

************************************************************/
#include<bits/stdc++.h>

void leftViewdfs(TreeNode<int> *node,int level,vector<int>& ans)
{
    if(node == NULL)
        return;
    
    if(level==ans.size())
    {
        ans.push_back(node->data);
    }
    
    leftViewdfs(node->left,level+1,ans);
	leftViewdfs(node->right,level+1,ans);
}


vector<int> getLeftView(TreeNode<int> *root)
{
    //    Write your code here
    vector<int> ans;
    set<int> hs;
    
    leftViewdfs(root,0,ans);
    
    return ans;
}

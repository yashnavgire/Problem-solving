/*
 *
 problem link : https://www.codingninjas.com/codestudio/problems/799401?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
*
*/

/************************************************************

    Following is the TreeNode class structure:

    template <typename T>
    class TreeNode {
       public:
        T val;
        TreeNode<T> *left;
        TreeNode<T> *right;

        TreeNode(T val) {
            this->val = val;
            left = NULL;
            right = NULL;
        }
    };

************************************************************/
#include<bits/stdc++.h>
void topViewDfs(TreeNode<int> * node,map<int,pair<int,int>>& mp,int distance,int level)
{
    if(node == nullptr)
        return;
    
    if(mp.find(distance)!=mp.end())
    {
        //if current node is more bottom than last node for same distance then overwrite.
//         std::cout<<distance<<" "<<level<<" "<<mp[distance].second<<std::endl;
        if(level<(mp[distance].second))
            mp[distance] = {node->val,level};

    }
    else{
        mp[distance] = {node->val,level};
    }

    topViewDfs(node->left,mp,distance-1,level+1);
    topViewDfs(node->right,mp,distance+1,level+1);
    
}

vector<int> getTopView(TreeNode<int> *root) {
    // Write your code here.
    vector<int> ans;
    map<int,pair<int,int>> mp;
    topViewDfs(root,mp,0,0);

    for(auto it=mp.begin();it!=mp.end();it++)
    {
//         std::cout<<(it->first)<<std::endl;
        ans.push_back((it->second).first);
    }
    return ans;
}

/*
 * Given a binary tree, print its bottom view from left to right. Assume, the left and the right child make a 45-degree angle with the parent.
A binary tree is a tree in which each parent node has at most two children.
A node will be in the bottom-view if it is the bottom-most node at its horizontal distance from the root.
Note :

1. The horizontal distance of the root from itself is 0. The horizontal distance of the right child of the root node is 1 and the horizontal distance of the left child of the root node is -1.

2. The horizontal distance of node 'n' from root = horizontal distance of its parent from root + 1, if node 'n' is the right child of its parent.

3. The horizontal distance of node 'n' from root = horizontal distance of its parent from the root - 1, if node 'n' is the left child of its parent.

4. If more than one node is at the same horizontal distance and is the bottom-most node for that horizontal distance, including the one which is more towards the right.

5. You are not required to print the output explicitly, it has already been taken care of. Just implement the function and return the answer, which is the sequence of nodes from left to right in the bottom view.


problem link : https://www.codingninjas.com/codestudio/problems/893110?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

*
*/



/*************************************************************
 
    Following is the Binary Tree node structure.

    class BinaryTreeNode 
    {
    public : 
        T data;
        BinaryTreeNode<T> *left;
        BinaryTreeNode<T> *right;

        BinaryTreeNode(T data) {
            this -> data = data;
            left = NULL;
            right = NULL;
        }
    };

*************************************************************/
void bottomViewDfs(BinaryTreeNode<int> * node,map<int,pair<int,int>>& mp,int distance,int level)
{
    if(node == nullptr)
        return;
    
    if(mp.find(distance)!=mp.end())
    {
        //if current node is more bottom than last node for same distance then overwrite.
//         std::cout<<distance<<" "<<level<<" "<<mp[distance].second<<std::endl;
        if(level>=(mp[distance].second))
            mp[distance] = {node->data,level};

    }
    else{
        mp[distance] = {node->data,level};
    }

    bottomViewDfs(node->left,mp,distance-1,level+1);
    bottomViewDfs(node->right,mp,distance+1,level+1);
    
}

vector<int> bottomView(BinaryTreeNode<int> * root){

    // Write your code here.
    vector<int> ans;
    map<int,pair<int,int>> mp;
    bottomViewDfs(root,mp,0,0);

    for(auto it=mp.begin();it!=mp.end();it++)
    {
//         std::cout<<(it->first)<<std::endl;
        ans.push_back((it->second).first);
    }
    return ans;
    
}


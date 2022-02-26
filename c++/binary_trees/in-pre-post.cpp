/************************************************************

    Following is the Binary Tree node structure:

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


************************************************************/
void allTraversal(BinaryTreeNode<int> * node,vector<vector<int>>& ans)
{
    if(node == nullptr)
        return;
    
    ans[1].push_back(node->data);
    allTraversal(node->left,ans);
    ans[0].push_back(node->data);
    allTraversal(node->right,ans);
    ans[2].push_back(node->data);

}
vector<vector<int>> getTreeTraversal(BinaryTreeNode<int> *root){
    // Write your code here.
    vector<vector<int>> ans(3);
    
    allTraversal(root,ans);
    
    return ans;
}

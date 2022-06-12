/*
 *
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}


// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    Node* dfs(Node* node,unordered_map<int,Node*>&visited)
    {
        if(node==NULL)
            return NULL;
        
        if(visited.find(node->val)!=visited.end())
            return visited[node->val];
        
        vector<Node*> neighbors;
        Node* curr = new Node(node->val,neighbors);
        visited[node->val] = curr;
        
        for(int i=0;i<(node->neighbors.size());i++)
        {
            curr->neighbors.push_back(dfs(node->neighbors[i],visited));        
        }
        
        return curr;
    }
    
    Node* cloneGraph(Node* node) {
        unordered_map<int,Node*> visited;
        return dfs(node,visited);
    }
};

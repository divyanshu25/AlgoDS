/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;

    Node() {}

    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
public:
    map<Node*, Node*> mp;

    Node* helper(Node *ans, Node* node){
        if(mp.find(node) != mp.end()){
            return mp[node];
        }
        vector<Node*> tmp;
        ans = new Node(node -> val, tmp);
        mp[node] = ans;
        for(int i = 0; i < (node->neighbors).size(); i++){
            if((node->neighbors)[i] != NULL){
                Node * t;
                t = helper(t, node -> neighbors[i]);
                (ans -> neighbors).push_back(t);
            }
        }
        return ans;
    }
    Node* cloneGraph(Node* node) {
        Node *ans = NULL;
        return helper(ans, node);
    }
};
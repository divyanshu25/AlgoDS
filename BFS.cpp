#include <iostream>
#include <list>
using namespace std;

class Graph{
    int V; // num of edges
    list<int> *adj; // adj List

    public:
        Graph(int V);
        void addEdge(int s, int e);
        void BFS(int s);
};
Graph::Graph(int V){
    this -> V = V;
    adj = new list<int>[V];
}

void Graph::addEdge(int s, int e){
    adj[s].push_back(e);
    // adj[e].push_back(s);
}

void Graph::BFS(int s){
    bool *visited = new bool[V];
    for(int i =0; i < V; i++)
        visited[i] = false;
    list<int> q;
    q.push_back(s);
    visited[s] = true;
    while(!q.empty()){
        int head = q.front();
        q.pop_front();
        cout << head << " ";
        for(auto it = adj[head].begin(); it!= adj[head].end(); ++it){
            if(!visited[*it]){
                q.push_back(*it);
                visited[*it] = true;
            }
        }
    }
}

int main(){
    Graph g(4); 
    g.addEdge(0, 1); 
    g.addEdge(0, 2); 
    g.addEdge(1, 2); 
    g.addEdge(2, 0); 
    g.addEdge(2, 3); 
    g.addEdge(3, 3); 
  
    cout << "Following is Breadth First Traversal "
         << "(starting from vertex 2) \n"; 
    g.BFS(2); 
  
    return 0; 

}
#include <iostream>
#include <list>
#include <queue> 

using namespace std;

class Graph{
    int V; // int vertices
    list<int> *adj;
    bool isCyclicUtil(int s, bool* visited, bool* recStack);

    public:
    Graph(int V);
    void addEdge(int s, int e);
    bool isCyclic();
};

Graph::Graph(int V){
    this -> V = V;
    adj = new list<int>[V];
}

void Graph::addEdge(int s, int e){
    adj[s].push_back(e);
}
bool Graph::isCyclicUtil(int s, bool* visited, bool* recStack){
    visited[s] = true;
    recStack[s] = true;

    bool ans = false;
    for(auto it = adj[s].begin(); it!= adj[s].end(); ++it){
        if(recStack[*it]){
            return true;
        }
        if(!visited[*it]){
            return isCyclicUtil(*it, visited, recStack);
        }
    
    }
    recStack[s] = false;
    return false;
}

bool Graph::isCyclic(){
    bool *visited = new bool[V];
    bool *recStack = new bool[V];
    for(int i = 0 ; i < V; i ++){
        visited[i] = false;
        recStack[i] = false;
    }
    for(int i = 0; i < V; i++){
        if(!visited[i]){
             if(isCyclicUtil(i, visited, recStack)){
                 return true;
             }
        }
    }
    return false;
}
int main(){
    Graph g(4); 
    g.addEdge(0, 1); 
    g.addEdge(0, 2); 
    g.addEdge(1, 2); 
    // g.addEdge(2, 0); 
    g.addEdge(2, 3); 
    // g.addEdge(3, 3); 
  
    if(g.isCyclic()) 
        cout << "Graph contains cycle"; 
    else
        cout << "Graph doesn't contain cycle"; 
    return 0; 

}
#include <iostream>
#include <list>

using namespace std;
class Graph{
	int V;
	list<int> *adj;
	void DFSUtil(int v, bool *visited);
	public:
	Graph(int V); //constructor
	void addEdge(int s, int e); //addEdge
 	void DFS(int s); // DFS
};

Graph::Graph(int V){
	this -> V = V;
	adj = new list<int>[V];
}
void Graph::addEdge(int s, int e){
		adj[s].push_back(e);
}
void Graph::DFSUtil(int s, bool *visited){
	visited[s] = true;
	cout << s << " ";
	for(auto it = adj[s].begin(); it!= adj[s].end(); it++){
		if(!visited[*it]){
			DFSUtil(*it, visited);
		}
	}
}

void Graph::DFS(int s){
	bool *visited = new bool[V];
	for(int i = 0 ; i < V; i++){
		visited[i] = false;
	}
	DFSUtil(s, visited);
	
	
}


int main() {
	// your code goes here
	Graph g(4); 
    g.addEdge(0, 1); 
    g.addEdge(0, 2); 
    g.addEdge(1, 2); 
    g.addEdge(2, 0); 
    g.addEdge(2, 3); 
    g.addEdge(3, 3); 
  
    cout << "Following is Depth First Traversal"
            " (starting from vertex 2) \n"; 
    g.DFS(2); 
  
    return 0; 
}
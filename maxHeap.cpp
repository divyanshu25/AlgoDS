#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
// #include <priority_queue>
using namespace std;

int main(){
    priority_queue<int> pq;
    pq.push(10);
    pq.push(50);
    pq.push(20);
    pq.push(30);
    pq.push(80);
    cout << pq.top() << endl;
    pq.pop();
    cout << pq.top() << endl;


    //=======================================================//
    vector<int> v1;
    v1.push_back(10);
    v1.push_back(20);
    v1.push_back(30);
    v1.push_back(40);
    v1.push_back(60);
    v1.push_back(40);
    // construct a heap
    make_heap(v1.begin(), v1.end());
    v1.push_back(80);
    //add element to heap
    push_heap(v1.begin(), v1.end());
    cout << v1.front() << endl;
    pop_heap(v1.begin(), v1.end());
    v1.pop_back();
    cout << v1.front() << endl;

    //<check https://www.geeksforgeeks.org/heap-using-stl-c/ for more operations on heap>
    // sort_heap()
    // is_heap()
    // is_heap_until()
    return 0;
}
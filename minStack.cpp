//
// Created by Divyanshu Goyal on 12/19/19.
//
#include <stack>
#include <iostream>
using namespace std;
class MyStack{
private:
    stack<int> st;
    int minEle;
public:
    void push(int n){
        if(st.empty()){
            st.push(n);
            minEle = n;
        }else{
            if(n < minEle){
                st.push(2*n - minEle);
                minEle = n;
            }else{
                st.push(n);
            }
        }

    }
    int getMin(){
        if(st.empty())
            return -1;
        cout << minEle << endl;
        return minEle;
    }
    void pop(){
        if(!st.empty()){
            int t = st.top();
            st.pop();
            if(t < minEle){
                minEle = 2*minEle - t;
            }
        }
    }
    void peek()
    {
        if (st.empty())
        {
            cout << "Stack is empty ";
            return;
        }

        int t = st.top(); // Top element.

        cout << "Top Most Element is: ";

        // If t < minEle means minEle stores
        // value of t.
        (t < minEle)? cout << minEle: cout << t;
    }

};


int main(){
    MyStack s;
    s.push(3);
    s.push(5);
    s.getMin();
    s.push(2);
    s.push(1);
    s.getMin();
    s.pop();
    s.getMin();
    s.pop();
    s.peek();
    return 0;

}

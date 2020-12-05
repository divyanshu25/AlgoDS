//
// Created by Divyanshu Goyal on 12/19/19.
//
#include <iostream>
#include <stack>
using namespace std;

stack<int> sortStack(stack<int> input){
    stack<int> tmp;
    while(!input.empty()){
        int t = input.top();
        input.pop();
        while(!tmp.empty() && tmp.top() > t){
            input.push(tmp.top());
            tmp.pop();
        }
        tmp.push(t);
    }
    return tmp;
}

int main()
{
    stack<int> input;
    input.push(34);
    input.push(3);
    input.push(31);
    input.push(98);
    input.push(92);
    input.push(23);

    // This is the temporary stack
    stack<int> tmpStack = sortStack(input);
    cout << "Sorted numbers are:\n";

    while (!tmpStack.empty())
    {
        cout << tmpStack.top()<< " ";
        tmpStack.pop();
    }
}


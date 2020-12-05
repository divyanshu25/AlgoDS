//
// Created by Divyanshu Goyal on 1/14/20.
//
#include <iostream>
using namespace std;
class A{
public:
    A(){
        cout << "In A" << endl;
    }
};

class B: public A{
public:
    B():A(){
        cout << "In B " << endl;
    }
};

class C: public B{
public:
    C():B(){
        cout << "In C" << endl;
    }
};
int main(){
    C c;
    return 0;
}

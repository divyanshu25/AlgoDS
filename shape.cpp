//
// Created by Divyanshu Goyal on 1/14/20.
//
#include <iostream>
using  namespace std;

class shape{
protected:
    int h;
    int l;
public:
    shape(int l, int h){
        this-> l = l;
        this -> h = h;
    }
    virtual int getArea(){
        cout << "parent class area" << endl;
        return 0;
    }
    virtual void printName() = 0;
};

class Rectangle: public shape{
public:
    Rectangle(int l, int h):shape(l ,h){ // calling base class constructor

    }
    int getArea(){
        cout << "Rectangle class Area" << endl;
        return this->h * this->l;
    }
    void printName(){
        cout << "Rectangle " << endl;
    }
};

class Triangle: public shape{
public:
    Triangle(int l, int h):shape(l ,h){ // calling base class constructor

    }
    int getArea(){
        cout << "Triangle class Area" << endl;
        return  this->h * this->l * (0.5);
    }
    void printName(){
        cout << "Triangle" << endl;
    }
};

int main(){
    Rectangle r1(10, 10);
    Rectangle r2(20,20);
    Triangle t1(10,10);
    Rectangle *rp;
    shape *sp;
//    rp = &r1;
//    cout << rp->getArea() << endl;

    sp = &r1;
    cout << sp->getArea() << endl;
    sp->printName();

    sp = &t1;
    cout << sp->getArea() << endl;
    sp->printName();

//    rp = &r2;
//    cout << rp->getArea() << endl;


    return 0;
}

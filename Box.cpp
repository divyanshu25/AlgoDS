//
// Created by Divyanshu Goyal on 1/11/20.
//
#include <iostream>
using namespace std;

class Box;
class Items{
private:
    string name;
public:
    Items(string n= "empty"){
        this -> name = n;
    }
    void printBoxDim(Box b);
};


class Box{
private:
    int length;
    int breadth;
    int height;
public:
    static int numObjects;
    Box(int length, int breadth, int height){
        this -> length = length;
        this -> breadth = breadth;
        this -> height = height;
        numObjects++;
    }
    int getVolume();
    friend void printWidth(Box b);
    static int getCount(){
        return numObjects;
    }
    friend void Items::printBoxDim(Box b);

    Box operator+(const Box &b){
        Box bnew(this->length + b.length,this->breadth + b.breadth, this->height + b.height );
        return bnew;
    }
};

void Items::printBoxDim(Box b){
    cout << b.length << " " << b.breadth << " " << b.height << endl;
}

int Box::numObjects = 0;

int Box::getVolume() {
    return length * breadth * height;
}
void printWidth(Box b){
    cout << "Width: "<<b.breadth << endl;
}
int main(){
    cout << Box::getCount() << endl;
    Box b(1,2,3);
    cout << b.getVolume() << endl;
    cout << Box::getCount() << endl;
    printWidth(b);
    Items item("socks");
    item.printBoxDim(b);

    Box b1(1,1,1);
    Box b2(2,2,2);
    Box b3 = b1 + b2;
    item.printBoxDim(b3);

    return 0;
}


//
// Created by Divyanshu Goyal on 8/19/20.
//

#include<iostream>
#include<string>
#include<vector>
using namespace std;


bool all(vector<bool> &result){
    for(auto it: result) {
        if (!it)
            return false;
    }
    return true;
}
bool getPrize(vector<vector<string> > &codeList, vector<string> cart){
    int n = cart.size();
    int m = codeList.size();

    if(m == 0)
        return true;
    if(n == 0)
        return false;
    vector<bool> result(m , false);

    int index = 0;
    for(int i = 0; i < m && index < n; i++){
        int j = 0;
        for(; j < codeList[i].size() && index < n;){
            if(cart[index] == codeList[i][j] || codeList[i][j] == "anything"){
                j++;
            }else{
                j=0;
            }
            index++;
        }
        if( j == codeList[i].size()){
            result[i] = true;
        }
    }

    if(all(result))
        return true;
    return false;

}
int main(){
    vector<vector<string> >codeList = {{"orange"}, {"apple", "apple"}, {"banana", "orange", "apple"}, {"banana"}};
//            {{"apple", "apple"}, {"banana", "anything", "banana"}};


    vector<string> shoppingCart = {"orange", "apple", "apple", "banana", "orange", "apple", "banana"};
//            {"orange", "apple", "apple", "banana", "orange", "banana"};

    cout << getPrize(codeList, shoppingCart) << endl;
    return 0;
}


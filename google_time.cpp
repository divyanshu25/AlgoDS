//
// Created by Divyanshu Goyal on 11/15/19.
//
#include <string>
#include <vector>
#include <iostream>
#include <sstream>
using namespace std;

vector<string> getTokens(string s){
    vector<string> tokens;
    stringstream token_stream(s);
    string holder;
    while(getline(token_stream, holder, ':')){
        tokens.push_back(holder);
    }
    return tokens;
}
int main(){
    string s= "??:??";
    vector<string> tokens = getTokens(s);
    cout << tokens[0] << " " << tokens[1] << endl;
    string hh = tokens[0];
    string mm = tokens[1];
    if(hh[0] == '?' && hh[1] == '?'){
        hh[0] = '2';
        hh[1] = '3';
    }else if(hh[0] == '?' && hh[1] != '?'){
        if(hh[1] >= '4'){
            hh[0] = '1';
        }else{
            hh[0] = '2';
        }
    }else if(hh[0] != '?' && hh[1] == '?'){
        if(hh[0] == '2'){
            hh[1] = '3';
        }else{
            hh[1] = '9';
        }
    }

    if(mm[0] == '?' && mm[1] == '?'){
        mm[0] = '5';
        mm[1] = '9';
    }else if(mm[0] == '?' && mm[1] != '?'){
        mm[0] = '5';
    }else if(mm[0] != '?' && mm[1] == '?'){
        mm[1] = '9';
    }
    cout << hh[0]<<hh[1]<<":"<<mm[0]<<mm[1]<<endl;
    return 0;
}
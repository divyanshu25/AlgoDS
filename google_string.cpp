ssg//
// Created by Divyanshu Goyal on 11/15/19.
//
#include <iostream>
#include <vector>
#include <string>
#include <sstream>
using namespace std;

vector<string> getTokens(string A){
    /*  Logic for tokenization in C++*/
    vector<string> tokens;
    stringstream token_stream(A);
    string holder;
    while(getline(token_stream, holder, ','))

        tokens.push_back(holder);
    }
    return tokens;
}

vector<int> getFreq(vector<string> tokens){
    vector<int> freq;
    for(int i = 0; i < tokens.size(); i++){
        string s = tokens[i];
        sort(s.begin(), s.end());
        int f = 0;
        char c = s[0];
        while(s[f] == c){
            f++;
        }
        freq.push_back(f);
    }
    return freq;
}
void print_vector(vector<int> v){
    for(auto it = v.begin(); it != v.end() ; it++){
        cout << *it << " ";
    }
    cout << endl;
}
void print_string_vector(vector<string> v){
    for(auto it = v.begin(); it != v.end() ; it++){
        cout << *it << " ";
    }
    cout << endl;
}
vector<int> func(string A, string B) {
    vector<int> ans;
    vector<string> tokensA= getTokens(A);
    vector<string> tokensB = getTokens(B);
    vector<int> freqA = getFreq(tokensA);
    vector<int> freqB = getFreq(tokensB);
    sort(freqA.begin(), freqA.end());
    for(int i = 0; i < freqB.size(); i++){
        int num = 0;
        while(num < freqA.size() && freqB[i] > freqA[num]){
            num++;
        }
        ans.push_back(num);
    }
    return ans;
}

int main(){

    string A = "abcd,aabc,bd";
    string B = "aaaa,aa";
    vector<int> ans  = func(A,B);
    print_vector(ans);
    return 0;
}


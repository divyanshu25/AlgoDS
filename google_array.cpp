//
// Created by Divyanshu Goyal on 11/15/19.
//
#include <iostream>
#include <vector>
using namespace std;

bool compare(vector<int>ans , vector<int> tmp){
    if(ans.size() == 0)
        return true;
    for(int i = 0; i < ans.size(); i++){
        if(ans[i] != tmp[i]){
            if(ans[i] < tmp[i])
                return true;
            else
                return false;
        }
    }
    return false;
}
vector<int> func(int* A, int N, int k){
    vector<int> ans;
    for(int i = 0 ; i < N-k +1; i++){
        vector<int> tmp;
        for(int j = i; j < i + k ; j++){
            tmp.push_back(A[j]);
        }
        if(compare(ans,tmp)){
            ans = tmp;
        }
    }
    return ans;
}
int main(){
    int A[] = {1,1,1,1,1,1,1,1,1};
    int k =4;
    vector<int> ans = func(A,9,k);
    for(int i =0 ; i < ans.size(); i++){
        cout << ans[i] << " ";
    }
    cout << endl;
    return 0;

}


//
// Created by Divyanshu Goyal on 1/15/20.
//
//[2, 3, 5, 7, 1] K = 3


#include <iostream>
#include <vector>
using namespace std;


int helper(vector<int> &arr, int n, int k, int sum){
    cout << n << " " << k << " " << sum << endl;
    if(k == 0)
        return sum;
    if(n < 0)
        return sum;
    return max(helper(arr, n-1, k, sum) , helper(arr, n-1, k-1, sum+arr[n] ) );

}
int main(){
    vector<int> arr;
    arr.push_back(2);
    arr.push_back(3);
    arr.push_back(5);
    arr.push_back(7);
    arr.push_back(1);
    int k = 3;
    int n = arr.size();
    cout <<  helper(arr, n-1, k, 0) << endl;
    return 0;



}


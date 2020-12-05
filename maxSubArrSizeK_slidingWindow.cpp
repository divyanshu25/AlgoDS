#include <iostream>
#include <cmath>
#include <climits>
#include <map>
using namespace std;

map<int, int> mp;

void printKMax(int arr[], int n, int k){
    int max = INT_MIN;
    // base case
    for(int i = 0 ; i < k ; i++){
        if(mp.find(arr[i]) == mp.end()){
            mp[arr[i]] = 1;
        }else{
            mp[arr[i]]++;
        }
        if(arr[i] > max){
            max = arr[i];
        }
    }
    cout << max << " ";
    for(int i = 1; i < n-k +1 ; i++){
        mp[arr[i-1]]--;
        mp[arr[i+k-1]]++;

    }  
}

int main()  
{  
    int arr[] = { 3, 3, 2, 2, 5, 6, 7, 8, 9, 10 };  
    int n = sizeof(arr) / sizeof(arr[0]);  
    int k = 3;  
    printKMax(arr, n, k);  
    return 0;  
} 
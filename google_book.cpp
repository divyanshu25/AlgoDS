//
// Created by Divyanshu Goyal on 11/15/19.
//
#include <string>
#include <vector>
#include <iostream>
#include <map>
using namespace std;

int main(){
    string arr[]= {"+1A", "+3E", "-1A", "+4F", "+1A", "-3E", "+3E", "-3E", "+3E"};
    map<string, int>mp;
    string ans = "";
    int mx = 0;
    for(int i = 0;i < sizeof(arr)/sizeof(arr[0]); i++){
        if(arr[i][0] == '+') {
            if (mp.find(arr[i]) == mp.end()) {
                mp[arr[i]] = 1;
            } else {
                mp[arr[i]] += 1;
            }
            if (mp[arr[i]] > mx) {
                mx = mp[arr[i]];
                ans = arr[i];
            } else if (mp[arr[i]] == mx) {
                //cout << ans << " " << arr[i] << "--" << endl;
                if (ans.compare(arr[i]) > 0) {
                    ans = arr[i];
                }
            }
        }
    }
    cout << ans.substr(1,2) << endl;
    return 0;
}

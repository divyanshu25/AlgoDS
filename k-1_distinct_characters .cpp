#include <iostream>
#include <map>
#include <unordered_map>
#include <list>
#include <vector>
#include <string>
using namespace std;


void add(vector<string> &ans, list<char> &lst){
    string tmp = "";
    for(auto it: lst){
        tmp += it;
    }
    ans.push_back(tmp);
}
vector<string> helper(string s, int k){
    vector<string> ans;
    if(s.length() < k)
        return ans;
    unordered_map<char, int> mp;

    list<char> tmp;

    for(int i = 0; i < s.length(); i++){
//        cout << tmp.size() << endl;
        if(tmp.size() < k){
            tmp.push_back(s[i]);
            mp[s[i]]++;
        }else{
            if(mp.size() == k-1){
                add(ans, tmp);
            }
            char c = tmp.front();
            tmp.pop_front();
            tmp.push_back(s[i]);
            mp[c]--;
            mp[s[i]]++;
            if(mp[c] == 0){
                mp.erase(c);
            }
        }
    }
    if(mp.size() == k-1){
        add(ans, tmp);
    }

    return ans;
}
int main() {
    // your code goes here
    string S = "awadw";
    int k = 4;
    vector<string> ans;
    ans = helper(S, k);
    for(auto it: ans)
        cout << it << endl;

    return 0;
}
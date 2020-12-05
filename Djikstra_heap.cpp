class Solution {
public:
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>> > hp;

    int getMin(vector<bool> &spt, int N){
        int index = -1;
        int mn = INT_MAX;
        while(true && !hp.empty()){
            pair<int, int> curr = hp.top();
            hp.pop();
            if(!spt[curr.second]){
                index = curr.second;
                break;
            }
        }
        return index;
    }
    int networkDelayTime(vector<vector<int>>& times, int N, int K) {
        vector<bool> mst(N+1, false);
        vector<int> dist(N+1, INT_MAX);
        dist[K] = 0;
        hp.push({0,K});
        list<pair<int, int>> adj[N+1];
        for(auto it: times){
            adj[it[0]].push_back({it[1], it[2]});
        }
        int cnt = 0;
        int ans = 0;
        while(cnt!= N){
            int curr = getMin(mst, N);
            if(curr ==-1)
                break;
            mst[curr] = true;
            cnt++;
            ans = max(ans, dist[curr]);
            for(auto it: adj[curr]){
                if(!mst[it.first] && dist[it.first] >  it.second + dist[curr] ){
                    dist[it.first] =  it.second + dist[curr];
                    hp.push({it.second + dist[curr], it.first});
                }
            }
        }
        if(cnt != N)
            return -1;
        return ans;
    }
};
#include <iostream>
using namespace std;

int knapSack(int W, int wt[], int val[], int n){
    int dp[n+1][W+1];
    for(int i = 0; i <= n ; i++){
        for(int w = 0; w <= W ; w++){
            if(i == 0 || w ==0){
                dp[i][w] = 0;
            }
            else if(wt[i-1] <= w ){
                dp[i][w] = max(dp[i-1][w] , val[i-1] + dp[i-1][w - wt[i-1]]);
            }else{
                dp[i][w] = dp[i-1][w];
            }
        }
    }
    // Printing the knapsack //
    int res = dp[n][W];
    int w =W;
    for(int i = n; i >0 && res > 0 ; i--){
        if(res == dp[i-1][w]){
            // the last item was not picked 
            continue;
        }else{
            // was picked
            cout << wt[i-1] << " ";
            w = w - wt[i-1];
            res = res - val[i-1];
        }
    }


    return dp[n][W];
}
int main() 
{ 
    int val[] = {60, 100, 120}; 
    int wt[] = {10, 20, 30}; 
    int  W = 50; 
    int n = sizeof(val)/sizeof(val[0]); 
    cout << knapSack(W, wt, val, n);
    return 0; 
} 
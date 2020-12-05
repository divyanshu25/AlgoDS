#include <iostream>
using namespace std;


int binarySearch(int arr[], int s, int e, int key){
    // base case
    if(s > e){
        return -1;
    }

    int m = s + (e-s)/2;
    if(arr[m] == key) return m;
    if(arr[m] > key)
        return binarySearch(arr, s , m-1, key);
    else
        return binarySearch(arr, m+1, e, key);
}

int findPivot(int arr[], int s, int e){
    if(s > e)
        return -1;
    if(s == e)
        return s;
    int m  = s + (e-s)/2;
    if(arr[m] < arr[m-1] && arr[m] < arr[m+1]){
        return m;
    }
    if(arr[s] >= arr[m])
        return findPivot(arr,s, m-1);
    else
        return findPivot(arr,m+1,e);

}
int pivotedBinarySearch(int arr[], int n , int key){
    int pos = findPivot(arr,0,n-1);
    cout << pos << endl;
    if(pos == -1){
        return binarySearch(arr, 0, n-1, key);
    }else{
        int ans = binarySearch(arr, 0, pos-1, key);
        if(ans != -1){
            return ans;
        }
        else{
            // cout << pos << " " << n-1 << endl;
            return binarySearch(arr, pos, n-1, key); 
        }
    }
    return -1;
}
int main() 
{ 
  // Let us search 3 in below array 
  int arr1[] = {9,10,11,13,16,17,4};
  int n = sizeof(arr1)/sizeof(arr1[0]); 
  int key = 4;
    
  // Function calling 
  cout << "Index of the element is : " <<  
           pivotedBinarySearch(arr1, n, key) << endl;
             
  return 0; 
} 
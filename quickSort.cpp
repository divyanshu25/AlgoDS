#include <iostream>

using namespace std;

void swap(int *a, int *b){
    int t = *a;
    *a = *b;
    *b = t;
}

int partition(int arr[], int s,int e){
    int pivot = arr[e];
    int i = s-1;
    for(int j = s; j < e; j++){
        if(arr[j] < pivot){
            i++;
            swap(&arr[j], &arr[i]);
        }
    }
    swap(&arr[e], &arr[i+1]);
    return i+1;
}

void quickSort(int arr[], int s, int e){
    if(s > e) return;
    int p = partition(arr, s, e);
    quickSort(arr, s, p-1);
    quickSort(arr, p+1, e);
}


/* Function to print an array */
void printArray(int arr[], int size)  
{  
    int i;  
    for (i = 0; i < size; i++)  
        cout << arr[i] << " ";  
    cout << endl;  
}  
  
// Driver Code 
int main()  
{  
    int arr[] = {10, 7, 8, 9, 1, 5};  
    int n = sizeof(arr) / sizeof(arr[0]);  
    quickSort(arr, 0, n - 1);  
    cout << "Sorted array: \n";  
    printArray(arr, n);  
    return 0;  
}  
  
package com.dibu.practice.Array;

public class FindPairInSortedArray {

    // Greedy Algorithm. If sum is less the the required sum then increase the left pointer to go to a bigger number else reduce the
    // right pointer to go to a smaller number.

    // Complexity O(n).
    public boolean pairExists(int[] arr, int sum){
        int l = 0;
        int r = arr.length -1;
        while(l < r){
            if(arr[l]+ arr[r] == sum) {
                return true;
            }else if(arr[l]+ arr[r] < sum){
                l++;
            }else{
                r--;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        FindPairInSortedArray findPairInSortedArray = new FindPairInSortedArray();
        boolean result = findPairInSortedArray.pairExists(arr, 9);
        System.out.println("IsExist: " + result);
    }
}

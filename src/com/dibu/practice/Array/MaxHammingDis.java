package com.dibu.practice.Array;

/**
 * Created by divyanshugoyal on 4/25/19.
 */
public class MaxHammingDis {

    public void rotate(int[] arr){
        //O(n)
        int temp = arr[0];
        for(int i = 1 ; i< arr.length ; i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;
    }

    public int computeHammingDis(int[] arr1, int[] arr2){
        //O(n)
        int n = arr1.length;
        int dis= 0;
        for(int i= 0 ; i< n ; i++){
            if(arr1[i] != arr2[i] ){
                dis++;
            }
        }
        return dis;
    }
    public void printArray(int arr[]){
        for(int i = 0 ; i< arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public void findArray(int[] arr){
        int[] rotatedArr = arr.clone();
        int maxDis = 0;
        int numRot =0;
        for(int i =0 ; i< arr.length-1 ; i++){
            rotate(rotatedArr);
            int dis = computeHammingDis(arr, rotatedArr);
            if(dis >= maxDis){
                maxDis = dis;
                numRot =i+1;
                printArray(rotatedArr);
            }
        }
        System.out.println(maxDis+ " " + numRot);
    }

    public static void main(String[] args){
        int[] arr = {2,4,8,0};
        MaxHammingDis maxHammingDis = new MaxHammingDis();
        maxHammingDis.findArray(arr);
    }
}

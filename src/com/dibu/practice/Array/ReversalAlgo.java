package com.dibu.practice.Array;

public class ReversalAlgo {


    public void reverse(int[] arr, int start, int end){
        if(start < end){
            int temp =  arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
            reverse(arr, start, end);
        }
    }

    public void leftRotate(int[] arr, int d){
        int startA = 0;
        int endA = d-1;
        int startB = d;
        int endB = arr.length-1;
        reverse(arr, startA, endA);
        reverse(arr, startB, endB);
        reverse(arr, 0, arr.length-1);


    }

    public void printArray(int[] arr){
        for(int i =0 ; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        ReversalAlgo reversalAlgo = new ReversalAlgo();
        reversalAlgo.leftRotate(arr, 2);
        reversalAlgo.printArray(arr);
    }
}

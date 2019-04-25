package com.dibu.practice.Array;

/**
 * Created by divyanshugoyal on 4/25/19.
 */
public class MaxSum {
    public int max(int[] arr){
        int max =0;
        int rotation = 0;
        for(int i =0 ; i< arr.length ; i++){
            if(arr[i] > max){
                max = arr[i];
                rotation = i;
            }
        }
        System.out.println("Rotation Number: "+ rotation);
        return max;
    }

    public int findMax(int[] arr){
        int[] rotationValue = new int[arr.length];
        int temp =0;
        int sum=0;
        for(int i = 0; i< arr.length ;i++){
            temp += i*arr[i];
            sum += arr[i];
        }
        rotationValue[0] = temp;
        for(int i = 1 ; i< arr.length ; i++){
            rotationValue[i] = rotationValue[i-1] + sum - arr.length*arr[arr.length - i];
        }
        return max(rotationValue);
    }
    public static void main(String[] args){
        int[] arr = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        MaxSum maxSum = new MaxSum();
        System.out.println(maxSum.findMax(arr));
    }
}

package com.dibu.practice.Array;

import java.util.Arrays;

public class SortArray {

    public static void main(String[] args){
        int[] arr ={3,4,2,7,4,8,9,1};
        Arrays.sort(arr);
        for(int i = 0 ; i< arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
    }
}

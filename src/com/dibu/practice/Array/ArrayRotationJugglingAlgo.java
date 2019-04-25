package com.dibu.practice.Array;

import static com.dibu.practice.Math.MathFunction.gcd;

/**
 * Created by divyanshugoyal on 4/25/19.
 */
public class ArrayRotationJugglingAlgo {

    void leftRotate(int arr[], int d, int n)
    {
        int i, j, k, temp;
        for (i = 0; i < gcd(d, n); i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }


    void printArray(int arr[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }


    public static void main(String[] args)
    {
        ArrayRotationJugglingAlgo rotate = new ArrayRotationJugglingAlgo();
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        rotate.leftRotate(arr, 2, 7);
        rotate.printArray(arr, 7);
    }
}




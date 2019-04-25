package com.dibu.practice.Array;

public class SortedRotatedArrayFind {

    public int findPivot(int[] arr, int start, int end){
        // Base Cases
        if(start == end){ return start; }
        if(start > end){ return -1; }

        int mid = (start+end)/2;
        if(arr[mid] > arr[mid+1]){ return mid; }
        // Base Case End

        if(arr[mid] < arr[start]){
            return findPivot(arr, start, mid-1);
        }
        return findPivot(arr, mid+1, end);
    }

    public int binarySerach(int[] arr, int e, int start, int end){
        if(start == end){
            if(arr[start] == e){
                return start;
            }
            return -1;
        }
        if(start > end){
            return -1;
        }
        int mid = (start+end)/2;
        if(arr[mid] == e){
            return mid;
        }else if(arr[mid] > e){
            return binarySerach(arr, e, start, mid-1);
        }else{
            return binarySerach(arr, e, mid+1, end);
        }
    }

    public int findElement(int[] arr, int e){
        int pos = findPivot(arr, 0, arr.length-1);
        System.out.println("Pivot: "+ pos);
        int index = -1;
        if(pos == -1){
            return binarySerach(arr, e, 0, arr.length-1);
        }
        else{
            index = binarySerach(arr, e, 0, pos);
            if(index == -1){
                index = binarySerach(arr, e, pos+1, arr.length-1);
            }
        }
        return index;
    }

    public static void main(String[] args){
        int[] arr = {6,7,8,9,10,11,12,13,14,15,1,2,3,4,5};
        SortedRotatedArrayFind sortedRotatedArrayFind = new SortedRotatedArrayFind();
        int index = sortedRotatedArrayFind.findElement(arr,15);
        System.out.println("Index: "+ index);
    }
}

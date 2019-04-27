package com.dibu.practice.Array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by divyanshugoyal on 4/27/19.
 */
public class PairInArray {

    public int binarySearch(Pair[] nums, int r, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start+end)>>1;
        if(nums[mid].x == r) {
            return mid;
        }
        else if(nums[mid].x>r ){
            return binarySearch(nums, r, start, mid-1);
        }
        return binarySearch(nums, r, mid+1, end);
    }

    public class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x =x;
            this.y =y;
        }
    }
    public int[] twoSum(int[] nums, int target) {
        Pair[] arr = new Pair[nums.length];
        for(int i = 0 ; i< nums.length; i++){
            arr[i] = new Pair(nums[i],i);
        }
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2){
                return p1.x - p2.x;
            }

        });
        for(int i=0 ; i< arr.length; i++){
            int r = target - arr[i].x;
            int i2 = binarySearch(arr, r, 0, arr.length-1);
            if(i2 != -1 && (i != i2)){
                return new int[]{arr[i].y, arr[i2].y};
            }
        }

        return new int[]{0,0};
    }
}

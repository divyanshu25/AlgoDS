package com.dibu.practice.Miscellaneous;

/**
 * Created by divyanshugoyal on 5/11/19.
 */
import java.util.*;

class Solution {
    public int check(int p, int[][]people){
        int len = people.length;
        int count  = people[p][1];
        int temp = 0;
        for(int t = 0 ; t < p ; t++){
            if(people[t][0] >= people[p][0]) temp++;
        }
        if(temp == count) return 1;
        return 0;

    }

    public void relocate(int p, int[][] people){
        int len = people.length;
        int data = people[p][0];
        int count  = people[p][1];
        int temp = 0;
        int i;
        for(i = 0 ; i < len ; i++){
            if(people[i][0] >= people[p][0]){
                temp++;
                if(count == temp){
                    break;
                }
            }
        }
        for(int t = p; t > i+1 ; t--){
            int t1 = people[t][0];
            int t2 = people[t][1];
            people[t][0] = people[t-1][0];
            people[t][1] = people[t-1][1];
            people[t-1][0] = t1;
            people[t-1][1] = t2;
        }


    }
    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        for(int i =0; i < len ; i++){
            for(int j = i+1 ; j < len ; j++){
                if(people[i][1] > people[j][1] ||
                        (people[i][1] == people[j][1] && people[i][0] > people[j][0]) ){
                    int temp1 = people[j][0];
                    int temp2 = people[j][1];
                    people[j][0] = people[i][0];
                    people[j][1] = people[i][1];
                    people[i][0] = temp1;
                    people[i][1] = temp2;
                }
            }
        }
        for(int i =0 ; i < len; i++){
            System.out.println(people[i][0] + " "+ people[i][1]);
        }
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i = 0 ; i < len ; i++){
                int c = check(i, people);
                if(c == 0){
                    flag =true;
                    relocate(i, people);
                }
            }
        }
        return people;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,2},{6,1},{5,0}});
    }
}

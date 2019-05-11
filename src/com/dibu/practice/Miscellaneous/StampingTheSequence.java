package com.dibu.practice.Miscellaneous;

import java.util.*;

class StampingTheSequence {

    public boolean isValid(int start, String target, String stamp, int[] wildCard){
        boolean allWild = true;
        for(int i = start, j=0; j < stamp.length() ; j++,i++){
            if(wildCard[i] == 0){
                allWild = false;
            }
        }
        if(allWild) return false;

        boolean ans = true;
        for(int i = start,j=0; j< stamp.length() ;j++){
            if((wildCard[i] == 0 && target.charAt(i) == stamp.charAt(j))|| wildCard[i] == -1){
                i++;
                continue;
            }else{
                ans = false;
                break;
            }
        }
        return ans;
    }
    public int[] movesToStamp(String stamp, String target) {
        int wildCardLeft = target.length();
        Stack<Integer> v = new Stack<Integer>();
        int[] wildCard = new int[target.length()];
        for(int i = 0 ; i < target.length(); i++){
            wildCard[i] = 0;
        }
        boolean valid = true;
        while(wildCardLeft !=0 && valid){
            valid = false;
            for(int  i = 0 ; i <= target.length()-stamp.length(); i++){
                if(isValid(i, target, stamp, wildCard)){
                    valid = true;
                    v.push(i);
                    for(int j = i; j < i+stamp.length(); j++){
                        if(wildCard[j] == 0){
                            wildCard[j] = -1;
                            wildCardLeft--;
                        }
                    }
                    if(wildCardLeft == 0){
                        break;
                    }
                }
            }
        }
        if(wildCardLeft !=0){
            return new int[]{};
        }
        int[] ans = new int[v.size()];
        int i = 0;
        while(!v.empty()){
            ans[i] = v.pop();
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String stamp = "mda";
        String target = "mdadddaaaa";
        StampingTheSequence s = new StampingTheSequence();
        int[] a = s.movesToStamp(stamp, target);
        System.out.println(Arrays.toString(a));
    }
}
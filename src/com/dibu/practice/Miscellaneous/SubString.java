package com.dibu.practice.Miscellaneous;


import java.util.ArrayList;
import java.util.Arrays;

public class SubString {

    public int isSubstring(String s1, String s2){
        return -1;
    }

    //    public void computeLPS(String s2, int[] lps){
//        int n = s2.length();
//        lps[0] = 0;
//
//        for(int i = 1; i < n ; i++){
//            int len = lps[i-1];
//            if(len == 0){
//                if(s2.charAt(i) == s2.charAt(0)){
//                    lps[i] = 1;
//                }
//            }else{
//                if(s2.charAt(i) == s2.charAt(len)){
//                    lps[i] = lps[i-1]+1;
//                }
//            }
//        }
//    }
    void computeLPSArray(String pat, int M, int lps[]) {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                } else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
    public static void main(String[] args) {
        String s1 = "AABAABAABAABC";
        String s2 = "AABC";
//        int[] lps = new int[s2.length()];
//        SubString s = new SubString();
//        s.computeLPSArray(s2,s2.length(), lps);
        System.out.println(s1.indexOf(s2));
    }
}

package com.dibu.practice.Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by divyanshugoyal on 4/27/19.
 */
public class LongestDistinctSubString {
    // SLiding WIndow Solution
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<Character>();

        int ws = 0;
        int start = 0;
        int maxLen = 1;
        for (int i = 0; i < len; i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                ws++;
                if (ws > maxLen) {
                    maxLen = ws;
                }
            } else {
                while (set.contains(s.charAt(i))) {
                    set.remove(s.charAt(start));
                    start++;
                    ws--;
                }
                set.add(s.charAt(i));
                ws++;
                if (ws > maxLen) {
                    maxLen = ws;
                }
            }
        }
        return maxLen;
    }
}

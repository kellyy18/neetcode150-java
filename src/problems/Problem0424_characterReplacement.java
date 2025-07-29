package problems;

import java.util.HashMap;

public class Problem0424_characterReplacement {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int res = 0;
        

        // rememember this sliding window pattern; initialize l at 0 and r is the loop
        int l = 0, maxf = 0;

        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1); // instantiating counts map; common approach
            maxf = Math.max(maxf, count.get(s.charAt(r)));
            // The maximum substring of one character involves finding the most commonly occurring
            // character in the sliding window, then doing replacements in that window. Here we are finding the max frequency for
            // sliding window. Note that we don't need to update it for every window; only if the max frequency increases since 
            // that is the only way to increase the longest repeating character replacement
            while ((r - l + 1) - maxf > k) {
                // We take the current window length - the most frequently occurring character. 
                // THis is the number of replacements that we can do. If this number of replacements is greater than k, 
                // it means that the window is invalid, so we need to slide the window forward by moving l
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1); // decrement the count of the leftmost character
                l++; // increment the left pointer
            }

            res = Math.max(res, r - l + 1); // self-explanatory
        }
        return res;
    }

    public static void main(String[] args) {
        Problem0424_characterReplacement solution = new Problem0424_characterReplacement();

        // Test case 1: s = "XYYX", k = 2
        String s1 = "XYYX";
        int k1 = 2;
        int result1 = solution.characterReplacement(s1, k1);
        System.out.println("Test 1: " + result1); // Expected: 4

        // Test case 2: s = "AABABBA", k = 1
        String s2 = "AAABABB";
        int k2 = 1;
        int result2 = solution.characterReplacement(s2, k2);
        System.out.println("Test 2: " + result2); // Expected: 5
    }
}

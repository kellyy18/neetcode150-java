package problems;

import java.util.HashSet;

public class Problem0003_longestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            // We keep adding to the right side of the window until... we get a duplicate
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l)); // now our window has a duplicate, so move the left side of the window until we get back to valid window (no duplicates)
                l++;
            }
            charSet.add(s.charAt(r)); // add the character to the set; it's in our window
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem0003_longestSubstring solution = new Problem0003_longestSubstring();

        // Test case 1: s = "zxyzxyz"
        String s1 = "zxyzxyz";
        int result1 = solution.lengthOfLongestSubstring(s1);
        System.out.println("Test 1: " + result1); // Expected: 3

        // Test case 2: s = "xxxx"
        String s2 = "xxxx";
        int result2 = solution.lengthOfLongestSubstring(s2);
        System.out.println("Test 2: " + result2); // Expected: 1
    }
}

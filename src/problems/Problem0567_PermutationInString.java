package problems;

public class Problem0567_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false; // s1 cannot be a permutation of s2 if it's longer
        }

        int[] s1Count = new int[26]; // Count of characters in s1
        int[] s2Count = new int[26]; // Count of characters in the current window of s2

        // Initialize the counts for s1 and the first window of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++; // this is a pretty common pattern to update an array of the letters of the alphabet in a string char count
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0; // Count of matched characters (should have same frequency for all characters to be permutation)
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++; // If the count of a character matches in both strings, increment matches
            }
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) {
                return true; // All characters match, so s1 is a permutation of the current window in s2
            }

            // Add the next char to the sliding window
            int index = s2.charAt(r) - 'a';
            s2Count[index]--; // Update count with new char added
            if (s2Count[index] == s1Count[index]) {
                matches++; // If the count matches, increment matches
            } else if (s1Count[index] - 1 == s2Count[index]) {
                matches--; // If the count no longer matches, decrement matches
            }
            l++; // Remove the left most char (need to slide the window forward)
        }
        return matches == 26;
    }

    public static void main(String[] args) {
        Problem0567_PermutationInString solution = new Problem0567_PermutationInString();

        // Test case 1: s1 = "abc", s2 = "lecabee"
        String s1 = "abc";
        String s2 = "lecabee";
        boolean result1 = solution.checkInclusion(s1, s2);
        System.out.println("Test 1: " + result1); // Expected: true

        // Test Case 2: s1 = "abc", s2 = "lecaabee"
        String s3 = "abc";
        String s4 = "lecaabee";
        boolean result2 = solution.checkInclusion(s3, s4);
        System.out.println("Test 2: " + result2); // Expected: false
    }
}

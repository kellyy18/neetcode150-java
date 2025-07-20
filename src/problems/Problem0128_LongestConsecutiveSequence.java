package problems;

import java.util.HashSet;
import java.util.Set;

public class Problem0128_LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            // Add all nums in array to the set
            numSet.add(num);
        }

        int longest = 0;
        for (int num : numSet) {
            // What is the start of a sequence? If we define it as starting at a value n... it's when the set doesn't contain n - 1 !
            if (!numSet.contains(num - 1)) {
                int length = 1;
                // While loop until the sequence ends to track sequence and its length; TLDR; use hashset because of fast contains lookup
                while (numSet.contains(num + length)) {
                    length++;
                }
                // Compare curr length to curr longest length
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int longestSequence = longestConsecutive(nums); // 4
        System.out.println(longestSequence);

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        longestSequence = longestConsecutive(nums2);
        System.out.println(longestSequence); // 9

        int[] nums3 = {1, 0, 1, 2};
        longestSequence = longestConsecutive(nums3);
        System.out.println(longestSequence);
    }
}

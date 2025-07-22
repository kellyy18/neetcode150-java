package problems;

import java.util.Arrays;

public class Problem0066_PlusOne {
    public int[] plusOne(int[] digits) {
        /* Algorithm:
         * When we add one to a digit, there are TWO cases
         * Case 1:
         * If the digit is less than 9, we add 1 to it.
         * Case 2:
         * If the digit is 9, we CARRY the digit over to the next integer and set the current digit to 0.
        */
        int n = digits.length;

        // I think the way this for loop and the succeeding code is structured is a bit 
        // strange and counterintuitive; I"d probably end up implementing it a different way
        // because it's not easy to see how everything carries necessarily; the logic is stil
        // fairly straightforward though.
        for (int i = n - 1; i >= 0; i--) {
            // When the digit is less than 9, we will add the one here and have a simple case where it returns.
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // Otherwise, if the digit isn't 9, we set this digit to 0; the beauty is that
            // it's being carried since if this digit isn't returned, the loop will move on to 
            // the next digit and increment that.
            digits[i] = 0;
        }
        // The only way we would reach this statement is if the number if all 9's and it keeps carrying 
        // throughout the number after we've run out of digits. Thus, the new number will be a 1 and all 0's 
        // and it will be 1 digit longer than the preceding number so we initialize an array with a size of n + 1
        // and set the first position to 1.
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;

        // TLDR; the logic is pretty simple just consider the edge cases
    }

    public static void main(String[] args) {
        Problem0066_PlusOne sol = new Problem0066_PlusOne(); // Create an instance of the Solution class

        // LeetCode Test Case 1
        System.out.println("--- LeetCode Test Case 1 ---");
        int[] nums1 = {1, 2, 3};
        System.out.println("Input: " + Arrays.toString(nums1));
        int[] result1 = sol.plusOne(nums1);
        System.out.println("Output: " + Arrays.toString(result1)); // Expected: [1, 2, 4]
        System.out.println("----------------------------\n");

        // LeetCode Test Case 2
        System.out.println("--- LeetCode Test Case 2 ---");
        int[] nums2 = {4, 3, 2, 1};
        System.out.println("Input: " + Arrays.toString(nums2));
        int[] result2 = sol.plusOne(nums2);
        System.out.println("Output: " + Arrays.toString(result2)); // Expected: [4, 3, 2, 2]
        System.out.println("----------------------------\n");

        // LeetCode Test Case 3 (Edge Case: All 9s)
        System.out.println("--- LeetCode Test Case 3 (All 9s) ---");
        int[] nums3 = {9};
        System.out.println("Input: " + Arrays.toString(nums3));
        int[] result3 = sol.plusOne(nums3);
        System.out.println("Output: " + Arrays.toString(result3)); // Expected: [1, 0]
        System.out.println("----------------------------\n");
    }
}

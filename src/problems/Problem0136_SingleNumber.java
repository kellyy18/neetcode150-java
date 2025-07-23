package problems;

import java.util.Arrays;

public class Problem0136_SingleNumber {
    /* Approach: Bitwise XOR
     * I feel like this is basically the same problem as 268 missing number. Just take advantage of the property that a number xorred
     * with itself gives 0 and thus since we have every integer appear twice except one we can just xorr all the integers together
     * which will give 0 for all the integers. Then, when we xorr 0 with the number that appears once, we will get that number, 
     * which is the desired result. Not much more to be said.
     */
    public int singleNumber(int[] nums) {
        int res = 0; // only thing to keep in mind is to initialize res to 0 not 1
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem0136_SingleNumber solution = new Problem0136_SingleNumber();

        // --- LeetCode Test Case 1 ---
        int[] nums1 = {2, 2, 1};
        int expected1 = 1;
        int result1 = solution.singleNumber(nums1);
        System.out.println("Test Case 1: ");
        System.out.println("Input:    " + Arrays.toString(nums1));
        System.out.println("Output:   " + result1);
        System.out.println("Expected: " + expected1);
        System.out.println("Result:   " + (result1 == expected1 ? "Correct" : "Incorrect"));
        System.out.println("-".repeat(20));


        // --- LeetCode Test Case 2 ---
        int[] nums2 = {4, 1, 2, 1, 2};
        int expected2 = 4;
        int result2 = solution.singleNumber(nums2);
        System.out.println("Test Case 2: ");
        System.out.println("Input:    " + Arrays.toString(nums2));
        System.out.println("Output:   " + result2);
        System.out.println("Expected: " + expected2);
        System.out.println("Result:   " + (result2 == expected2 ? "Correct" : "Incorrect"));
        System.out.println("-".repeat(20));


        // --- LeetCode Test Case 3 ---
        int[] nums3 = {1};
        int expected3 = 1;
        int result3 = solution.singleNumber(nums3);
        System.out.println("Test Case 3: ");
        System.out.println("Input:    " + Arrays.toString(nums3));
        System.out.println("Output:   " + result3);
        System.out.println("Expected: " + expected3);
        System.out.println("Result:   " + (result3 == expected3 ? "Correct" : "Incorrect"));
        System.out.println("-".repeat(20));
    }
}

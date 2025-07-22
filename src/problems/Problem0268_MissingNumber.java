package problems;

import java.util.Arrays;

public class Problem0268_MissingNumber {
    /* Bitwise XOR */
    // Makes use of binary properties
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xorr = n;
        for (int i = 0; i < n; i++) {
            // What we're doing essentially is xorring 0, 1, ... n with each of the n integers in the range 0 to n
            // For the one missing number, this will be the index i which doesn't have any nums[i] of the same value to xorr with.
            // We make use of an interesting binary property, which is that a number xor'd with itself gives us 0. Thus, 
            // when we xorr everything together, everything will be 0 for the numbers that show up twice (once as an index) 
            // and once as an array. Thus, the only thing will be left is the one number that showed up once (the number that
            // isn't a value in the array) and any number xorr 0 will give that number, so by xorring all these numbers together we get 
            // the one number that is missing from the array.
            xorr ^= i ^ nums[i];
        }
        return xorr;
    }

    /* Math */
    // This is actually even easier than the bitwise XOR and is also O(1) memory. We sum the range
    // of indexes and subtract the input array, which leaves us the missing number (which isn't in the range we are subtracting)
    public int missingNumber2(int[] nums) {
        // Structured this way such to
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res += i - nums[i];
        }
        return res;
    }

    // NOTE: Pertaining to both approaches. They both loop from 0 to nums.length to ensure the 
    // array elements are able to be accessed but then they account for the fact that the range is only
    // from 0 to n - 1 (since it needs to be 0 to n in both problem solving methodologies) by 
    // setting res and xorr to n or nums.length respectively. Something to keep in mind.

    /* Hash Set */
    // Pretty easy, straightforward approach; same time complexity but takes extra memory
    // Identify when you need to use hashing though
    // public int missingNumber2(int[] nums) {
    //     Set<Integer> numSet = new HashSet<>();
    //     for (int num : nums) {
    //         numSet.add(num);
    //     }
    //     int n = nums.length;
    //     for (int i = 0; i <= n; i++) {
    //         if (!numSet.contains(i)) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    public static void main(String[] args) {
        Problem0268_MissingNumber solver = new Problem0268_MissingNumber(); // Create an instance of the class

        // LeetCode Test Case 1: nums = [3,0,1], n = 3. Range [0,1,2,3]. Missing 2.
        System.out.println("--- LeetCode Test Case 1 ---");
        int[] nums1 = {3, 0, 1};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Missing (XOR method): " + solver.missingNumber(nums1)); // Expected: 2
        System.out.println("Missing (Math method): " + solver.missingNumber2(nums1)); // Expected: 2
        System.out.println("----------------------------\n");

        // LeetCode Test Case 2: nums = [0,1], n = 2. Range [0,1,2]. Missing 2.
        System.out.println("--- LeetCode Test Case 2 ---");
        int[] nums2 = {0, 1};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Missing (XOR method): " + solver.missingNumber(nums2)); // Expected: 2
        System.out.println("Missing (Math method): " + solver.missingNumber2(nums2)); // Expected: 2
        System.out.println("----------------------------\n");

        // LeetCode Test Case 3: nums = [9,6,4,2,3,5,7,0,1], n = 9. Range [0-9]. Missing 8.
        System.out.println("--- LeetCode Test Case 3 ---");
        int[] nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Missing (XOR method): " + solver.missingNumber(nums3)); // Expected: 8
        System.out.println("Missing (Math method): " + solver.missingNumber2(nums3)); // Expected: 8
        System.out.println("----------------------------\n");
    }
}

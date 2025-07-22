package problems;

import java.util.Arrays;

public class Problem0238_ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;

        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Problem0238_ProductExceptSelf solution = new Problem0238_ProductExceptSelf();

        System.out.println("--- LeetCode Test Case 1 ---");
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Input: " + Arrays.toString(nums1));
        int[] result1 = solution.productExceptSelf(nums1);
        System.out.println("Output: " + Arrays.toString(result1)); // Expected: [24, 12, 8, 6]
        System.out.println("----------------------------\n");

        System.out.println("--- LeetCode Test Case 2 ---");
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("Input: " + Arrays.toString(nums2));
        int[] result2 = solution.productExceptSelf(nums2);
        System.out.println("Output: " + Arrays.toString(result2)); // Expected: [0, 0, 9, 0, 0]
        System.out.println("----------------------------\n");
    }
}

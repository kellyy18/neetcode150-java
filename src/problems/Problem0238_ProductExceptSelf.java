package problems;

import java.util.Arrays;

public class Problem0238_ProductExceptSelf {
    /* The algorithm:
     * How od we get the product of every element except the one at that index?
     * we do two passes, first we multiply up all of the elements coming before our given element in a forward pass
     * then we multiply all the elements after our given element in a next pass from the end to the start.
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // For the result array, it will always have prefix of 1 for the first element; since there's no elements before so we just want to multiply by 1
        res[0] = 1;

        // To get the prefix for every element after the first, we multiply by the prefix in the previous slot, which effectively because of the way it's
        // set up gives us every element until the immediately preceding element, so then we multiply by the n - 1th element. Pretty simple I'd say.
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // Mkae sure to set the suffix to 1.
        int suffix = 1;

        // Here we iterate directly using res[i] and no i - 1 stuff unlike the prefix. Again, just draw it out and it'll make sense (draw out res and nums)
        for (int i = n - 1; i >= 0; i--) {
            // res[i] currently contains prefix. To get product except self we do prefix * suffix
            res[i] *= suffix;
            // Now we need to update the suffix for the next element
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

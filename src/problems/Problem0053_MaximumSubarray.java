package problems;

public class Problem0053_MaximumSubarray {
    /* Kadane's Algorithm */
    public static int maxSubArray(int[] nums) {
        // Just need a reference poimt for maxSum; some people set this to like negative infinity
        int maxSum = nums[0]; 
        int currSum = 0;

        for (int num : nums) {
            // Don't want to add currSum if it's negative. Why? 
            // currSum effectively represents the sum of the preceding elements. 
            // If it's positive, it's possible currSum could go down a bit but there could be a massive element after the current element
            // that increases the sum in the end. If currSum is negative, then I would just start the maximum sum at the current element and not 
            // add currSum to it. Then, we just track maxSum and see which of the maxSums we get ends up being biggest.
            currSum = Math.max(currSum, 0);
            currSum += num;
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSubArray = maxSubArray(nums); // 6
        System.out.println(maxSubArray);
        
        int[] nums2 = {1};
        maxSubArray = maxSubArray(nums2); // 1
        System.out.println(maxSubArray);

        int[] nums3 = {5, 4, -1, 7, 8};
        maxSubArray = maxSubArray(nums3); // 23
        System.out.println(maxSubArray);
    }
}

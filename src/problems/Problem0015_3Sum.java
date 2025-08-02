package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem0015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // need sorted array for our two pointer algorithm

        for (int i = 0; i < nums.length; i++) {
            // skip duplicates 
            if (i > 0 && nums[i] == nums[i -1]) {
                continue;
            }

            // note we need to start at i + 1 because we'er doing 3 numbers with i being the current one so we start from the next
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                // Typical two pointer; two sum II
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++; // Advance search forward
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                        // Ensures we don't select duplicates. We could do this with r instead of l; just need to do one because
                        // only one value r will make the l equal to 0 when added to curr element so by ensuring no duplicate l is 
                        // selected we ensure no duplicate r is selected due to our two pointer and vice versa if we did it with r.
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem0015_3Sum solver = new Problem0015_3Sum();
        System.out.println("--- LeetCode Test Case 1 ---");
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input nums: " + Arrays.toString(nums1));
        List<List<Integer>> result1 = solver.threeSum(nums1);
        System.out.println("Output: " + result1); // Expected: [[-1, -1, 2], [-1, 0, 1]]
        System.out.println("------------------------------\n");

        System.out.println("--- LeetCode Test Case 2 ---");
        int[] nums2 = {0, 0, 0};
        System.out.println("Input nums: " + Arrays.toString(nums2));
        List<List<Integer>> result2 = solver.threeSum(nums2);
        System.out.println("Output: " + result2); // Expected: [[0, 0, 0]]
        
        System.out.println("------------------------------\n");
        System.out.println("--- LeetCode Test Case 3 ---");
        int[] nums3 = {1, 2, -2, -1};
        System.out.println("Input nums: " + Arrays.toString(nums3));
        List<List<Integer>> result3 = solver.threeSum(nums3);
        System.out.println("Output: " + result3); // Expected: []
    }
}

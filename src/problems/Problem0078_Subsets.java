package problems;

import java.util.*;

public class Problem0078_Subsets {
    /* Backtracking */
    // There is an iterative approach but I think backtracking is a pretty straightforward and the best so it is the only one I will include
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, res);
        return res;
    }

    private static void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        // Once you've iterated past the array it's time to return whatever subset you just calculated
        if (i >= nums.length) {
            // Trickiest part of the code once you've seen the backtracking pattern before. Make a COPY of the arraylist.
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(nums, i + 1, subset, res); // Explore the subset with the i-th element included
        subset.remove(subset.size() - 1); // Make sure you know this is the element to remove (the last one in the list, aka the most recently added)
        dfs(nums, i + 1, subset, res); // Explore the subset that doesn't include this i-th element
    }

    // I think this algorithm is pretty simple to code up if you've seen the backtracking pattern and really makes sense once you've seen and understood
    // subsets before as a choice on each element of the set as to whether to include it or exclude it; hence why there's 2^n subsets for a subset with n elements

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets); // [[1, 2, 3], [1, 2], [1, 3], [1], [2], [3], []]

        int[] nums2 = {7};
        subsets = subsets(nums2);
        System.out.println(subsets); // [[7], []]
    }
}

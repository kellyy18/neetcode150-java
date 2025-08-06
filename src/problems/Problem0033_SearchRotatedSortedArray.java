package problems;

public class Problem0033_SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            }

            // Determine which side m is in
            // Note that target is strictly less htan bounds since we know it's not equal to target
            // but this shouldn't change the behavior I think
            if (nums[l] <= nums[m]) { // m is in left sorted portion
                if (nums[l] <= target && target < nums[m]) { // I think this is better than how I was doing it; check if it's in the bounds not if it's outside of it
                    r = m - 1; // Target is in the left sorted part
                } else {
                    l = m + 1; // Target is in the right part
                }
            } else { // m is in right sorted portion
                if (nums[m] < target && target <= nums[r]) { 
                    l = m + 1; // Target is in the right sorted part
                } else {
                    r = m - 1; // Target is in the left part
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem0033_SearchRotatedSortedArray solution = new Problem0033_SearchRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = solution.search(nums, target);
        System.out.println("Index of target " + target + ": " + result); // Output: Index of target 0: 4
        target = 3;
        result = solution.search(nums, target);
        System.out.println("Index of target " + target + ": " + result); // Output: Index of target 3: -1
        target = 5;
        result = solution.search(nums, target);
        System.out.println("Index of target " + target + ": " + result); // Output: Index of target 5: 1
        target = 6;
        result = solution.search(nums, target);
        System.out.println("Index of target " + target + ": " + result); // Output: Index of target 6: 2
        target = 7;
        result = solution.search(nums, target);
        System.out.println("Index of target " + target + ": " + result); // Output: Index of target 7: 3
    }
}

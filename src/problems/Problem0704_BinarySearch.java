package problems;

public class Problem0704_BinarySearch {
    /*
     * Overall, there's not too much to say. It's binary search. We all know what it is. Implementation is the only thing to really even think about.
     */
    /* Recursive Approach */
    public static int search(int[] nums, int target) {
        return search(0, nums.length - 1, nums, target);
    }

    private static int search(int l, int r, int[] nums, int target) {
        if (l > r) {
            return -1;
        }

        int m = l + (r - l) / 2;

        if (nums[m] == target) {
            return m;
        }

        /* This part wasn't the most intuitive for me but it makes sense. To check the lower half
         * your next interval is the same left bound with the right bound being the old mid point - 1
         * and to check the upper half you have the same right bound but the left bound is the old mid point + 1
         */
        if (nums[m] < target) {
            return search(m + 1, r, nums, target);
        } else {
            return search(l, m - 1, nums, target);
        }
    }
    // The only note of interest: the purpose of doing l + (r - l) / 2 instead of (l + r) / 2 is avoiding integer overflow problems.

    /* Iterative Binary Search*/
    // public int search(int[] nums, int target) {
    //     int l = 0; 
    //     int r = nums.length - 1;

    //     while (l <= r) {
    //         int m = l + (r - l) / 2;
    //         if (nums[m] > target) {
    //             r = m - 1;
    //         } else if (nums[m] < target) {
    //             l = m + 1;
    //         } else {
    //             return m;
    //         }
    //     }
    //     return -1;
    // }

    // Functionally same as recursive approach. Choice has no tradeoff just personal preference.

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int result = search(nums, 9);
        System.out.println(result); // 4

        int result2 = search(nums, 2);
        System.out.println(result2); // -1
    }
}

package problems;

public class Problem0153_FindMinRotatedArray {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int res = nums[0]; // dummy value; doesn't matter what it is

        while (l <= r) {
            if (nums[l] < nums[r]) { // we are in a sorted subarray 
                res = Math.min(res, nums[l]); //minimum of sorted subarray is l or current global min
                break;
            }

            int m = (l + r) / 2;
            res = Math.min(res, nums[m]); // update global minimum
            
            // middle is in left sorted portion, maximum of left sorted group... so we want to check the right portion
            // because rotation by definition puts bigger elements in front (left portion)
            if (nums[m] >= nums[l]) { 
                l = m + 1; // move to the right sorted half
            } else {
                r = m - 1; // if we're in the right sorted portion, we want to search left (because we already
                // have found the minimum of the right sorted portion in nums[m]), so check left to see if there's 
                // any smaller values
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem0153_FindMinRotatedArray solution = new Problem0153_FindMinRotatedArray();
        int[] nums = {3, 4, 5, 6, 1, 2};
        
        int result = solution.findMin(nums);
        System.out.println("Minimum in rotated sorted array: " + result); // Output: Minimum in rotated sorted array: 1
        
        int[] nums2 = {4, 5, 0, 1, 2, 3};
        result = solution.findMin(nums2);
        System.out.println("Minimum in rotated sorted array: " + result); // Output: Minimum in rotated sorted array: 0

        int[] nums3 = {4, 5, 6, 7};
        result = solution.findMin(nums3);
        System.out.println("Minimum in rotated sorted array: " + result); // Output: Minimum in rotated sorted array: 4
    }
}

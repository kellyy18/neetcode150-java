package problems;

public class Problem0167_TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        // Two pointers approach
        int left = 0;
        int right = numbers.length - 1;

        // reminds me of binary search; pretty common pattern in two pointer problems to improve speed over hashset
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1}; // Return 1-based indices
            } else if (sum < target) { // we want to increase the sum... so we move the left pointer up
                left++;
            } else { // we want to decrease the sum... so we move the right pointer down
                right--;
            }
        }
        // Dummy return. Should never get here since we are told the condition will be satisfied.
        return new int[] { };
    }
    /* Overall, I'd say this is a fairly intuitive problem; and follows pretty typical two pointer patterns without too much thinking required */

    public static void main(String[] args) {
        Problem0167_TwoSumII solution = new Problem0167_TwoSumII();
        
        // Test case 1: numbers = [2,7,11,15], target = 9
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(numbers1, target1);
        System.out.println("Test 1: [" + result1[0] + "," + result1[1] + "] Expected: [1,2]");
        // Note: The expected output is 1-based index, so [1,2] means the first and second elements sum to the target.

        // Test case 2: numbers = [2,3,4], target = 6
        int[] numbers2 = {2, 3, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(numbers2, target2);
        System.out.println("Test 2: [" + result2[0] + "," + result2[1] + "] Expected: [1,3]");

        // Test case 3: numbers = [-1,0], target = -1
        int[] numbers3 = {-1, 0};
        int target3 = -1;
        int[] result3 = solution.twoSum(numbers3, target3);
        System.out.println("Test 3: [" + result3[0] + "," + result3[1] + "] Expected: [1,2]");
    }
}

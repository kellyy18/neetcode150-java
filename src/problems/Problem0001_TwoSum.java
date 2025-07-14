package problems;

import java.util.*;

public class Problem0001_TwoSum {
    /* Brute Force Approach */
    // public static int[] twoSum(int[] nums, int target) {
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = i + 1; j < nums.length; j++) {
    //             if (nums[i] + nums[j] == target) {
    //                 return new int[]{i, j};
    //             }
    //         }
    //     }
    //     return new int[]{};
    // }

    /* Hash Map */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i]; 
            int remainder = target - num;

            if (prevMap.containsKey(remainder)) {
                return new int[]{prevMap.get(remainder), i};
            }
            prevMap.put(num, i);
        }
        return new int[] { };
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println();
        System.out.println(Arrays.toString(result));  // [0, 1]
    }
}

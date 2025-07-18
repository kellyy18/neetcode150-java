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
            // Current element access
            int num = nums[i]; 

            // Remainder if we take the current element
            int remainder = target - num;

            // If the remainder is in the map of previous elements, return 
            if (prevMap.containsKey(remainder)) {
                // This gives us our array with the indice pair
                return new int[]{prevMap.get(remainder), i};
            }
            // Keep going, store this element in the map of previous elements. If there's one later that satisfies the condition
            // it will get triggered when that element tries to add the prevMap and finds this element
            prevMap.put(num, i);
        }
        // Dummy return. Should never get here since we are told the condition will be satisfied.
        return new int[] { };
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println();
        System.out.println(Arrays.toString(result));  // [0, 1]
    }
}

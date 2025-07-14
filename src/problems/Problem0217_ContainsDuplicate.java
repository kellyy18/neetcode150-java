package problems;

import java.util.*;

public class Problem0217_ContainsDuplicate {
    /* Brute Force */
    // public boolean containsDuplicate(int[] nums) {
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = i + 1; j < nums.length; j++) {
    //             if (nums[i] == nums[j]) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    // We are checking every element against every other element to see if there's a duplicate. How can we speed that up?

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        boolean result = containsDuplicate(new int[]{1, 2, 3, 1});
        System.out.println();
        System.out.println(result);  // true

        boolean result2 = containsDuplicate(new int[]{1, 2, 3, 4});
        System.out.println();
        System.out.println(result2); // false
    }
}

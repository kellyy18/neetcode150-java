package problems;

import java.util.Arrays;

public class Problem0011_ContainerMostWater {
    /* Approach: Brute Force
     * I feel once you get the logic and are able to make the brute force version, it lends itself 
     * to being able to implement the two pointer version.
     */
    // public int maxArea(int[] heights) {
    //     int res = 0;
    //     for (int i = 0; i < heights.length; i++) {
    //         for (int j = i + 1; j < heights.length; j++) {
    //             res = Math.max(res, Math.min(heights[i], heights[j]) * (j - i));
    //         }
    //     }
    //     return res;
    // }

    /* Approach: Two Pointer */
    public int maxArea(int[] heights) {
        // maximizing area; make sure to initialize one at very left and one at very right
        int l = 0;
        int r = heights.length - 1;
        int res = 0;

        while (l < r) {
            // this is how we calculate current area of container
            int area = Math.min(heights[l], heights[r]) * (r - l); // The 'height' of the container is bounded by the smaller value between l and r; width is just r - l
            res = Math.max(res, area); // update the max area accordingly
            // Trickiest part, if the height is being bounded by the left, move that up; Otherwise, if it's being bounded by the right then move that in.
            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem0011_ContainerMostWater solver = new Problem0011_ContainerMostWater();

        System.out.println("--- LeetCode Test Case 1 ---");
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Input height: " + Arrays.toString(height1));
        int result1 = solver.maxArea(height1);
        System.out.println("Output: " + result1); // Expected: 49
        System.out.println("------------------------------\n");

        System.out.println("--- LeetCode Test Case 2 ---");
        int[] height2 = {1, 1};
        System.out.println("Input height: " + Arrays.toString(height2));
        int result2 = solver.maxArea(height2);
        System.out.println("Output: " + result2); // Expected: 1
        System.out.println("------------------------------\n");
    }
}

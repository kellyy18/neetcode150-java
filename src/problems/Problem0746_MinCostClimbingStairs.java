package problems;

import java.util.Arrays;

public class Problem0746_MinCostClimbingStairs {
    /*
     * Algorithm: Dynamic Programming (Bottom-Up, In-Place)
     *
     * The goal is to find the minimum cost to reach the top of the staircase. The "top" can be thought of as one step
     * beyond the last element of the `cost` array. You can start at either index 0 or index 1.
     *
     * The key insight is to work backward from the top. The cost to get to the top from a given step `i` is the cost
     * of the step itself (`cost[i]`) plus the minimum cost to proceed from there. From step `i`, you can either go to
     * step `i+1` or `i+2`. So, the minimum cost from step `i` is `cost[i] + min(cost[i+1], cost[i+2])`.
     *
     * We can use the input `cost` array itself to store these calculated minimum costs, saving space. We iterate
     * from the end of the array towards the beginning, updating each `cost[i]` with the total minimum cost to reach
     * the top starting from that step.
     */
    public int minCostClimbingStairs(int[] cost) {
        // We start from cost.length - 3 because the costs for the last two steps (cost.length - 1 and cost.length - 2)
        // are already their own minimum cost to reach the top, as you can jump directly from them.
        // We iterate backward, calculating the minimum cost from each step.
        for (int i = cost.length - 3; i >= 0; i--) {
            // Update cost[i] to be the cost of this step plus the minimum cost of the next one or two steps.
            // After this line, cost[i] no longer represents the original cost, but the minimum total cost
            // to reach the top *from* step i.
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }

        // After the loop, cost[0] and cost[1] hold the total minimum cost to reach the top starting from
        // index 0 and index 1, respectively.
        // Since we can start at either step 0 or step 1, we simply return the minimum of these two values.
        return Math.min(cost[0], cost[1]);
    }

    /**
     * Main method to drive the program and test the minCostClimbingStairs function.
     */
    public static void main(String[] args) {
        Problem0746_MinCostClimbingStairs solver = new Problem0746_MinCostClimbingStairs();

        System.out.println("--- LeetCode Test Case 1 ---");
        int[] cost1 = {10, 15, 20};
        System.out.println("Input cost: " + Arrays.toString(cost1));
        // We pass a copy because the method modifies the array in-place.
        int result1 = solver.minCostClimbingStairs(cost1.clone());
        System.out.println("Output: " + result1); // Expected: 15
        System.out.println("Explanation: Start at index 1 (cost 15) and jump to the top.");
        System.out.println("------------------------------\n");

        System.out.println("--- LeetCode Test Case 2 ---");
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("Input cost: " + Arrays.toString(cost2));
        int result2 = solver.minCostClimbingStairs(cost2.clone());
        System.out.println("Output: " + result2); // Expected: 6
        System.out.println("Explanation: Start at index 0, take all the 1s, and skip the 100s.");
        System.out.println("------------------------------\n");
    }
}

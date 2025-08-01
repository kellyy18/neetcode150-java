package problems;

import java.util.Stack;

public class Problem0739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            // While the stack is not empty and the current temperature is greater than the temperature at the index stored at the top of the stack
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                int index = pair[1];
                res[index] = i - index; // Calcluate the difference in indices between the current index and the index stored in the stack
            }
            stack.push(new int[]{t, i}); // Push the current temperature and its index onto the stack
        }
        return res;
    }

    public static void main(String[] args) {
        Problem0739_DailyTemperatures solver = new Problem0739_DailyTemperatures();

        System.out.println("--- LeetCode Test Case 1 ---");
        int[] temperatures1 = {30, 38, 30, 36, 35, 40, 28};
        System.out.println("Input temperatures: " + java.util.Arrays.toString(temperatures1));
        int[] result1 = solver.dailyTemperatures(temperatures1);
        System.out.println("Output: " + java.util.Arrays.toString(result1)); // Expected: [1, 4, 1, 2, 1, 0, 0]
        System.out.println("------------------------------\n");

        System.out.println("--- LeetCode Test Case 2 ---");
        int[] temperatures2 = {22, 21, 20};
        System.out.println("Input temperatures: " + java.util.Arrays.toString(temperatures2));
        int[] result2 = solver.dailyTemperatures(temperatures2);
        System.out.println("Output: " + java.util.Arrays.toString(result2)); // Expected: [0, 0, 0]
    }
}

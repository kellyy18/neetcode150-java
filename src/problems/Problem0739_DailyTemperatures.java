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
}

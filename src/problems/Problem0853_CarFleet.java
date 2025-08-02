package problems;
import java.util.Arrays;
import java.util.Stack;

public class Problem0853_CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        // just moving the data into a single array of tuples
        int[][] pair = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        
        // Sort by position in descending order
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        
        for (int[] p : pair) {
            // Approach: They're just linear equations with position as y and speed as slope.
            // We calculate the time to reach the target for each car.
            // If the car starting with later initial position reaches the target in less or equal time,
            // it means that it must join the previous car fleet.
            stack.push((double)(target - p[0]) / p[1]);
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop(); // Pop the current car (since it will just be part of the previous car fleet)
            }
            // See how we keep the car if it's not part of the previous fleet.
        }
        
        return stack.size(); // The size of the stack is the number of car fleets
    }

    public static void main(String[] args) {
        Problem0853_CarFleet solution = new Problem0853_CarFleet();
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        
        int result = solution.carFleet(target, position, speed);
        System.out.println("Number of car fleets: " + result); // Output: Number of car fleets: 3
    }
}

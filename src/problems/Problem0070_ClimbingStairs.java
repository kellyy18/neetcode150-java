package problems;

public class Problem0070_ClimbingStairs {
    public static int climbStairs(int n) {
        // Top step one way to get there; 2nd top step one way to get there (1 step away from the top step)
        int one = 1, two = 1;
        
        // Interestingly, although it's looking like it's going forward linearly...
        // It's actually a backwards-moving bottom-up approach
        for (int i = 0; i < n - 1; i++) { // keep in mind these for loop conditions; not easy to come up with; I think it's because we have the top and second to top step which leaves 0th to n - 2 step which is n - 1 iterations.
            // Store the value of more upper
            int temp = one;
            // Step after the two preceding it is the value of the two ways to get to the one before it
            one = one + two;
            // Store the value of bottom step in next step above
            two = temp;
        }
        
        // TLDR it ends up fibonacci in a way. Last step is gonna end up with us at one reaching the first step.
        return one;
    }

    public static void main(String[] args) {
        int steps = climbStairs(2); // 2
        System.out.println(steps);

        steps = climbStairs(3); // 3
        System.out.println(steps);
    }
}

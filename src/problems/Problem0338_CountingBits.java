package problems;

import java.util.Arrays;

public class Problem0338_CountingBits {
    /*
     * A simple approach but slower than the ideal solution
     */
    public int[] countBits(int n) {
        // cuz range is 0 to n
        int[] res = new int[n + 1];
        // 
        for (int i = 1; i <= n; i++) {
            int num = i; 
            while (num > 0) {
                res[i]++;
                num = num & (num - 1); // this line removes rightmost bit from num
                // Alternative: This is a more explicit approach that I probably would have taken
                /*
                 * if ((num & 1) == 1) {
                 *  res[i]++;
                 * }
                 * num = num >> 1;
                 */
            }
        }
        return res;
    }

    /* DP Approach: 
     * 0 -> 0000
     * 1 -> 0001
     * 2 -> 0010
     * 3 -> 0011 -> 1 + dp[2] -> 1 + [3 - offset (2)]
     * 4 -> 0100
     * 5 -> 0101 -> 1 + dp[1] -> 1 + [5 - offset (4)]
     * 6 -> 0110 -> 1 + dp[2] -> 1 + [6 - offset (4)]
     * 7 -> 0111 -> 1 + dp[3] -> 1 + [7 - offset (4)]
     * 8 -> 1000
     * As we can see, the offset is the most significant bit a multiple of 2; and all we have to do is add 1 for the offset bit and then check the number of 1 bits
     * from what's remaining, which is a dynamic progarmming problem as this we have already calculated in the result of number - offset
    */
    public int[] countBits2(int n) {
        int offset = 1;
        // keep in mind that dp has n + 1 length; range of 0 to n
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) {
            // basically offset is a power of 2, we keep it at whatever power of 2 we're on
            if (offset * 2 == i) {
                offset = i;
            }
            // whatever offset we're on, we can derive any number within that offset from previous results (starts with the only previous result we're using that we've calculated is 0 but it will keep expanding obviously)
            dp[i] = 1 + dp[i - offset];
        }
        return dp;
    }

    public static void main(String[] args) {
        Problem0338_CountingBits solver = new Problem0338_CountingBits();

        // LeetCode Test Case 1
        System.out.println("--- LeetCode Test Case 1 ---");
        int n1 = 2;
        System.out.println("Input n = " + n1);
        System.out.println("countBits (Simple): " + Arrays.toString(solver.countBits(n1))); // Expected: [0, 1, 1]
        System.out.println("countBits2 (DP):    " + Arrays.toString(solver.countBits2(n1))); // Expected: [0, 1, 1]
        System.out.println("----------------------------\n");

        // LeetCode Test Case 2
        System.out.println("--- LeetCode Test Case 2 ---");
        int n2 = 5;
        System.out.println("Input n = " + n2);
        System.out.println("countBits (Simple): " + Arrays.toString(solver.countBits(n2))); // Expected: [0, 1, 1, 2, 1, 2]
        System.out.println("countBits2 (DP):    " + Arrays.toString(solver.countBits2(n2))); // Expected: [0, 1, 1, 2, 1, 2]
        System.out.println("----------------------------\n");
    }
}

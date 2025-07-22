package problems;

public class Problem0202_HappyNumber {
    /* Approach:
     * We want to check if this is a non-cyclical number or not. We replace numbers with the sum of squares of its digits and continue UNTIL
     * the number is 1 or it loops infinitely in a cycle... as we can see this is a pretty easy, straightforward application of Floyd's cycle
     * detection algorithm using a fast and slow pointer. The slight twist is that when they are both equal to each other, it will eventually
     * occur either with a cycle or not. If there is a cycle, they will both b equal at some point but the cycle doesn't include 1, so their 
     * value won't be 1. If they're equal at some point by both stopping at 1 at some point, it will be indeed a non-cyclical number. Thus, after 
     * exiting the loop we check if fast == 1 and don't return something inside the loop which is slightly unusually; but overall pretty straightforward
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = sumOfSquares(n);
        
        while (slow != fast) {
            fast = sumOfSquares(fast);
            fast = sumOfSquares(fast);
            slow = sumOfSquares(slow);
        }

        return fast == 1;
    }

    /*
     * Pretty straightforward code; sum up the squares of each digit in the number
     */
    private int sumOfSquares(int n) {
        int output = 0;
        while (n != 0) {
            output += (n % 10) * (n % 10);
            n /= 10;
        }
        return output;
    }

    public static void main(String[] args) {
        Problem0202_HappyNumber solver = new Problem0202_HappyNumber();

        System.out.println("--- LeetCode Test Case 1 (Happy Number) ---");
        int n1 = 19;
        System.out.println("Input: n = " + n1);
        boolean isHappy1 = solver.isHappy(n1);
        System.out.println("isHappy:   " + isHappy1); // Expected: true
        System.out.println("-----------------------------------------\n");

        System.out.println("--- LeetCode Test Case 2 (Unhappy Number) ---");
        int n2 = 2;
        System.out.println("Input: n = " + n2);
        boolean isHappy2 = solver.isHappy(n2);
        System.out.println("isHappy (HashSet): " + isHappy2); // Expected: false
    }
}

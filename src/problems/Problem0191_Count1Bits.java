package problems;

public class Problem0191_Count1Bits {
    /*
     * Really a pretty easy and straightforward problem
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            // This is the most explicit way to do this
            count += n % 2;
            n = n >> 1;

            // Optimal: Replace the above with...
            // n &= n - 1;
            // count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Problem0191_Count1Bits solver = new Problem0191_Count1Bits();

        // LeetCode Example Test Case 1: n = 11 (binary 0...01011)
        System.out.println("--- LeetCode Test Case 1 ---");
        int n1 = 11; // Binary 00000000000000000000000000001011
        System.out.println("Input n = " + n1 + " (binary representation: " + Integer.toBinaryString(n1) + ")");
        int result1 = solver.hammingWeight(n1);
        System.out.println("Number of set bits: " + result1); // Expected: 3
        System.out.println("----------------------------\n");

        // LeetCode Example Test Case 2: n = 128 (binary 0...10000000)
        System.out.println("--- LeetCode Test Case 2 ---");
        int n2 = 128; // Binary 00000000000000000000000010000000
        System.out.println("Input n = " + n2 + " (binary representation: " + Integer.toBinaryString(n2) + ")");
        int result2 = solver.hammingWeight(n2);
        System.out.println("Number of set bits: " + result2); // Expected: 1
        System.out.println("----------------------------\n");

        // LeetCode Example Test Case 3: n = -3 (binary 1111...1101, treated as unsigned)
        System.out.println("--- LeetCode Test Case 3 ---");
        int n3 = -3; // Binary 11111111111111111111111111111101 (unsigned)
        System.out.println("Input n = " + n3 + " (unsigned binary representation: " + Integer.toUnsignedString(n3, 2) + ")");
        int result3 = solver.hammingWeight(n3);
        System.out.println("Number of set bits: " + result3); // Expected: 31
        System.out.println("----------------------------\n");
    }
}

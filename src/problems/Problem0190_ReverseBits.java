package problems;

public class Problem0190_ReverseBits {

    /**
     * Reverses the bits of a 32-bit integer.
     *
     * <h3>Algorithm Explanation:</h3>
     * <p>
     * The goal is to take an integer `n` and produce a new integer where the bits are in the opposite order.
     * For example, if bit 0 of `n` is 1, bit 31 of the result should be 1. If bit 31 of `n` is 0, bit 0
     * of the result should be 0.
     * </p>
     * <p>
     * We can achieve this by iterating through each of the 32 bits of the input integer `n`, from right to left (from bit 0 to bit 31).
     * In each step of the loop, we do two things:
     * </p>
     * <ol>
     * <li><b>Extract a single bit from `n`</b>: We isolate the i-th bit of `n`.
     * For example, to get bit 0, we look at the rightmost bit. To get bit 5, we look at the 5th bit from the right.</li>
     * <li><b>Place that bit into its reversed position in our result variable `res`</b>: If we extracted bit `i` from `n`, we need
     * to place it at position `31 - i` in `res`. For instance, bit 0 from `n` goes to position 31 in `res`, bit 1 from `n`
     * goes to position 30 in `res`, and so on.</li>
     * </ol>
     * <p>
     * We build the final result bit by bit over 32 iterations.
     * </p>
     *
     * @param n The 32-bit integer to reverse. Note: Java's `int` is signed, but this problem treats the input as an unsigned 32-bit value.
     * @return The integer with its bits reversed.
     */
    public int reverseBits(int n) {
        // 'res' will store the reversed bits. We start with 0 and build it up.
        int res = 0;

        // We loop 32 times because an integer has 32 bits.
        // 'i' represents the position of the bit we are currently extracting from 'n' (from the right, 0-indexed).
        for (int i = 0; i < 32; i++) {
            // --- Step 1: Extract the i-th bit from n ---
            // 'n >> i' shifts the bits of 'n' to the right by 'i' positions.
            // This moves the bit we care about (the i-th bit) to the rightmost position (bit 0).
            // For example, if n = ...10110 and i = 2, (n >> 2) results in ...00101.
            // '& 1' performs a bitwise AND with 1. This isolates the rightmost bit.
            // The result is 1 if the rightmost bit is 1, and 0 otherwise.
            int bit = (n >> i) & 1;

            // --- Step 2: Place the extracted bit into the correct position in 'res' ---
            // We need to place 'bit' into the (31 - i)-th position of the result.
            // 'bit << (31 - i)' takes our isolated bit (0 or 1) and shifts it left.
            // If i=0 (rightmost bit of n), we shift left by 31, moving it to the leftmost position for 'res'.
            // If i=31 (leftmost bit of n), we shift left by 0, keeping it at the rightmost position for 'res'.
            // '|' (bitwise OR) sets the bit in 'res' at that position. Since 'res' starts as all zeros,
            // this is like "painting" the bit onto the correct spot in our result canvas.
            res = res | (bit << (31 - i));
        }

        return res;
    }

    /**
     * Main method to drive the program and test the reverseBits function with examples.
     */
    public static void main(String[] args) {
        Problem0190_ReverseBits solution = new Problem0190_ReverseBits();

        // --- Test Case 1 (from LeetCode) ---
        int n1 = 43261596;
        // Helper to format binary strings to 32 bits with leading zeros
        String originalBinary1 = String.format("%32s", Integer.toBinaryString(n1)).replace(' ', '0');
        System.out.println("--- Test Case 1 ---");
        System.out.println("Original Decimal: " + n1);
        System.out.println("Original Binary:  " + originalBinary1);

        int reversed1 = solution.reverseBits(n1);
        String reversedBinary1 = String.format("%32s", Integer.toBinaryString(reversed1)).replace(' ', '0');
        System.out.println("Reversed Decimal: " + reversed1);
        System.out.println("Reversed Binary:  " + reversedBinary1);
        System.out.println("Expected Decimal: 964176192\n");


        // --- Test Case 2 (from LeetCode, involves negative number interpretation) ---
        // The input is treated as an unsigned integer. In Java, this value corresponds to -3.
        int n2 = -3; // Corresponds to unsigned 4294967293
        String originalBinary2 = String.format("%32s", Integer.toBinaryString(n2)).replace(' ', '0');
        System.out.println("--- Test Case 2 ---");
        System.out.println("Original Decimal: " + n2 + " (unsigned: 4294967293)");
        System.out.println("Original Binary:  " + originalBinary2);

        int reversed2 = solution.reverseBits(n2);
        String reversedBinary2 = String.format("%32s", Integer.toBinaryString(reversed2)).replace(' ', '0');
        System.out.println("Reversed Decimal: " + reversed2 + " (unsigned: " + Integer.toUnsignedString(reversed2) + ")");
        System.out.println("Reversed Binary:  " + reversedBinary2);
        System.out.println("Expected Decimal: 3221225471\n");
        
        // --- Test Case 3 (Simple case) ---
        int n3 = 1; // Binary is ...0001
        String originalBinary3 = String.format("%32s", Integer.toBinaryString(n3)).replace(' ', '0');
        System.out.println("--- Test Case 3 ---");
        System.out.println("Original Decimal: " + n3);
        System.out.println("Original Binary:  " + originalBinary3);

        int reversed3 = solution.reverseBits(n3);
        String reversedBinary3 = String.format("%32s", Integer.toBinaryString(reversed3)).replace(' ', '0');
        // The result is 1 shifted left by 31, which is the minimum integer value.
        System.out.println("Reversed Decimal: " + reversed3);
        System.out.println("Reversed Binary:  " + reversedBinary3);
        System.out.println("Expected Decimal: -2147483648 (Integer.MIN_VALUE)\n");
    }
}

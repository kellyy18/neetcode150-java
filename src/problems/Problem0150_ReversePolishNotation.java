package problems;

import java.util.Stack;

public class Problem0150_ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        /* Pretty straightforward once you think to use a stack
         * The only thing to keep in mind is order of operations
         * It doesn't matter for addition and multiplication because of commutativity, 
         * but for subtraction and division you need to do b - a. Because of the LIFO 
         * properties of the stack, we want to do second element popped -, / by the first element popped off the stack.
         */
        for (String token : tokens) {
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else if (token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                // Just remember to do parseInt or valueInt to get the integer value from the string
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop(); // The result will be the only element left in the stack
    }

    public static void main(String[] args) {
        Problem0150_ReversePolishNotation solver = new Problem0150_ReversePolishNotation();

        System.out.println("--- LeetCode Test Case 1 ---");
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println("Input tokens: " + String.join(", ", tokens1));
        int result1 = solver.evalRPN(tokens1);
        System.out.println("Output: " + result1); // Expected: 9
        System.out.println("------------------------------\n");

        System.out.println("--- LeetCode Test Case 2 ---");
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("Input tokens: " + String.join(", ", tokens2));
        int result2 = solver.evalRPN(tokens2);
        System.out.println("Output: " + result2); // Expected: 6
        System.out.println("------------------------------\n");

        System.out.println("--- LeetCode Test Case 3 ---");
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "17", "+", "5", "+"};
        System.out.println("Input tokens: " + String.join(", ", tokens3));
        int result3 = solver.evalRPN(tokens3);
        System.out.println("Output: " + result3); // Expected: 22
        System.out.println("------------------------------\n");
    }
}

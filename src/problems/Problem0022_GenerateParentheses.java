package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem0022_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper("", n, n, result);
        return result;
    }

    private void generateParenthesisHelper(String current, int open, int close, List<String> result) {
        if (open == 0 && close == 0) {
            result.add(current);
            return;
        }
        
        if (open > 0) {
            generateParenthesisHelper(current + "(", open - 1, close, result);
        }
        
        if (close > open) {
            generateParenthesisHelper(current + ")", open, close - 1, result);
        }
    }

    public static void main(String[] args) {
        Problem0022_GenerateParentheses solver = new Problem0022_GenerateParentheses();

        System.out.println("--- LeetCode Test Case 1 ---");
        int n1 = 3;
        System.out.println("Input n: " + n1);
        List<String> result1 = solver.generateParenthesis(n1);
        System.out.println("Output: " + result1); // Expected: ["((()))","(()())","(())()","()(())","()()()"]
        System.out.println("------------------------------\n");

        System.out.println("--- LeetCode Test Case 2 ---");
        int n2 = 1;
        System.out.println("Input n: " + n2);
        List<String> result2 = solver.generateParenthesis(n2);
        System.out.println("Output: " + result2); // Expected: ["()"]
        System.out.println("------------------------------\n");
    }
}

package problems;

import java.util.*;

public class Problem0020_ValidParentheses {
    /* Brute Force */
    // public static boolean isValid(String s) {
    //     while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
    //         s=s.replace("()", "");
    //         s=s.replace("{}", "");
    //         s=s.replace("[]", "");
    //     }
    //     return s.isEmpty();
    // }
    // very simple, straightforward solution; get rid of all the pairs. If nothing's left, valid, if something's left (odd number) invalid. 
    // unfortunately, it also has O(n^2) time complexity

    /* Stack (Recursive) */
    public static boolean isValid(String s) {
        if (s == null) {
            return true;
        } else if (s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        return isValid(s, 0, stack);
    }

    private static boolean isValid(String s, int index, Stack<Character> stack) {
        if (index == s.length()) {
            return stack.isEmpty();
        }

        char currentChar = s.charAt(index);
        if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
            stack.push(currentChar);
            return isValid(s, index + 1, stack);
        } else {
            if (stack.isEmpty()) {
                return false;
            }
            char topChar = stack.pop(); 
            if (currentChar == ')' && topChar != '(' || 
                currentChar == '}' && topChar != '{' ||
                currentChar == ']' && topChar != '[') {
                stack.push(currentChar);
                return false;
            }
            return isValid(s, index + 1, stack);
        }
    }
    // Again, logically a simple solution with desired O(n) time complexity. Obviously harder to code, but O(n) makes a big difference over O(n^2)

    public static void main(String[] args) {
        boolean result = isValid("()");
        System.out.println();
        System.out.println(result);  // true

        boolean result2 = isValid("()[]{}");
        System.out.println();
        System.out.println(result2); // true

        boolean result3 = isValid("(]");
        System.out.println();
        System.out.println(result3); // false
    }
}

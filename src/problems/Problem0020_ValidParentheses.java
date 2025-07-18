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

    // Pretend this doesn't exist
    @SuppressWarnings({"BoxedValueEquality", "NumberEquality"})
    
    /* Stack */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        // Using a hashmap is a clever little trick
        Map<Character, Character> closeToOpen = new HashMap<>();
        // Put closing parentheses as keys; Opening parentheses as values.
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        for (char c : s.toCharArray()) {
            // If contains key, we've found a closing parentheses
            if (closeToOpen.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
                    // If stack's empty it means there's NO matching opening. We check IF there is an opening and then we check 
                    // if it's the correct opening using stack.peek 
                    stack.pop();
                    // We pop it off the stack since this pair has now been matched. Don't forget this!!!
                } else {
                    // If either of the above conditions I mentioned were false then the parentheses aren't valid.
                    return false;
                }
            } else { // This means it's not a key, so it must be an opening parentheses; we push it onto the stack to compare to our close
                stack.push(c);
            }
        }
        return stack.isEmpty();
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

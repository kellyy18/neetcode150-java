package problems;

public class Problem00125_ValidPalindrome {
    /* Approach: Reverse the String */
    // public static boolean isPalindrome(String s) {
    //     StringBuilder newStr = new StringBuilder();
    //     for (char c : s.toCharArray()) {
    //         if (Character.isLetterOrDigit(c)) {
    //             newStr.append(Character.toLowerCase(c));
    //         }
    //     }
    //     return newStr.toString().equals(newStr.reverse().toString());
    // }
    // Think this solution is simpler to code up / think of but higher space complexity because of stringBuilder.

    /* Approach 2: Two Pointer */
    public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1; 
        while (l < r) {
            /* Moves past non-alphanumeric characters until we reach one on left and right side */
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }

            while (r > l && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            /* If chars at beginning and end of string (left and right pointer) are not the same, return false */
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            /* Otherwise, keep progressing on both ends */
            l++;
            r--;
        }
        return true;
    }
    // This solution has better space complexity and is also fairly simple / intuitive in terms of the logic though in my opinion slightly harder to code up.
    // Interestingly, this complexity is O(n) despite having a nested loop but that's because of the while loop structure. Loops never restart iteration.

    public static void main(String[] args) {
        boolean result = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println();
        System.out.println(result);  // true

        boolean result2 = isPalindrome("race a car");
        System.out.println();
        System.out.println(result2); // false

        boolean result3 = isPalindrome("");
        System.out.println();
        System.out.println(result3); // true
    }
}

package problems;

import java.util.*;

public class Random {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }

        for (int i = 0; i <= n; i++) {
            if (!seen.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public static String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }

        return res.toString();
    }
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("neet");
        strs.add("code");
        strs.add("love");
        strs.add("you");

        for (String s : strs) {
            System.out.println(s);
        }

        String s = encode(strs);

        System.out.println(s);

        List<String> res = decode(s);
    }
}

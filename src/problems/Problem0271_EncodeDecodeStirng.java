package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem0271_EncodeDecodeStirng {
    public static String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }

        return res.toString();
    }

    public static List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '#') {
                int length = Integer.parseInt(str.substring(j, i));
                j = i + 1;
                i = j + length;
                res.add(str.substring(j, i));
                j = i;
            } else {
                i++;
            }
        }
        return res;
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

        String s = encode(strs); // 4#neet4#code4#love3#you
        System.out.println(s);

        List<String> res = decode(s); // [neet, code, love, you]
        System.out.println(res);
    }
}

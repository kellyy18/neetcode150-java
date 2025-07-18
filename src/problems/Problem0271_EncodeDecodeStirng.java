package problems;

import java.util.ArrayList;
import java.util.List;

public class Problem0271_EncodeDecodeStirng {
    public static String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            // Add the length and a delimiter (#) in front of each word for encoding scheme. 
            // This is set up this way because a word can be any character (including non alphabet and non alphanumeric which is why we need to store length
            // before having the delimiter)
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
                // j still at beginning of length, i reaches delimiter. This is how we extract length
                int length = Integer.parseInt(str.substring(j, i));
                // move j past delimiter to beginning of WORD
                j = i + 1;
                // i was at delimiter, we move it to start of word + length because substring doesn't include the last char
                i = j + length;
                // extract word and add it
                res.add(str.substring(j, i));
                // Now, i is onto the next word at the first character of that (length) so we can't forget to move j to i
                j = i;
            } else {
                // Progress i continuously until reaching a delimiter.
                i++;
            }
        }
        // Return final list of words
        return res;
    }
    /*
     * Not too bad of a problem. The decode is much tricker than encode. I was struggling with forgetting to move j to i. Just draw things out and it will be ok.
     */
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

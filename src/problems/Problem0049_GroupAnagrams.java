package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem0049_GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                // for that char increase value at that index of array tracking frequency of character in each word
                count[c - 'a']++;
            }

            // The array storing the FREQUENCY of characters in a word is an array which we store as a key
            String key = Arrays.toString(count); 

            // If that frequency of characters isn't in the array (NEW ANAGRAM) we just put a new arraylist for that arrangement
            res.putIfAbsent(key, new ArrayList<>());

            // No matter what we add the string to the map, whether it's an existing anagram that's been found or not
            res.get(key).add(s);
        }
        // Return value set because values are the list of group anagram strings and we return a list of those lists
        return new ArrayList<>(res.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> anagrams = groupAnagrams(strs); // [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]

        System.out.println(anagrams);

        String[] strs2 = {""};
        anagrams = groupAnagrams(strs2); // [[""]]
        System.out.println(anagrams);

        String[] strs3 = {"a"};
        anagrams = groupAnagrams(strs3); // [["a"]]
        System.out.println(anagrams);
    }
}

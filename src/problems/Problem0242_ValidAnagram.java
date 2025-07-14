package problems;

import java.util.*;

public class Problem0242_ValidAnagram {
    // Step 1: Define an anagram: The same letters with the same frequency of each letter

    /* Sorting Solution */
    // public static boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) {
    //         return false;
    //     } else {
    //         char[] sChars = s.toCharArray();
    //         char[] tChars = t.toCharArray();
    //         // The key to this sorting approach. Now we can just take a simple for loop and check for validity
    //         Array.sort(sChars); 
    //         Array.sort(tChars);

    //         for (int i = 0; i < sChars.length; i++) {
    //             if (sChars[i] != tChars[i]) {
    //                 return false;
    //             }
    //         }
    //         return true;
    //     }
    //     // Fairly robust, straightforward approach; a bit slow
    // }

    /* Hash Map Solution */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        } else {
            HashMap<Character, Integer> sChars = new HashMap<>();
            HashMap<Character, Integer> tChars = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char sChar = s.charAt(i);
                char tChar = t.charAt(i);
                sChars.put(sChar, sChars.getOrDefault(sChar, 0) + 1); 
                tChars.put(tChar, tChars.getOrDefault(tChar, 0) + 1);
                // getOrDefault is just .get in python. It just says if it's in the map put whatever value is there already (hence the get) + 1 since our character occurred. Otherwise, if it's not there, put 0, then add 1 since now we have 1 occurrence.
            }
            return sChars.equals(tChars);
        }
    }
    // I think this solution aligns perfectly with the definition of an anagram. We store the characters and their occurrences in the hashmap by looping
    // and we check if the two hashmaps are equal which is a faster operation due to hashmap implementation than sorting and looping

    public static void main(String[] args) {
        boolean result = isAnagram("anagram", "nagaram");
        System.out.println();
        System.out.println(result);  // true

        boolean result2 = isAnagram("rat", "car");
        System.out.println();
        System.out.println(result2); // false
    }
}



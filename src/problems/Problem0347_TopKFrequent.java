package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem0347_TopKFrequent {
    /* Algorithm: Bucket Sort
     * Traditional bucket sort is you have an array where the values are the index and the elements at those values are the frequency of said values
     * However, we want to find the top k frequent. We could go into each element and find its count but that would take longer... so instead we flip
     * the paradigm and store the COUNTS as the indexes and the values as lists of integers.
     */
    public int[] topKFrequent(int[] nums, int k) {
        // Map for count of each element
        Map<Integer, Integer> count = new HashMap<>();

        List<Integer>[] freq = new List[nums.length + 1]; // The syntax is a bit strange but it's an array of lists of integers and you have to do it this way or you get an error

        // initialize the values of the array so we don't get null pointer exceptions; kind of like how java zero's out arrays for you
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // Loop through nums and store frequencies in the COUNT map which has numbers as KEYS and frequencies as VALUES (we're going to want to flip
        // this for our bucket sort algorithm)
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // Now here is when we flip
        // First we iterate through each entry in the map which is just a k-v pair
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            // As you can see, we store the VALUE (entry.getValue()) at the INDEX freq[index] and then we take the VALUE at that index
            // (an empty arraylist or maybe an arraylist with values) and we add the KEY (value) to the list. The syntax again is confusing
            // when you're dealing with an array of lists but just think about it and it'll make sense
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k]; 
        int index = 0;
        // Index tracks the number of elements in res; we only want 3 at indexes 0,1,2 so don't forget to add && index < k
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            // Starts from the end since those are higher frequencies; frequencies stored as lists so while that list is non-empty it will
            // add said elements by accessing the arraylist stored at that array element
            for (int n : freq[i]) {
                // Sets current index and increments it
                res[index] = n;
                index++;
                // If we have 4 elements or something in the list, we need to check that we haven't reached 3 elements already and return if we have
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem0347_TopKFrequent solver = new Problem0347_TopKFrequent();

        System.out.println("--- LeetCode Test Case 1 ---");
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        System.out.println("Input nums: " + Arrays.toString(nums1) + ", k = " + k1);
        int[] result1 = solver.topKFrequent(nums1, k1);
        System.out.println("Output: " + Arrays.toString(result1)); // Expected: [1, 2] (order doesn't matter for 1 and 2)
        System.out.println("------------------------------\n");

        System.out.println("--- LeetCode Test Case 2 ---");
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println("Input nums: " + Arrays.toString(nums2) + ", k = " + k2);
        int[] result2 = solver.topKFrequent(nums2, k2);
        System.out.println("Output: " + Arrays.toString(result2)); // Expected: [1]
        System.out.println("------------------------------\n");
    }
}

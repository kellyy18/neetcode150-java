package problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem0703_KthLargest {
    /* Class design problem
     * but it's pretty straightforward. Not too much explanation needed in my mind
     */
    private final PriorityQueue<Integer> minHeap;
    private final int k;

    public Problem0703_KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue();

        for (int num : nums) {
            this.minHeap.offer(num); // Initialize minHeap with initial elements
            if (minHeap.size() > k) { // Only want to keep the 'k' largest elements so we have to restrict size
                minHeap.poll(); // remove smallest elem when size exceeds k
            }
        }
    }

    public int add (int val) {
        // Add value to min-haep
        minHeap.offer(val);
        // If heap size exceeds k then remove the smallest element again
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        // return the smallest (k-th) element in the heap
        return minHeap.peek();
    }
    public static void main(String[] args) {
            System.out.println("--- LeetCode Example Test Case ---");

            // Initialization
            int k1 = 3;
            int[] nums1 = {4, 5, 8, 2};
            System.out.println("Initializing KthLargest with k = " + k1 + ", nums = " + Arrays.toString(nums1));
            Problem0703_KthLargest kthLargest = new Problem0703_KthLargest(k1, nums1);

            // Add operations and print results
            int result;

            result = kthLargest.add(3); // nums = [4, 5, 8, 2, 3] -> k=3 largest are [8, 5, 4] -> 4 is 3rd largest
            System.out.println("add(3): " + result); // Expected: 4

            result = kthLargest.add(5); // nums = [4, 5, 8, 2, 3, 5] -> k=3 largest are [8, 5, 5] -> 5 is 3rd largest
            System.out.println("add(5): " + result); // Expected: 5

            result = kthLargest.add(10); // nums = [4, 5, 8, 2, 3, 5, 10] -> k=3 largest are [10, 8, 5] -> 5 is 3rd largest
            System.out.println("add(10): " + result); // Expected: 5

            result = kthLargest.add(9); // nums = [4, 5, 8, 2, 3, 5, 10, 9] -> k=3 largest are [10, 9, 8] -> 8 is 3rd largest
            System.out.println("add(9): " + result); // Expected: 8

            result = kthLargest.add(4); // nums = [4, 5, 8, 2, 3, 5, 10, 9, 4] -> k=3 largest are [10, 9, 8] -> 8 is 3rd largest
            System.out.println("add(4): " + result); // Expected: 8

            System.out.println("-------------------------------------\n");
    }
}

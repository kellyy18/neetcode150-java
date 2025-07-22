package problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem1046_LastStoneWeight {
    /* Approach: Priority Queue */
    // As long as you understand how to use a priority queue / how a priority queue works, it's pretty straightforward
    // We just need the priority queue because it's suited to this problem and improves efficiency 
    public int lastStoneWeight(int[] stones) {
        // Neetcode doesn't use this approach; they just use a minHeap and turn values into negatives
        // but I think defining an anonymous function to simulate a maxHeap is an easier and more intuitive approach
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add all the stones to the maxHeap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // If there's more than 1 stone remaining, we continue the process
        while (maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            if (x != y) {
                maxHeap.offer(x - y);
            }
        }

        // 'Base cases': 
        // 0 stones left we return 0
        // 1 stone left we return the top
        if (maxHeap.isEmpty()) {
            return 0;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        Problem1046_LastStoneWeight solver = new Problem1046_LastStoneWeight();

        // LeetCode Test Case 1
        System.out.println("--- LeetCode Test Case 1 ---");
        int[] stones1 = {2, 7, 4, 1, 8, 1};
        System.out.println("Input stones: " + Arrays.toString(stones1));
        int result1 = solver.lastStoneWeight(stones1);
        System.out.println("Output: " + result1); // Expected: 1
        System.out.println("------------------------------\n");

        // LeetCode Test Case 2
        System.out.println("--- LeetCode Test Case 2 ---");
        int[] stones2 = {1};
        System.out.println("Input stones: " + Arrays.toString(stones2));
        int result2 = solver.lastStoneWeight(stones2);
        System.out.println("Output: " + result2); // Expected: 1
        System.out.println("------------------------------\n");
    }
}

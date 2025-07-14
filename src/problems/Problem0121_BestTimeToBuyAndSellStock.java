package problems;

public class Problem0121_BestTimeToBuyAndSellStock {
    /* Two Pointers */
    public static int maxProfit(int[] prices) {
        int l = 0, r = 1; 
        int maxP = 0;
        while (r < prices.length) {
            // Profitable transaction
            // Basically check everything above the current left (buy point) and see what the best is
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxP = Math.max(maxP, profit);
            } else { // Update left pointer to right pointer if not profitable transaction; there's something lower to buy at
                l = r;
            }
            r++;
        }
        return maxP;
    }
    // DP is an interesting approach but I do think two pointer is a bit more pragmatic.

    /* Dynamic Programming */
    // public int maxProfit(int[] prices) {
    //     int maxP = 0;
    //     int minBuy = prices[0];

    //     for (int sell : prices) {
    //         maxP = Math.max(maxP, sell - minBuy);
    //         minBuy = Math.min(minBuy, sell);
    //     }
    //     return maxP;
    // }
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int result = maxProfit(prices); // 5
        System.out.println(result);

        int[] prices2 = {7, 6, 4, 3, 1};
        result = maxProfit(prices2); // 0
        System.out.println(result);
    }
}

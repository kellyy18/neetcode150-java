package problems;
import java.util.Arrays;

public class Problem0875_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while (l <= r) {
            int k = (l + r) / 2;
            int hours = 0;

            for (int p : piles) {
                hours += Math.ceil((double) p / k);
            }

            if (hours <= h) {
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem0875_KokoEatingBananas solution = new Problem0875_KokoEatingBananas();
        int[] piles = {3, 6, 7, 11};
        int h = 8;

        int result = solution.minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result); // Output: Minimum eating speed: 4

        int[] piles2 = {30, 11, 23, 4, 20};
        h = 5;
        result = solution.minEatingSpeed(piles2, h);
        System.out.println("Minimum eating speed: " + result); // Output: Minimum eating speed: 30

        int[] piles3 = {30, 11, 23, 4, 20};
        h = 6;
        result = solution.minEatingSpeed(piles3, h);
        System.out.println("Minimum eating speed: " + result); // Output: Minimum eating speed: 23
    }
}

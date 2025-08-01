package problems;

public class Problem0074_Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int top = 0, bot = ROWS - 1;
        
        while (top <= bot) {
            int row = (top + bot) / 2;
            if (target > matrix[row][COLS - 1]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                bot = row - 1;
            } else {
                break;
            }
        }

        if (!(top <= bot)) {
            return false;
        }

        int row = (top + bot) / 2;

        int l = 0, r = COLS - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target < matrix[row][mid]) {
                r = mid - 1;
            } else if (target > matrix[row][mid]) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem0074_Search2DMatrix solver = new Problem0074_Search2DMatrix();

        System.out.println("--- LeetCode Test Case 1 ---");
        int[][] matrix1 = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target1 = 3;
        System.out.println("Input matrix: " + java.util.Arrays.deepToString(matrix1));
        System.out.println("Input target: " + target1);
        boolean result1 = solver.searchMatrix(matrix1, target1);
        System.out.println("Output: " + result1); // Expected: true
        System.out.println("------------------------------\n");

        System.out.println("--- LeetCode Test Case 2 ---");
        int[][] matrix2 = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target2 = 13;
        System.out.println("Input matrix: " + java.util.Arrays.deepToString(matrix2));
        System.out.println("Input target: " + target2);
        boolean result2 = solver.searchMatrix(matrix2, target2);
        System.out.println("Output: " + result2); // Expected: false
        System.out.println("------------------------------\n");
    }
}

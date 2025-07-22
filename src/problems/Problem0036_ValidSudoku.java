package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem0036_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                // Skip empty cells; won't be any conflicts caused by them
                if (board[r][c] == '.') 
                    continue;
                
                // Get the key for the 3x3 square specifically using the row index and column index
                String squareKey = (r / 3) + ", " + (c / 3);

                /**
                 * Use key lambda function. If the key isn't in rows / cols / squares you create a new hashset; otherwise, you check if the current 
                 * value of board[r][c] is containted within these hashsets and return false if it is (this means dupe value in col, row, or square)
                 */
                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
                    cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) || 
                    squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c])) {
                        return false;
                }

                // We add the board value to the row, col, and square hashset for obvious reasons.
                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);
            }
        }
        // If there's no issues it's valid!
        return true;
    }

    public static void main(String[] args) {
        Problem0036_ValidSudoku solver = new Problem0036_ValidSudoku(); // Create an instance of the class

        // LeetCode Test Case 1: Valid Sudoku
        char[][] board1 = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("--- LeetCode Test Case 1 (Valid Sudoku) ---");
        System.out.println("Expected: true");
        boolean isValid1 = solver.isValidSudoku(board1);
        System.out.println("Actual: " + isValid1);
        System.out.println("----------------------------------------------\n");

        // LeetCode Test Case 2: Invalid Sudoku (due to duplicates)
        char[][] board2 = {
            {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, // Duplicate '8' in row 3 (0-indexed)
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println("--- LeetCode Test Case 2 (Invalid Sudoku - Duplicate '8' in a row) ---");
        System.out.println("Expected: false");
        boolean isValid2 = solver.isValidSudoku(board2);
        System.out.println("Actual: " + isValid2);
        System.out.println("----------------------------------------------\n");
    }
}

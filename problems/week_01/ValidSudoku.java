import java.util.*;

/**
 * ============================================================
 * VALID SUDOKU (LC #36) — Medium
 * ============================================================
 * 
 * PROBLEM:
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells
 * need to be validated according to the following rules:
 * 1. Each ROW must contain digits 1-9 without repetition.
 * 2. Each COLUMN must contain digits 1-9 without repetition.
 * 3. Each of the nine 3x3 SUB-BOXES must contain digits 1-9
 * without repetition.
 * 
 * Note: A partially filled board (with '.' for empty cells)
 * can be valid — you are NOT solving the sudoku, just checking validity.
 * 
 * CONSTRAINTS:
 * - board.length == 9
 * - board[i].length == 9
 * - board[i][j] is a digit '1'-'9' or '.'
 * 
 * PATTERN: HashSet per Row/Column/Box
 * 
 * APPROACH:
 * - Use a HashSet for each row (9 sets), each column (9 sets),
 * and each box (9 sets).
 * - For each cell (r, c) with a digit: check if digit already
 * exists in row[r], col[c], or box[r/3][c/3].
 * - If duplicate found → return false. Otherwise → return true.
 * 
 * COMPLEXITY:
 * - Time: O(81) = O(1) — fixed board size
 * - Space: O(81) = O(1) — fixed number of sets
 * 
 * YOUR TASK: Implement isValidSudoku() below.
 * ============================================================
 */
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char value = board[row][col];

                if (value == '.')
                    continue;

                int boxIndex = (row / 3) * 3 + col / 3;

                if (!cols[col].add(value) || !rows[row].add(value) || !boxes[boxIndex].add(value)) {
                    return false;
                }
            }
        }

        return true;
    }

    // ==================== DRIVER CODE — DO NOT MODIFY ====================
    public static void main(String[] args) {
        int passed = 0;
        int total = 5;

        // Test 1: Valid board (LeetCode example)
        char[][] board1 = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        if (isValidSudoku(board1) == true) {
            System.out.println("✅ Test 1 PASSED: Valid board");
            passed++;
        } else {
            System.out.println("❌ Test 1 FAILED: Expected true (valid board)");
        }

        // Test 2: Invalid — duplicate in column (two 8s in column 0)
        char[][] board2 = {
                { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        if (isValidSudoku(board2) == false) {
            System.out.println("✅ Test 2 PASSED: Duplicate '8' in column 0");
            passed++;
        } else {
            System.out.println("❌ Test 2 FAILED: Expected false (duplicate in column)");
        }

        // Test 3: Invalid — duplicate in 3x3 box
        char[][] board3 = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '5', '8', '.', '.', '.', '.', '6', '.' }, // '5' at (2,1) duplicates '5' at (0,0) in top-left box
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        if (isValidSudoku(board3) == false) {
            System.out.println("✅ Test 3 PASSED: Duplicate '5' in top-left 3x3 box");
            passed++;
        } else {
            System.out.println("❌ Test 3 FAILED: Expected false (duplicate in box)");
        }

        // Test 4: Invalid — duplicate in row
        char[][] board4 = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '8', '9' } // two '8's in last row
        };
        if (isValidSudoku(board4) == false) {
            System.out.println("✅ Test 4 PASSED: Duplicate '8' in row 8");
            passed++;
        } else {
            System.out.println("❌ Test 4 FAILED: Expected false (duplicate in row)");
        }

        // Test 5: All empty board (valid)
        char[][] board5 = {
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.', }
        };
        if (isValidSudoku(board5) == true) {
            System.out.println("✅ Test 5 PASSED: All empty board is valid");
            passed++;
        } else {
            System.out.println("❌ Test 5 FAILED: Expected true (empty board)");
        }

        System.out.println("\n=== RESULTS: " + passed + "/" + total + " tests passed ===");
    }
}

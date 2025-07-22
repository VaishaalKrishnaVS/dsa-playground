package recursion.level02;

/**
 * N-Queens Problem - Optimized with Branch and Bound
 *
 * <p>Place N queens on an N×N chessboard such that no two queens attack each other. This optimized
 * version uses boolean arrays to track conflicts instead of checking the entire board for each
 * placement.
 *
 * <p>Optimization Techniques: - col[]: tracks column conflicts - dg[]: tracks diagonal conflicts
 * (top-left to bottom-right) - rd[]: tracks reverse diagonal conflicts (top-right to bottom-left)
 *
 * <p>Diagonal Indexing: - Normal diagonal: row + col (0 to 2n-2) - Reverse diagonal: row - col + n
 * - 1 (0 to 2n-2)
 *
 * <p>Example: 4×4 board solutions Solution 1: "0:1 1:3 2:0 3:2 ." Solution 2: "0:2 1:0 2:3 3:1 ."
 *
 * <p>Output format: "row:col row:col ... ."
 *
 * <p>Time Complexity: O(N!) - much better than O(N^N) brute force Space Complexity: O(N) for
 * tracking arrays + O(N) recursion depth
 */
public class NQueens {
  public static void main(String[] args) {
    var n = 4;
    var board = new boolean[n][n];
    var col = new boolean[n];
    var dg = new boolean[2 * n - 1];
    var rd = new boolean[2 * n - 1];

    printNQBB(board, col, dg, rd, 0, "");
  }

  /**
   * Recursively places queens using branch and bound optimization
   *
   * @param board N×N chessboard (boolean array)
   * @param col column conflict tracker
   * @param dg diagonal conflict tracker (row + col)
   * @param rd reverse diagonal conflict tracker (row - col + n - 1)
   * @param row current row to place queen
   * @param s current solution path as string
   */
  private static void printNQBB(
      boolean[][] board, boolean[] col, boolean[] dg, boolean[] rd, int row, String s) {

    if (row == board.length) {
      System.out.println(s + ".");
      return;
    }

    for (var c = 0; c < col.length; c++) {
      if (isSafe(col, dg, rd, row, c)) {
        board[row][c] = true;
        col[c] = true;
        dg[row + c] = true;
        rd[row - c + col.length - 1] = true;
        printNQBB(board, col, dg, rd, row + 1, s + row + ":" + c + " ");
        board[row][c] = false;
        col[c] = false;
        dg[row + c] = false;
        rd[row - c + col.length - 1] = false;
      }
    }
  }

  /**
   * Checks if placing queen at (row, c) is safe using conflict arrays
   *
   * @param col column conflicts
   * @param dg diagonal conflicts
   * @param rd reverse diagonal conflicts
   * @param row target row
   * @param c target column
   * @return true if position is safe from all conflicts
   */
  private static boolean isSafe(boolean[] col, boolean[] dg, boolean[] rd, int row, int c) {
    return !col[c] && !dg[row + c] && !rd[row - c + col.length - 1];
  }
}

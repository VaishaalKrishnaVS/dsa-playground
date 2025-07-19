package recursion.level01.print;

import java.util.Arrays;

/**
 * N-Queens Problem
 *
 * <p>Place N queens on an N×N chessboard such that no two queens attack each other. Queens can
 * attack horizontally, vertically, and diagonally.
 *
 * <p>Example: 4×4 board has 2 solutions Solution 1: Queens at (0,1), (1,3), (2,0), (3,2) Solution
 * 2: Queens at (0,2), (1,0), (2,3), (3,1)
 *
 * <p>Algorithm: Place queens row by row, backtrack when conflicts arise
 *
 * <p>Time Complexity: O(N!) in best case, exponential in general Space Complexity: O(N²) for board
 * + O(N) recursion depth
 */
public class NQueens {
  public static void main(String[] args) {
    int n = 3;
    int[][] chess = new int[n][n];
    printNQueens(chess, 0);
  }

  /**
   * Recursively places queens on chessboard starting from given row
   *
   * @param chess N×N chessboard where 1 represents queen, 0 represents empty
   * @param row current row to place queen
   */
  private static void printNQueens(int[][] chess, int row) {
    var isComplete = chess.length == row;
    switch (isComplete ? 1 : 0) {
      case 1 -> System.out.println(Arrays.deepToString(chess));
      case 0 -> explore(chess, row);
    }
  }

  private static void explore(int[][] chess, int row) {
    for (int col = 0; col < chess.length; col++) {
      var isSafe = isSafeForQueen(chess, row, col);
      switch (isSafe ? 1 : 0) {
        case 1 -> {
          chess[row][col] = 1;
          printNQueens(chess, row + 1);
          chess[row][col] = 0;
        }
        case 0 -> {
          /* skip unsafe position */
        }
      }
    }
  }

  /**
   * Checks whether placing queen at given position is safe from attacks
   *
   * @param chess current board state
   * @param row target row position
   * @param col target column position
   * @return true when position is safe from all existing queens
   */
  private static boolean isSafeForQueen(int[][] chess, int row, int col) {
    for (int i = 0; i < chess.length; i++) {
      for (int j = 0; j < chess.length; j++) {
        var hasQueen = chess[i][j] == 1;
        var isConflict = i == row || j == col || Math.abs(i - row) == Math.abs(j - col);
        switch (hasQueen && isConflict ? 1 : 0) {
          case 1 -> {
            return false;
          }
          case 0 -> {
            /* continue checking */
          }
        }
      }
    }
    return true;
  }

}

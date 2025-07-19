package recursion.level01.print;

import java.util.Arrays;

/**
 * Knight's Tour Problem
 *
 * <p>Find a sequence of moves for a knight on a chessboard such that the knight visits every square
 * exactly once.
 *
 * <p>Knight moves in L-shape: 2 squares in one direction, 1 square perpendicular Possible moves: 8
 * directions from any position
 *
 * <p>Example: 8×8 board has multiple solutions where knight visits all 64 squares
 *
 * <p>Algorithm: Backtracking with all 8 possible knight moves
 *
 * <p>Time Complexity: O(8^(N²)) exponential Space Complexity: O(N²) for board + recursion depth
 */
public class KnightsTour {
  public static void main(String[] args) {
    var board = new int[5][5];
    board[0][0] = 1;
    printKT(0, 0, board, 1);
  }

  private static final int[][] dir = {
    {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}
  };

  /**
   * Recursively explores knight's tour from current position
   *
   * @param x current row position
   * @param y current column position
   * @param board chessboard with move numbers
   * @param steps current step number
   */
  private static void printKT(int x, int y, int[][] board, int steps) {
    var isComplete = steps == board.length * board.length;

    switch (isComplete ? 1 : 0) {
      case 1 -> System.out.println(Arrays.deepToString(board));
      case 0 -> exploreKnightMoves(x, y, board, steps);
    }
  }

  private static void exploreKnightMoves(int x, int y, int[][] board, int steps) {
    for (var move : dir) {
      var nx = x + move[0];
      var ny = y + move[1];
      var isValid = isValidMove(nx, ny, board);

      switch (isValid ? 1 : 0) {
        case 1 -> {
          board[nx][ny] = steps;
          printKT(nx, ny, board, steps + 1);
          board[nx][ny] = 0;
        }
        case 0 -> {
          /* skip invalid move */
        }
      }
    }
  }

  private static boolean isValidMove(int x, int y, int[][] board) {
    return x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] == 0;
  }
}

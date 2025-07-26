package graph.level01;

import java.util.Arrays;

public class KnightsTour {
  public static void main(String[] args) {
    var board = new int[5][5];
    for (var ar : board) Arrays.fill(ar, -1);
    printKT(board, 2, 2, 1);
  }

  private static final int[][] dirs = {
    {-2, 1},
    {-1, 2},
    {1, 2},
    {2, 1},
    {2, -1},
    {1, -2},
    {-1, -2},
    {-2, -1}
  };

  private static void printKT(int[][] board, int row, int col, int step) {
    if (step == board.length * board.length) {
      board[row][col] = step;
      System.out.println(Arrays.deepToString(board));
      board[row][col] = -1;
      return;
    }

    board[row][col] = step;
    for (var d : dirs) {
      var r = row + d[0];
      var c = col + d[1];
      if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == -1) {
        printKT(board, r, c, step + 1);
      }
    }
    board[row][col] = -1;
  }
}

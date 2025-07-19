package recursion.level01.print;

/**
 * Flood Fill Path Finding Problem
 *
 * <p>Find all possible paths from top-left to bottom-right in a 2D board where 'O' represents open
 * cells and '.' represents blocked cells.
 *
 * <p>Movement directions: - 't' = top (up), 'l' = left, 'r' = right, 'd' = down
 *
 * <p>Example: 3x3 board with some blocked cells Board: [[O, O, O], [O, ., O], [O, O, O]] Possible
 * paths from (0,0) to (2,2)
 *
 * <p>Time Complexity: O(4^(m*n)) in worst case Space Complexity: O(m*n) for visited array and
 * recursion
 */
public class FloodFill {
  public static void main(String[] args) {
    var board =
        new char[][] {
          {'O', 'O', 'O'},
          {'O', '.', 'O'},
          {'O', 'O', 'O'}
        };
    var visited = new boolean[board.length][board[0].length];
    getPath(board, 0, 0, "", visited);
  }

  /**
   * Recursively finds all paths from current position to bottom-right corner
   *
   * @param board 2D character array where 'O' = open, '.' = blocked
   * @param r current row position
   * @param c current column position
   * @param p current path string
   * @param vis visited cells tracker
   */
  private static void getPath(char[][] board, int r, int c, String p, boolean[][] vis) {
    var isValid = isValidMove(r, c, board, vis);
    var isDestination = r == board.length - 1 && c == board[0].length - 1;

    switch (isValid ? (isDestination ? 2 : 1) : 0) {
      case 0 -> {
        /* invalid move */
      }
      case 2 -> System.out.println(p);
      case 1 -> {
        vis[r][c] = true;
        exploreDirections(board, r, c, p, vis);
        vis[r][c] = false;
      }
    }
  }

  private static boolean isValidMove(int r, int c, char[][] board, boolean[][] vis) {
    return r >= 0
        && c >= 0
        && r < board.length
        && c < board[0].length
        && board[r][c] == 'O'
        && !vis[r][c];
  }

  private static void exploreDirections(char[][] board, int r, int c, String p, boolean[][] vis) {
    var moves = new int[][] {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};
    var directions = new char[] {'t', 'l', 'r', 'd'};

    for (int i = 0; i < moves.length; i++) {
      getPath(board, r + moves[i][0], c + moves[i][1], p + directions[i], vis);
    }
  }
}

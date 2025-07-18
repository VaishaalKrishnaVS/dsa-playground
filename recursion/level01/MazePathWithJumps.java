package recursion.level01;

import java.util.ArrayList;

/**
 * Maze Path With Jumps Problem
 *
 * <p>Find all possible paths from source (sr, sc) to destination (dr, dc) where you can make
 * variable-sized jumps in three directions: - Horizontal jumps (H): move right by 1 to n steps -
 * Vertical jumps (V): move down by 1 to n steps - Diagonal jumps (D): move diagonally down-right by
 * 1 to n steps
 *
 * <p>Example: From (1,1) to (3,3) includes paths like "H2", "V1H1V1", "D2", etc. - "H2" means jump
 * 2 steps horizontally - "V1" means jump 1 step vertically - "D2" means jump 2 steps diagonally
 *
 * <p>Time Complexity: Exponential - much larger than basic maze paths Space Complexity: Exponential
 * for storing all possible jump combinations
 */
public class MazePathWithJumps {
  public static void main(String[] args) {
    var ans = getPaths(1, 1, 3, 3);
    System.out.println(ans);
  }

  /**
   * Recursively finds all possible paths with variable jumps from source to destination
   *
   * @param sr source row
   * @param sc source column
   * @param dr destination row
   * @param dc destination column
   * @return ArrayList of all possible paths with jump notations (H/V/D + jump size)
   */
  private static ArrayList<String> getPaths(int sr, int sc, int dr, int dc) {
    if (sr == dr && sc == dc) {
      var lis = new ArrayList<String>();
      lis.add("");
      return lis;
    }
    if (sr > dr || sc > dc) return new ArrayList<>();
    // horizontal
    var ans = new ArrayList<String>();
    for (int ms = 1; ms <= dc - sc; ms++) {
      var pathH = getPaths(sr, sc + ms, dr, dc);
      for (var s : pathH) ans.add("H" + ms + s);
    }
    // vertical
    for (int ms = 1; ms <= dr - sr; ms++) {
      var pathV = getPaths(sr + ms, sc, dr, dc);
      for (var s : pathV) ans.add("V" + ms + s);
    }
    // diagonal
    for (int ms = 1; ms <= dr - sr && ms <= dc - sc; ms++) {
      var pathD = getPaths(sr + ms, sc + ms, dr, dc);
      for (var s : pathD) ans.add("D" + ms + s);
    }
    return ans;
  }
}

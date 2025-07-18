package recursion.level01;

import java.util.ArrayList;

/**
 * Maze Paths Problem
 *
 * <p>Find all possible paths from source (sr, sc) to destination (dr, dc) in a maze where you can
 * only move horizontally right ('h') or vertically down ('v').
 *
 * <p>Example: From (1,1) to (3,3) -> Output ["hhvv", "hvhv", "hvvh", "vhhv", "vhvh", "vvhh"] - 'h'
 * represents horizontal move (right) - 'v' represents vertical move (down)
 *
 * <p>Time Complexity: O(2^(m+n)) where m,n are dimensions Space Complexity: O(2^(m+n)) for storing
 * all paths
 */
public class MazePaths {
  public static void main(String[] args) {
    var ans = getPaths(1, 1, 3, 3);
    System.out.println(ans);
  }

  /**
   * Recursively finds all possible paths from source to destination
   *
   * @param sr source row
   * @param sc source column
   * @param dr destination row
   * @param dc destination column
   * @return ArrayList of all possible paths as strings of 'h' and 'v' moves
   */
  private static ArrayList<String> getPaths(int sr, int sc, int dr, int dc) {
    if (sr == dr && sc == dc) {
      var lis = new ArrayList<String>();
      lis.add("");
      return lis;
    }
    if (sr > dr || sc > dc) return new ArrayList<>();
    var hp = getPaths(sr, sc + 1, dr, dc);
    var vp = getPaths(sr + 1, sc, dr, dc);
    var ans = new ArrayList<String>();
    for (var s : hp) ans.add('h' + s);
    for (var s : vp) ans.add('v' + s);
    return ans;
  }
}

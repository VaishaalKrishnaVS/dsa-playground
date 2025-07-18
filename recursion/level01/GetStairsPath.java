package recursion.level01;

import java.util.ArrayList;

/**
 * Stairs Path Problem
 *
 * <p>Given n stairs, find all possible ways to reach the top where you can take 1, 2, or 3 steps at
 * a time.
 *
 * <p>Example: n=3 -> Output ["111", "12", "21", "3"] - "111": take 1 step three times - "12": take
 * 1 step then 2 steps - "21": take 2 steps then 1 step - "3": take 3 steps at once
 *
 * <p>Time Complexity: O(3^n) in worst case Space Complexity: O(3^n) for storing all paths
 */
public class GetStairsPath {
  public static void main(String[] args) {
    var n = 9;
    var ans = getStairsPath(n);
    System.out.println(ans);
  }

  /**
   * Recursively finds all possible ways to climb n stairs taking 1, 2, or 3 steps at a time
   *
   * @param n number of stairs to climb
   * @return ArrayList of all possible step sequences as strings
   */
  private static ArrayList<String> getStairsPath(int n) {
    if (n == 0) {
      var lis = new ArrayList<String>();
      lis.add("");
      return lis;
    }
    if (n < 0) {
      return new ArrayList<>();
    }
    var path1 = getStairsPath(n - 1);
    var path2 = getStairsPath(n - 2);
    var path3 = getStairsPath(n - 3);
    var ans = new ArrayList<String>();
    for (var s : path1) ans.add(1 + s);
    for (var s : path2) ans.add(2 + s);
    for (var s : path3) ans.add(3 + s);
    return ans;
  }
}

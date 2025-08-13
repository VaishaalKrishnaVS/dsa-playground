package recursion.level02;

import java.util.Arrays;

public class Combinations {
  private static int count;

  public static void main(String[] args) {
    count = 0;
    var b = 4;
    var i = 2;
    solve(1, b, 0, i, "");
    solve(1, i, new int[b], -1);
  }

  private static void solve(int n, int b, int i, int j, String s) {
    if (n > b) {
      if (i == j) System.out.println(++count + " " + s);
      return;
    }
    if (i > j) return;
    solve(n + 1, b, i + 1, j, s + "o");
    solve(n + 1, b, i, j, s + "-");
  }

  private static void solve(int c, int t, int[] arr, int li) {
    if (c > t) {
      System.out.println(++count + " " + Arrays.toString(arr));
      return;
    }
    for (int i = li + 1; i < arr.length; i++) {
      arr[i] = c;
      solve(c + 1, t, arr, i);
      arr[i] = 0;
    }
  }
}

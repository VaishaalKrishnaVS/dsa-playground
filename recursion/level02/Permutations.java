package recursion.level02;

import java.util.Arrays;

public class Permutations {
  private static int count;

  public static void main(String[] args) {
    count = 0;
    var box = 4;
    var obj = 2;

    var arr = new int[box];
    solve(arr, 1, obj);
    count = 0;
    var used = new boolean[obj];
    solve(used, 0, 1, box, "");
  }

  private static void solve(int[] arr, int c, int t) {
    if (c > t) {
      System.out.println(++count + " " + Arrays.toString(arr));
      return;
    }
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        arr[i] = c;
        solve(arr, c + 1, t);
        arr[i] = 0;
      }
    }
  }

  private static void solve(boolean[] used, int tot, int cur, int boxes, String asf) {
    if (cur > boxes) {
      if (tot == used.length) System.out.println(++count + " " + asf);
      return;
    }
    for (int i = 0; i < used.length; i++) {
      if (!used[i]) {
        used[i] = true;
        solve(used, tot + 1, cur + 1, boxes, asf + (i + 1));
        used[i] = false;
      }
    }
    solve(used, tot, cur + 1, boxes, asf + '0');
  }
}

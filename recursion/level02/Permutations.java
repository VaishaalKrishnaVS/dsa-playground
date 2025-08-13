package recursion.level02;

import java.util.Arrays;

public class Permutations {
    private static int count;
  public static void main(String[] args) {
      count=0;
    var box = 4;
    var obj = 2;

    var arr = new int[box];
    solve(arr, 1, obj);
  }

  private static void solve(int[] arr, int c, int t) {
    if (c > t) {
      System.out.println(++count+" "+Arrays.toString(arr));
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
}

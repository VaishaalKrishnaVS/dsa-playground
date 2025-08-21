package recursion.level02;

import java.util.Arrays;
import java.util.HashMap;

public class PermutationOfString {
  static int count;

  public static void main(String[] args) {
    count = 0;
    var s = "abba";
    var map = new HashMap<Character, Integer>();
    for (var c : s.toCharArray()) map.put(c, -1);
    solve(1, s.length(), map, "");
    solve(0, s.length(), map, new Character[s.length()], s);
  }

  private static void solve(int cp, int tp, HashMap<Character, Integer> map, String asf) {
    if (cp > tp) {
      System.out.println(++count + " " + asf);
      return;
    }

    for (var ch : map.keySet()) {
      if (map.get(ch) > 0) {
        map.merge(ch, -1, Integer::sum);
        solve(cp + 1, tp, map, asf + ch);
        map.merge(ch, 1, Integer::sum);
      }
    }
  }

  private static void solve(
      int cc, int tc, HashMap<Character, Integer> map, Character[] arr, String s) {
    if (cc == tc) {
      System.out.println(++count + " " + Arrays.toString(arr));
      return;
    }

    var ch = s.charAt(cc);
    var lo = map.get(ch);
    for (int i = lo + 1; i < arr.length; i++) {
      if (arr[i] == null) {
        arr[i] = ch;
        map.put(ch, i);
        solve(cc + 1, tc, map, arr, s);
        arr[i] = null;
        map.put(ch, lo);
      }
    }
  }
}

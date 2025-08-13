package recursion.level02;

import java.util.HashMap;

public class PermutationOfString {
  static int count;

  public static void main(String[] args) {
    count = 0;
    var s = "abbaa";
    var map = new HashMap<Character, Integer>();
    for (var c : s.toCharArray()) map.merge(c, 1, Integer::sum);
    solve(1, s.length(), map, "");
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
}

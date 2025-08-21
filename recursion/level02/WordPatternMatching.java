package recursion.level02;

import java.util.HashMap;

public class WordPatternMatching {
  public static void main(String[] args) {
    var pattern = "abcb";
    var string = "mzaddytzaddy";
    solve(pattern, string, new HashMap<>());
  }

  private static void solve(String p, String s, HashMap<Character, String> map) {
    if (p.isEmpty()) {
      if (s.isEmpty()) {
        System.out.println(map);
      }
      return;
    }
    char ch = p.charAt(0);
    String rep = p.substring(1);
    if (map.containsKey(ch)) {
      String str = map.get(ch);
      if (s.length() >= str.length()) {
        var pre = s.substring(0, str.length());
        var post = s.substring(str.length());
        if (str.equals(pre)) {
          solve(rep, post, map);
        }
      }
    } else {
      for (int i = 0; i < s.length(); i++) {
        var pre = s.substring(0, i + 1);
        var post = s.substring(i + 1);
        map.put(ch, pre);
        solve(rep, post, map);
        map.remove(ch);
      }
    }
  }
}

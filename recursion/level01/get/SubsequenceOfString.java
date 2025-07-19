package recursion.level01.get;

import java.util.ArrayList;

/**
 * This class finds all possible subsequences of a given string. A subsequence is a sequence that
 * can be derived from another sequence by deleting some or no elements without changing the order
 * of the remaining elements. For example, for string "abc", subsequences are ["", "c", "b", "bc",
 * "a", "ac", "ab", "abc"]
 */
public class SubsequenceOfString {
  public static void main(String[] args) {
    var s = "abc";
    var ans = getSubsequence(s);
    System.out.println(ans);
  }

  private static ArrayList<String> getSubsequence(String str) {
    if (str.isEmpty()) {
      var lis = new ArrayList<String>();
      lis.add("");
      return lis;
    }
    ArrayList<String> res = new ArrayList<>();
    var lis = getSubsequence(str.substring(1));
    char ch = str.charAt(0);
    for (String s : lis) {
      res.add(ch + s);
      res.add(s);
    }
    return res;
  }
}

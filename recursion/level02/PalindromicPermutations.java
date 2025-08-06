package recursion.level02;

import java.util.HashMap;

public class PalindromicPermutations {
  public static void main(String[] args) {
    var s = "ababc";
    var map = new HashMap<Character, Integer>();
    for (var ch : s.toCharArray()) map.merge(ch, 1, Integer::sum);
    var oddCount = 0;
    var n=0;
    var oddChar = ' ';
    for (var es : map.entrySet()) {
      if (es.getValue() % 2 != 0) {
        oddCount++;
        oddChar = es.getKey();
      } else {map.put(es.getKey(), es.getValue() / 2); n++;}
      if (oddCount > 1) {
        System.out.println("Permutation not possible");
        return;
      }
    }
    printAllPermo(map, "", oddChar,n);
  }
  private static void printAllPermo(HashMap<Character, Integer> map, String prefix, char oddChar, int n) {
    if (prefix.length()==n) {
      System.out.println(prefix + (oddChar == ' ' ? "" : oddChar) + new StringBuilder(prefix).reverse());
      return;
    }
    for (var es : map.entrySet()) {
      if (es.getValue() > 0) {
        map.put(es.getKey(), es.getValue() - 1);
        printAllPermo(map, prefix + es.getKey(), oddChar, n);
        map.put(es.getKey(), es.getValue() + 1);
      }
    }
  }
}

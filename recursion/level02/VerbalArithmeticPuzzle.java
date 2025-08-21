package recursion.level02;

import java.util.HashMap;
import java.util.HashSet;

public class VerbalArithmeticPuzzle {
  public static void main(String[] args) {
    var words = new String[] {"THAT", "IS", "WHY", "IT", "IS"};
    var result = "FALSE";
    System.out.println(Solution.isSolvable(words, result));
  }

  static class Solution {
    static String[] words;
    static String result;
    static HashSet<Character> leadingZeros;
    static int maxLen;

    public static boolean isSolvable(String[] w, String r) {
      words = w;
      result = r;
      var map = new HashMap<Character, Integer>();
      var numArr = new boolean[10];
      var chars = new HashSet<Character>();
      leadingZeros = new HashSet<>();

      maxLen = result.length();
      for (var s : words) {
        maxLen = Math.max(maxLen, s.length());
        if (s.length() > 1) leadingZeros.add(s.charAt(0));
        for (var ch : s.toCharArray()) chars.add(ch);
      }
      if (result.length() > 1) leadingZeros.add(result.charAt(0));
      for (var c : result.toCharArray()) chars.add(c);

      if (chars.size() > 10) return false; // More than 10 unique chars

      var charArray = chars.toArray(new Character[0]);
      return solve(map, numArr, charArray, 0);
    }

    private static boolean solve(
        HashMap<Character, Integer> map,
        boolean[] arr,
        Character[] chars,
        int ind) {
      if (ind == chars.length) {
        return isValidWithCarry(map);
      }

      var ch = chars[ind];
      int start = leadingZeros.contains(ch) ? 1 : 0;

      for (int i = start; i < 10; i++) {
        if (!arr[i]) {
          map.put(ch, i);
          arr[i] = true;
          if (solve(map, arr, chars, ind + 1)) return true;
          arr[i] = false;
        }
      }
      return false;
    }

    private static boolean isValidWithCarry(HashMap<Character, Integer> map) {
      int carry = 0;
      for (int col = 0; col < maxLen; col++) {
        int sum = carry;
        for (var word : words) {
          if (col < word.length()) {
            char ch = word.charAt(word.length() - 1 - col);
            sum += map.get(ch);
          }
        }

        if (col < result.length()) {
          char resultChar = result.charAt(result.length() - 1 - col);
          if (sum % 10 != map.get(resultChar)) return false;
        } else if (sum % 10 != 0) {
          return false;
        }

        carry = sum / 10;
      }
      return carry == 0;
    }
  }
}

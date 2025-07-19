package recursion.level01.print;

/**
 * String Encodings Problem
 *
 * <p>Given a numeric string, print all possible decodings where: 1='a', 2='b', ..., 26='z'
 *
 * <p>Example: Input "123" -> Output ["abc", "aw", "lc"] - "123" can be decoded as "1-2-3" -> "abc"
 * - "123" can be decoded as "12-3" -> "lc" - "123" can be decoded as "1-23" -> "aw"
 *
 * <p>Constraints: Numbers 01-09 are invalid, only 1-26 are valid encodings
 *
 * <p>Time Complexity: O(2^n) in worst case Space Complexity: O(n) for recursion depth
 */
public class Encodings {
  public static void main(String[] args) {
    printE("123", "");
  }

  /**
   * Recursively generates and prints all valid encodings of numeric string
   *
   * @param s remaining string to decode
   * @param asf current encoding being built (answer so far)
   */
  private static void printE(String s, String asf) {
    switch (s.length()) {
      case 0 -> System.out.println(asf);
      case 1 -> {
        var ch = s.charAt(0);
        if (ch != '0') {
          var chv = ch - '0';
          var code = (char) ('a' + chv - 1);
          System.out.println(asf + code);
        }
      }
      default -> {
        var ch = s.charAt(0);
        var rem = s.substring(1);
        if (ch == '0') return;
        else {
          var chv = ch - '0';
          var code = (char) ('a' + chv - 1);
          printE(rem, asf + code);
        }
        var ch2 = s.substring(0, 2);
        var rem2 = s.substring(2);
        if (Integer.parseInt(ch2) <= 26) {
          var chv = Integer.parseInt(ch2);
          var code = (char) ('a' + chv - 1);
          printE(rem2, asf + code);
        }
      }
    }
  }
}

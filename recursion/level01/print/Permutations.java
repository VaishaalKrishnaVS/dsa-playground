package recursion.level01.print;

/**
 * String Permutations Problem
 *
 * <p>Generate and print all possible permutations of a given string. A permutation is a
 * rearrangement of characters where each character appears exactly once.
 *
 * <p>Example: Input "abc" -> Output ["abc", "acb", "bac", "bca", "cab", "cba"]
 *
 * <p>Algorithm: For each character, fix it at current position and recursively generate
 * permutations of remaining characters.
 *
 * <p>Time Complexity: O(n! * n) where n is string length Space Complexity: O(n) for recursion depth
 */
public class Permutations {
  public static void main(String[] args) {
    printP("abc", "");
  }

  /**
   * Recursively generates and prints all permutations of input string
   *
   * @param s remaining characters to permute
   * @param o current permutation being built
   */
  private static void printP(String s, String o) {
    if (s.isEmpty()) {
      System.out.println(o);
      return;
    }

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      String rem = s.substring(0, i) + s.substring(i + 1);
      printP(rem, o + ch);
    }
  }
}

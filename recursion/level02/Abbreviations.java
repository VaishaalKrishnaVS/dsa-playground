package recursion.level02;

/**
 * String Abbreviations Problem
 *
 * Generate all possible abbreviations of a string where consecutive characters
 * can be replaced by their count.
 *
 * Example: Input "pep" → Output ["pep", "pe1", "p1p", "p2", "1ep", "1e1", "11p", "3"]
 * - "pep" = no abbreviation
 * - "pe1" = last char abbreviated
 * - "p1p" = middle char abbreviated
 * - "p2" = last two chars abbreviated
 * - "1ep" = first char abbreviated
 * - "1e1" = first and last chars abbreviated
 * - "11p" = first two chars abbreviated
 * - "3" = all chars abbreviated
 *
 * Algorithm: For each character, choose to include it or count it
 *
 * Recursion Tree for "pep":
 *                    printA("pep", "", 0, 0)
 *                   /                        \
 *            include 'p'                    count 'p'
 *         printA("pep", "p", 0, 1)      printA("pep", "", 1, 1)
 *           /              \                /              \
 *    include 'e'        count 'e'    include 'e'        count 'e'
 * printA("pep","pe",0,2) printA("pep","p",1,2) printA("pep","1e",0,2) printA("pep","",2,2)
 *     /        \           /        \           /        \           /        \
 * include'p' count'p' include'p' count'p' include'p' count'p' include'p' count'p'
 * "pep"      "pe1"    "p1p"     "p2"     "1ep"     "1e1"    "11p"     "3"
 *
 * Time Complexity: O(2^n) where n is string length
 * Space Complexity: O(n) for recursion depth
 */
public class Abbreviations {
  public static void main(String[] args) {
    printA("pep", "", 0, 0);
  }

  /**
   * Recursively generates all abbreviations of string
   *
   * @param s input string to abbreviate
   * @param asf answer so far (current abbreviation being built)
   * @param val current count of consecutive skipped characters
   * @param ind current index in string
   */
  private static void printA(String s, String asf, int val, int ind) {
    if (ind == s.length()) {
      if (val == 0) System.out.println(asf);
      else System.out.println(asf + val);
      return;
    }
    // Choice 1: Include current character
    if (val > 0) printA(s, asf + val + s.charAt(ind), 0, ind + 1);
    else printA(s, asf + s.charAt(ind), 0, ind + 1);

    // Choice 2: Count current character (abbreviate)
    printA(s, asf, val + 1, ind + 1);
  }
}

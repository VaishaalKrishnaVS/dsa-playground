package recursion.level01.get;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * KeyPad Combination Problem
 *
 * <p>Given a string containing digits from 1-8, return all possible letter combinations that the
 * number could represent on a phone keypad.
 *
 * <p>Keypad Mapping: 1: ABC, 2: DEF, 3: GHI, 4: JKL, 5: MNO, 6: PQRS, 7: TUV, 8: WXYZ
 *
 * <p>Example: Input "12" -> Output ["AD", "AE", "AF", "BD", "BE", "BF", "CD", "CE", "CF"]
 *
 * <p>Time Complexity: O(4^n) where n is the length of input string Space Complexity: O(4^n) for
 * storing all combinations
 */
public class KeyPadCombinations {
  public static final Map<Character, List<Character>> map;

  static {
    map = new HashMap<>();
    map.put('1', List.of('A', 'B', 'C'));
    map.put('2', List.of('D', 'E', 'F'));
    map.put('3', List.of('G', 'H', 'I'));
    map.put('4', List.of('J', 'K', 'L'));
    map.put('5', List.of('M', 'N', 'O'));
    map.put('6', List.of('P', 'Q', 'R', 'S'));
    map.put('7', List.of('T', 'U', 'V'));
    map.put('8', List.of('W', 'X', 'Y', 'Z'));
  }

  public static void main(String[] args) {
    var solution = getCombinations("12");
    System.out.println(solution);
  }

  /**
   * Recursively generates all possible letter combinations for given digit string
   *
   * @param str input string containing digits 1-8
   * @return ArrayList of all possible letter combinations
   */
  private static ArrayList<String> getCombinations(String str) {
    if (str == null || str.isEmpty()) {
      var lis = new ArrayList<String>();
      lis.add("");
      return lis;
    }
    var result = new ArrayList<String>();
    var c = str.charAt(0);
    var lis = getCombinations(str.substring(1));
    for (var s : lis) {
      for (var ch : map.get(c)) {
        result.add(ch + s);
      }
    }
    return result;
  }
}

package recursion.level02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CrossWords {
  public static void main(String[] args) {
    List<String> crossword =
        List.of(
            "+-++++++++",
            "+-++++++++",
            "+-++++++++",
            "+-----++++",
            "+-+++-++++",
            "+-+++-++++",
            "+++++-++++",
            "++------++",
            "+++++-++++",
            "+++++-+++");
    String words = "LONDON;DELHI;ICELAND;ANKARA";

    List<String> result = crosswordPuzzle(crossword, words);
    if (result != null) {
      result.forEach(System.out::println);
    } else {
      System.out.println("No solution found");
    }
  }
  static List<String> ans = null;

  public static List<String> crosswordPuzzle(List<String> crossword, String words) {
    // Write your code here
    ans = null; // Reset for each call
    char[][] box = crossword.stream().map(String::toCharArray).collect(Collectors.toList()).toArray(new char[0][]);
    var wordsList = words.split(";");
    solve(box, wordsList, 0);
    return ans;
  }

  private static boolean solve(char[][] box, String[] w, int ind) {
    if (ind == w.length) {
      ans = Arrays.stream(box).map(String::new).collect(Collectors.toList());
      return true;
    }
    var word = w[ind];
    for (int i = 0; i < box.length; i++) {
      for (int j = 0; j < box[i].length; j++) {
        if (box[i][j] == '-' || box[i][j] == word.charAt(0)) {
          if (isHorizontallyFitting(box, i, j, word)) {
            var fixedPlaces = putH(box, i, j, word);
            if (solve(box, w, ind + 1)) return true;
            remH(box, i, j, word, fixedPlaces);
          }
          if (isVerticallyFitting(box, i, j, word)) {
            var fixedPlaces = putV(box, i, j, word);
            if (solve(box, w, ind + 1)) return true;
            remV(box, i, j, word, fixedPlaces);
          }
        }
      }
    }
    return false;
  }

  private static boolean isHorizontallyFitting(char[][] box, int i, int j, String word) {
    if (j - 1 >= 0 && box[i][j - 1] == '-') return false;
    if (j + word.length() < box[i].length && box[i][j + word.length()] == '-') return false;
    for (int k = 0; k < word.length(); k++) {
      if (j + k >= box[i].length) return false;
      if (box[i][j + k] == '+' || (box[i][j + k] != '-' && box[i][j + k] != word.charAt(k)))
        return false;
    }
    return true;
  }

  private static boolean isVerticallyFitting(char[][] box, int i, int j, String word) {
    if (i - 1 >= 0 && box[i - 1][j] == '-') return false;
    if (i + word.length() < box.length && box[i + word.length()][j] == '-') return false;
    for (int k = 0; k < word.length(); k++) {
      if (i + k >= box.length) return false;
      if (box[i + k][j] == '+' || (box[i + k][j] != '-' && box[i + k][j] != word.charAt(k)))
        return false;
    }
    return true;
  }

  private static boolean[] putH(char[][] box, int i, int j, String word) {
    boolean[] ans = new boolean[word.length()];
    for (int k = 0; k < word.length(); k++) {
      if (box[i][j + k] == '-') {
        box[i][j + k] = word.charAt(k);
        ans[k] = true;
      }
    }
    return ans;
  }

  private static boolean[] putV(char[][] box, int i, int j, String word) {
    var ans = new boolean[word.length()];
    for (int k = 0; k < word.length(); k++) {
      if (box[i + k][j] == '-') {
        ans[k] = true;
        box[i + k][j] = word.charAt(k);
      }
    }
    return ans;
  }

  private static void remH(char[][] box, int i, int j, String word, boolean[] fixedPlaces) {
    for (int k = 0; k < word.length(); k++) {
      if (fixedPlaces[k]) box[i][j + k] = '-';
    }
  }

  private static void remV(char[][] box, int i, int j, String word, boolean[] fixedPlaces) {
    for (int k = 0; k < word.length(); k++) {
      if (fixedPlaces[k]) box[i + k][j] = '-';
    }
  }
}

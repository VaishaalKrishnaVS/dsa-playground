package recursion.level01.print;

import java.util.List;

/**
 * Target Sum Subsets Problem
 *
 * <p>Find and print all subsets of given array that sum to target value. Each element can be either
 * included or excluded from the subset.
 *
 * <p>Example: Array [10, 20, 30], Target 30 Output: "10 20 ", "30 " - Subset {10, 20} sums to 30 -
 * Subset {30} sums to 30
 *
 * <p>Algorithm: For each element, explore two choices - include or exclude
 *
 * <p>Time Complexity: O(2^n) where n is array size Space Complexity: O(n) for recursion depth
 */
public class TargetSumSubsets {
  public static void main(String[] args) {
    printTSS(List.of(10, 20, 30), 0, "", 0, 30);
  }

  /**
   * Recursively finds all subsets that sum to target value
   *
   * @param list input array of integers
   * @param ind current index being processed
   * @param p current subset path as string
   * @param sum current sum of selected elements
   * @param target desired sum value
   */
  private static void printTSS(List<Integer> list, int ind, String p, int sum, int target) {
    var isComplete = ind == list.size();
    var isTargetReached = sum == target;

    switch (isComplete ? (isTargetReached ? 2 : 1) : 0) {
      case 2 -> System.out.println(p); // found valid subset
      case 1 -> {
        /* complete but wrong sum */
      }
      case 0 -> exploreChoices(list, ind, p, sum, target);
    }
  }

  private static void exploreChoices(List<Integer> list, int ind, String p, int sum, int target) {
    var current = list.get(ind);
    var nextInd = ind + 1;

    // include current element
    printTSS(list, nextInd, p + current + " ", sum + current, target);
    // exclude current element
    printTSS(list, nextInd, p, sum, target);
  }
}

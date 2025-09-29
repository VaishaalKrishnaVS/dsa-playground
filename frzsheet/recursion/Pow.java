package frzsheet.recursion;

import java.util.HashMap;
import java.util.Map;

// Leetcode 50
public class Pow {
  public static void main(String[] args) {
    System.out.println(myPow(2, 10));
  }
 private static Map<Integer, Double> map;
  public static double myPow(double x, int n) {
    map = new HashMap<>();
    switch (n > 0 ? 1 : 0) {
      case 1 -> {
        return helper(x, n);
      }
      case 0 -> {
        var ans = helper(x, -n);
        return 1.0 / ans;
      }
    }
    return 1;
  }

  private static double helper(double x, int n) {
    if (n == 0) return 1;
    if (map.containsKey(n)) return map.get(n);
    final double temp = helper(x, n / 2);
    map.put(n,temp);
    switch (n % 2 != 0 ? 'o' : 'e') {
      case 'o'-> {
        return x * temp * temp;
      }
      case 'e'-> {
        return temp * temp;
      }
    }
    return x * myPow(x, n - 1);
  }
}

package recursion.level02;

public class Combinations {
  private static int count;

  public static void main(String[] args) {
    count = 0;
    var b = 4;
    var i = 2;
    solve(1, b, 0, i, "");
  }

  private static void solve(int n, int b, int i, int j, String s) {
    if (n > b) {
      if (i == j) System.out.println(++count + " " + s);
      return;
    }
    if(i>j)return;
    solve(n + 1, b, i + 1, j, s + "o");
    solve(n + 1, b, i, j, s + "-");
  }
}

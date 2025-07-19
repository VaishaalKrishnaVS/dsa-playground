package recursion.level01.print;

public class StairsPaths {
  public static void main(String[] args) {
    printSP(4, "");
  }

  private static void printSP(int n, String path) {
    if (n == 0) {
      System.out.println(path);
      return;
    }
    if (n < 0) return;
    printSP(n - 1, path + 1);
    printSP(n - 2, path + 2);
    printSP(n - 3, path + 3);
  }
}

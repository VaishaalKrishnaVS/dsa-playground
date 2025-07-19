package recursion.level01.print;

public class MazePaths {
  public static void main(String[] args) {
    printMP(1, 1, 3, 3, "");
  }

  private static void printMP(int sr, int sc, int dr, int dc, String path) {
    if (sr == dr && sc == dc) {
      System.out.println(path);
      return;
    }
    if (sr > dr || sc > dc) return;

    printMP(sr + 1, sc, dr, dc, path + 'V');
    printMP(sr, sc + 1, dr, dc, path + 'H');
  }
}

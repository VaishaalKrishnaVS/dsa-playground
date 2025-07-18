package recursion.level01.print;

public class MazePathWithJumps {
  public static void main(String[] args) {
    printMPWJ(1, 1, 3, 3, "");
  }

  private static void printMPWJ(int sx, int sy, int ex, int ey, String path) {
    if (sx == ex && sy == ey) {
      System.out.println(path);
      return;
    }
    if (sx > ex || sy > ey) return;
    for (int i = 1; i <= ex - sx; i++) printMPWJ(sx + i, sy, ex, ey, "x" + i + path);
    for (int i = 1; i <= ey - sy; i++) printMPWJ(sx, sy + i, ex, ey, "y" + i + path);
    for (int i = 1; i <= ey - sy && i < ex - sx; i++)
      printMPWJ(sx + i, sy + i, ex, ey, "d" + i + path);
  }
}

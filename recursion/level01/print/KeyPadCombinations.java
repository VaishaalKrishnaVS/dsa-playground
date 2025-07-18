package recursion.level01.print;

public class KeyPadCombinations {
  public static void main(String[] args) {
    printKPC("23", "");
  }

  private static final String[] map = {
    "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQR", "STU", "VWX", "YZ"
  };

  private static void printKPC(String s, String o) {
    if (s.isEmpty()) {
      System.out.println(o);
      return;
    }
    var ch = s.charAt(0);
    var rem = s.substring(1);
    for (var c : map[ch - '0'].toCharArray()) {
      printKPC(rem, o + c);
    }
  }
}

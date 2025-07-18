package recursion.level01.print;

public class SubsequenceOfString {
  public static void main(String[] args) {
    print("abc", "");
  }

  private static void print(String q, String a) {
    if (q.isEmpty()) {
      System.out.println(a);
      return;
    }
    var ch = q.charAt(0);
    var rem = q.substring(1);
    print(rem, a + ch);
    print(rem, a);
  }
}

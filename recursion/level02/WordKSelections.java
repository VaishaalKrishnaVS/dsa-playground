package recursion.level02;

import java.util.HashSet;

public class WordKSelections {
    public static void main(String[] args){
        var s = "abcabhiig";
        var set = new HashSet<Character>();
        var sb = new StringBuilder();
    for (var c : s.toCharArray()) {
      if(set.add(c)) sb.append(c);
    }
    var us = sb.toString();
        int ln = 3;
        solve1(0, us.length(), 0, ln, "", us);
    }
    private static void solve1(int ci, int mi, int asfl, int ml, String asf, String us){
        if(ci>=mi){
            if(asfl==ml){
        System.out.println(asf);
            }
            return;
        }
        if(asfl>ml) return;
        var ch = us.charAt(ci);
        solve1(ci+1, mi, asfl+1, ml, asf+ch, us);
        solve1(ci+1, mi, asfl, ml, asf, us);
    }
}

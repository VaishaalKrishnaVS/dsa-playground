package neetcode.arrayandhashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeString {
    public static void main(String[] args) {
        var arr = List.of("neet","vaishaalKrishna","love","you");
        var encodedString = encode(arr);
        System.out.println(encodedString);
        var decoded = decode(encodedString);
        System.out.println(decoded);
    }
    public static String encode(List<String> strs) {
        var sb = new StringBuilder();
        for(String s:strs){
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String>ans = new ArrayList<>();
        for(int i=0;i<str.length();){
            var count = 0;
            while(str.charAt(i)!='#'){
                int v = str.charAt(i)-'0';
                count = count*10+v;
                i++;
            }
            ans.add(str.substring(i+1, i+count+1));
            i=i+count+1;
        }
        return ans;
    }
}

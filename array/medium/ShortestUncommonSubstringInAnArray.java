package array.medium;

import util.IIntutuionClass;

import java.util.ArrayList;
import java.util.Arrays;

//leetCode 3076
public class ShortestUncommonSubstringInAnArray implements IIntutuionClass {
    public static final String[] arr = {"gfnt","xn","mdz","yfmr","fi","wwncn","hkdy"};

    public static void main(String[] args) {
        var cls = new ShortestUncommonSubstringInAnArray();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        var ans = new String[arr.length];
        for(int i=0;i< arr.length;i++){
            var str = arr[i];
            ans[i] = getShortestString(i, str, arr);
        }
        System.out.println(Arrays.toString(ans));
    }

    private static String getShortestString(int idx, String s, String[] arr){
        var lis = new ArrayList<String>();
        var min = Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                var subString = s.substring(i,j+1);
                if(checkIf(subString, arr, idx)) {
                    lis.add(subString);
                    min = Math.min(subString.length(),min);
                }
            }
        }
        var newlis = new ArrayList<String>();
        for(String str: lis){
            if(str.length()==min) newlis.add(str);
        }
        var slis = newlis.toArray();
        Arrays.sort(slis);
        return lis.isEmpty()?"": (String) slis[0];
    }
    public static boolean checkIf(String s, String[] arr, int idx){
        for(int i=0;i< arr.length;i++){
            if(i==idx) continue;
            if(arr[i].contains(s)) return false;
        }
        return true;
    }
}

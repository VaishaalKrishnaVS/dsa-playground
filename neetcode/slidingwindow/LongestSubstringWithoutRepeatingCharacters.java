package neetcode.slidingwindow;

import util.IBaseClassV2;

public class LongestSubstringWithoutRepeatingCharacters implements IBaseClassV2<Integer, String> {
    public static void main(String[] args) {
        var cls = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(cls.intution("pwwkew"));
    }
    @Override
    public Integer intution(String s) {
        int arr[] = new int[26];
        int i=-1,j=-1;
        int ans =0;
        while (true){
            boolean f1=true;
            boolean f2=true;
            //include
            while(j<s.length()-1){
                f1=false;
                ++j;
                char charJ = s.charAt(j);
                arr[charJ-'a']++;
                if(arr[charJ-'a']==2) break;
                else ans = Math.max(ans, j-i);
            }
            //release
            while(i<j){
                f2= false;
                ++i;
                char charI = s.charAt(i);
                arr[charI-'a']--;
                if( arr[charI-'a']==1) break;
            }
            if(f1&&f2) break;
        }
        return ans;
    }
}

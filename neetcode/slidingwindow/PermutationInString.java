package neetcode.slidingwindow;

import util.IBaseClassV2;

public class PermutationInString implements IBaseClassV2<Boolean, Object> {
    public static void main(String[] args) {
        var cls = new PermutationInString();
        System.out.println(cls.intution(null));
    }

    @Override
    public Boolean intution(Object param) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        int[] s1map = new int[26];
        int[] s2map = new int[26];

        for(int i=0;i<s1.length();i++){
            s1map[s1.charAt(i)-'a']++;
            s2map[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length()-s1.length();i++){
            if(compareMap(s1map,s2map)) return true;
            s2map[s2.charAt(i+s1.length())-'a']++;
            s2map[s2.charAt(i)-'a']--;
        }
        return false;
    }
    private Boolean compareMap(int[]a, int[]b){
        for(int i=0;i<26;i++){
            if(a[i]!=b[i])return false;
        }
        return true;
    }
}

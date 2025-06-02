package neetcode.slidingwindow;

import util.IBaseClassV2;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement implements IBaseClassV2<Integer, String> {
    public static void main(String[] args) {
        var cls = new LongestRepeatingCharacterReplacement();
        System.out.println(cls.intution("AABABBCBA"));
    }

    @Override
    public Integer intution(String s) {
        int k =2;
        var map = new HashMap<Character,Integer>();
        int slow = 0;
        int max = 0;
        int ans = 0;
        for(int fast=0;fast<s.length();fast++){
            char ch = s.charAt(fast);
            map.merge(ch,1,Integer::sum);
            max = Math.max(max, map.get(ch));
            while(fast-slow+1-max>k){
                char c = s.charAt(slow);
                map.put(c, map.get(c)-1);
                slow++;
            }
            ans = Math.max(ans, fast-slow+1);
        }
        return ans;
    }
}

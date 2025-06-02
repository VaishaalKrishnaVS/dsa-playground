package neetcode.slidingwindow;

import util.IBaseClassV2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubstring implements IBaseClassV2<String, Object> {
    public static void main(String[] args) {
        var cls = new MinimumWindowSubstring();
        System.out.println(cls.intution(null));
    }

    @Override
    public String intution(Object param) {
        String s = "ab";
        String t = "b";
        var tmap = new HashMap<Character, Integer>();
        var smap = new HashMap<Character, Integer>();
        for(char ch: t.toCharArray())tmap.merge(ch, 1,Integer::sum);

        int i=0, j=0;
        int min = Integer.MAX_VALUE;
        String ans = "";
        while (j<s.length()){
            char chJ = s.charAt(j);
            smap.merge(chJ,1,Integer::sum );
            if(comapreMap(tmap, smap)){
                if(j-i+1<min){
                    ans = s.substring(i,j+1);
                    min= j-i+1;
                }
                while(i<j && comapreMap(tmap, smap)){
                    char chI = s.charAt(i);
                    smap.put(chI, smap.get(chI)-1);
                    if(comapreMap(tmap, smap)){
                        if(j-i<min){
                            ans = s.substring(i+1,j+1);
                            min= j-i+1;
                        }
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
    Boolean comapreMap(Map<Character, Integer> t, Map<Character, Integer> s){
        for(var ch: t.keySet()){
            if(s.getOrDefault(ch, 0) < t.get(ch)) return false;
        }
        return true;
    }
}

package array.medium;

import util.IIntutuionClass;

import java.util.*;
//leetCode 3039
public class ApplyOperationsToMakeStringEmpty implements IIntutuionClass {
    public static final String s = "aabcbbca";

    public static void main(String[] args) {
        var cls = new ApplyOperationsToMakeStringEmpty();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        var map = new HashMap<Character, Integer>();
        int max = Integer.MIN_VALUE;
        for(char ch: s.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
            max = Math.max(max, map.get(ch));
        }
        var nmap = new HashMap<Character, Integer>();
        var sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char key = s.charAt(i);
            if(map.get(key)==max){
                nmap.merge(key,1,Integer::sum);
                if(Objects.equals(map.get(key), nmap.get(key))) sb.append(key);
            }
        }
        System.out.println(sb);

    }
}

package array.medium;

import util.IIntutuionClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
//leetCode 451
public class SortCharactersByFrequency implements IIntutuionClass {
    public static final String s = "tree";

    public static void main(String[] args) {
        var cls = new SortCharactersByFrequency();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        var map = new HashMap<Character, Integer>();
        for(char ch: s.toCharArray()) map.merge(ch, 1, Integer::sum);
        var tmap = new TreeMap<Integer, ArrayList<Character>>(Collections.reverseOrder());
        for(var m:map.entrySet()){
            char k = m.getKey();
            int v = m.getValue();
            var lis = new ArrayList<Character>();
            if(tmap.containsKey(v)) lis = tmap.get(v);
            lis.add(k);
            tmap.put(v,lis);
        }
        var sb = new StringBuilder();
        for(var m:tmap.entrySet()){
            int k = m.getKey();
            for(char ch: m.getValue()){
                for(int i=0;i<k;i++) sb.append(ch);
            }
        }
        System.out.println(sb);
    }
}

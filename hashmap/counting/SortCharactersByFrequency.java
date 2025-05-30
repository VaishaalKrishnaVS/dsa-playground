package hashmap.counting;

import util.IBaseClassV2;

import java.util.*;
// leetCode 451
public class SortCharactersByFrequency implements IBaseClassV2<String, String> {
    public static void main(String[] args) {
        var cls = new SortCharactersByFrequency();
        System.out.println(cls.intution("tree"));
    }
    @Override
    public String intution(String s) {
        var map = new HashMap<Character, Integer>();
        var sb = new StringBuilder();
        for(char ch:s.toCharArray()) map.merge(ch, 1,Integer::sum);
        var gmap = new TreeMap<Integer, List<Character>>(Collections.reverseOrder());
        for(var m:map.entrySet()){
            gmap.computeIfAbsent(m.getValue(),_-> new ArrayList<>()).add(m.getKey());
        }
        for(var m:gmap.entrySet()){
            var k = m.getKey();
            var v = m.getValue();
            for(char ch:v){
                sb.append(String.valueOf(ch).repeat(Math.max(0, k)));
            }
        }
        return sb.toString();
    }
}

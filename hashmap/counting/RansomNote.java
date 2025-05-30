package hashmap.counting;

import util.IBaseClassV2;

import java.util.HashMap;
// leetCode 383
public class RansomNote implements IBaseClassV2<Boolean, Object> {
    public static void main(String[] args) {
        var cls = new RansomNote();
        System.out.println((cls.intution(null)));
    }
    @Override
    public Boolean intution(Object param) {
        String ransomNote = "aa", magazine = "aab";
        var map = new HashMap<Character,Integer>();
        for(char ch:magazine.toCharArray()) map.merge(ch,1,Integer::sum);
        for(char ch:ransomNote.toCharArray()){
            if(!map.containsKey(ch)) return false;
            if(map.get(ch)==1)map.remove(ch);
            else map.merge(ch,-1,Integer::sum);
        }
        return true;
    }
}

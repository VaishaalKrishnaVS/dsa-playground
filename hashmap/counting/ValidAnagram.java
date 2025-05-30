package hashmap.counting;

import util.IIntutuionClass;
// leetCode 252
public class ValidAnagram implements IIntutuionClass {
    public static void main(String[] args) {
        var cls = new ValidAnagram();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
    public boolean isAnagram(String s, String t) {
        var map = new int[26];
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
            map[s.charAt(i)-'a']++;
            map[t.charAt(i)-'a']--;
        }
        for(int i:map)if(i!=0) return false;
        return true;
    }
}

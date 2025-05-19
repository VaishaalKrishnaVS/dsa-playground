package hashmap.easy;

import util.IIntutuionClass;

import java.util.HashMap;
//leetCode 205
public class IsomorphicStrings implements IIntutuionClass {
    public static final String s = "egg", t = "add";
    @Override
    public void bruteForce() {
        System.out.println(getValue());
    }
    public boolean getValue(){
        var smap = new HashMap<Character,Character>();
        for (int i=0;i<s.length();i++){
            if(smap.containsKey(s.charAt(i))){
                if(smap.get(s.charAt(i))!=t.charAt(i)) return false;
            } else {
                if(smap.containsValue(t.charAt(i))) return false;
                smap.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
}

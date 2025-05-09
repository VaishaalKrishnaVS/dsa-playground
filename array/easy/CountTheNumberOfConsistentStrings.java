package array.easy;

import util.IBaseClass;

import java.util.HashSet;

//leetCode 1684
public class CountTheNumberOfConsistentStrings implements IBaseClass {
    private static final String allowed = "cad";
    public static final String[] words = {"cc","acd","b","ba","bac","bad","ac","d"};

    public static void main(String[] args) {
        var cls = new CountTheNumberOfConsistentStrings();
        cls.optimal();
    }

    @Override
    public void bruteForce() {
        var set = new HashSet<Character>();
        for (char ch : allowed.toCharArray()) set.add(ch);
        int ans = 0;
        for (String s : words) {
            boolean mayBe = true;
            for (char ch : s.toCharArray()) {
                if (!set.contains(ch)) {
                    mayBe = false;
                    break;
                }
            }
            if (mayBe) ans++;
        }
        System.out.println(ans);
    }

    @Override
    public void better() {
        int arr[] = new int[26];
        for(char ch: allowed.toCharArray()) arr[ch-'a']++;
        int ans = 0;
        for(String s: words){
            boolean mayBe =true;
            for(char ch: s.toCharArray()){
                if(arr[ch-'a']==0) mayBe=false;
            }
            if(mayBe)ans++;
        }
        System.out.println(ans);

    }

    @Override
    public void optimal() {
        int arr[] = new int[26];
        for(char ch: allowed.toCharArray()) arr[ch-'a']++;
        int ans = words.length;
        for(String s: words){
            for(char ch: s.toCharArray()){
                if(arr[ch-'a']==0){
                    ans--;
                    break;
                }
            }
        }
        System.out.println(ans);

    }
}

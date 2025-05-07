package array.easy;

import util.IBaseClass;

import java.util.*;


//leetCode 1002
public class FindCommonCharacters implements IBaseClass {
    public static void main(String[] args) {
        var cls = new FindCommonCharacters();
        cls.better();
    }

    private static final String[] words = {"bella", "label", "roller"};

    @Override
    public void bruteForce() {
        System.out.println("bruteForce");
        Map<Character, Integer> common = new HashMap<>();
        List<String> ans = new ArrayList<>();

        for (char ch : words[0].toCharArray()) common.put(ch, common.getOrDefault(ch, 0) + 1);

        for (int i = 1; i < words.length; i++) {
            Map<Character, Integer> current = new HashMap<>();
            for (char ch : words[i].toCharArray()) current.put(ch, current.getOrDefault(ch, 0) + 1);

            for (char ch : new HashSet<>(common.keySet())) {
                if (current.containsKey(ch)) {
                    common.put(ch, Math.min(common.get(ch), current.get(ch)));
                } else common.remove(ch);
            }
        }
        System.out.println(common);
    }

    @Override
    public void better() {
        System.out.println("better");
        int[] common = new int[26];
        Arrays.fill(common, Integer.MAX_VALUE);

        for (String w : words) {
            int[] current = new int[26];
            for (char ch : w.toCharArray()) {
                current[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                common[i] = Math.min(common[i], current[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (common[i]-- > 0) ans.add(String.valueOf((char) (i + 'a')));
        }
        System.out.println(ans);

    }

    @Override
    public void optimal() {

    }
}

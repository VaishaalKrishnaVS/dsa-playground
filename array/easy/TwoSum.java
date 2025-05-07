package array.easy;

import util.IBaseClass;

import java.util.HashMap;
import java.util.Map;

// leetCode 01
public class TwoSum implements IBaseClass {
    private static int[] arr = {2, 7, 11, 15};
    private static int t = 9;

    public static void main(String[] args) {
        var c = new TwoSum();
        c.bruteForce();
        c.better();
        c.optimal();
    }

    @Override
    public void bruteForce() {
        System.out.println("bruteForce");
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == t) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }

    @Override
    public void better() {
        System.out.println("better");
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) map.put(arr[i], i);
        for (int i = 0; i < n - 1; i++) {
            int r = t - arr[i];
            if (map.containsKey(r) && map.get(r) != i) {
                System.out.println(i + " " + map.get(r));
                return;
            }
        }

    }

    @Override
    public void optimal() {
        System.out.println("optimal");
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int r = t - arr[i];
            if (map.containsKey(r)) {
                System.out.println(i + " " + map.get(r));
                return;
            }
            map.put(arr[i], i);
        }
    }
}

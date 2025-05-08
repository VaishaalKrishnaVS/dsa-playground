package array.easy;

import util.IBaseClass;

import java.util.*;

//leetCode 1122
public class RelativeArraySort implements IBaseClass {
    private static final int arr1[] = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
    private static final int arr2[] = {2, 1, 4, 3, 9, 6};

    public static void main(String[] args) {
        var cls = new RelativeArraySort();
        cls.optimal();
    }

    @Override
    public void bruteForce() {
        var map = new HashMap<Integer, Integer>();
        for (int i : arr1) map.put(i, map.getOrDefault(i, 0) + 1);
        System.out.println(map);

        var ans = new ArrayList<Integer>();
        var rem = new ArrayList<Integer>();

        for (int i : arr2) {
            int v = map.get(i);
            if (map.containsKey(i)) {
                while (v-- > 0) ans.add(i);
                map.remove(i);
            }
        }
        for (int i : map.keySet()) {
            int v = map.get(i);
            while (v-- > 0) rem.add(i);
        }
        var remArr = rem.toArray();
        Arrays.sort(remArr);
        int ansArr[] = new int[arr1.length];
        int c = 0;
        for (int i = 0; i < ans.size(); i++) {
            ansArr[c++] = ans.get(i);
        }
        for (int i = 0; i < remArr.length; i++) {
            ansArr[c++] = (int) remArr[i];
        }
        System.out.println(Arrays.toString(ansArr));
    }

    @Override
    public void better() {
        var tmap = new TreeMap<Integer, Integer>();
        for (int i : arr1) tmap.merge(i, 1, Integer::sum);
        int ans[] = new int[arr1.length];
        int c = 0;
        for (int i : arr2) {
            int v = tmap.get(i);
            while (v-->0) ans[c++]=i;
            tmap.remove(i);
        }
        for(int i: tmap.keySet()) {
            int v =tmap.get(i);
            while (v-->0) ans[c++]=i;
        }
        System.out.println(Arrays.toString(ans));
    }

    @Override
    public void optimal() {
        int map[] = new int[1001];
        for(int i:arr1) map[i]++;
        int ans[] = new int[arr1.length];
        int c =0;
        for(int i: arr2){
            int v = map[i];
            while (v-->0) ans[c++]=i;
            map[i] =0;
        }
        for(int i=0;i<map.length;i++){
            int v = map[i];
            while (v-->0) ans[c++]=i;
        }
        System.out.println(Arrays.toString(ans));
    }
}

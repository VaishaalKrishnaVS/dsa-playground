package inv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencySort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 8, 4, 9, 6, 9, 8, 9, 1};
        var map = new HashMap<Integer,Integer>();
        for(int i:arr)map.merge(i,1,Integer::sum);
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
                (a,b)
                        -> b.getValue()-a.getValue());
        pq.addAll(map.entrySet());
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            Map.Entry<Integer,Integer> entry = pq.poll();
            for(int i=0;i<entry.getValue();i++) {
                ans.add(entry.getKey());
            }
        }
        System.out.println(ans);
    }

    void usingStream(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Arrays
                .stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e -> {
                    for (int i = 0; i < e.getValue(); i++) {
                        list.add(e.getKey());
                    }
                });
        System.out.println(list);
    }
}

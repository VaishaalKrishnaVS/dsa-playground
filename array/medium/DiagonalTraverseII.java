package array.medium;

import util.IBaseClass;

import java.util.*;
//leetCode 1424
public class DiagonalTraverseII implements IBaseClass {
    public static final List<List<Integer>> nums = List.of(
            List.of(1, 2, 3, 4, 5),
            List.of(6, 7),
            List.of(8),
            List.of(9, 10, 11),
            List.of(12, 13, 14, 15, 16));


    public static void main(String[] args) {
        var cls = new DiagonalTraverseII();
        cls.optimal();
    }

    //passed 53/56 testCases :: exceeded timelimit
    @Override
    public void bruteForce() {
        var ans = new ArrayList<Integer>();
        var numsLength = nums.size();
        int max = Integer.MIN_VALUE;
        int maxColIx = 0;
        for (int i = 0; i < numsLength; i++) {
            var temp = i;
            var colLength = nums.get(i).size();
            if (colLength >= max) {
                max = colLength;
                maxColIx = i;
            }
            for (int j = 0; j <= i; j++) {
                if (j < nums.get(temp).size())
                    ans.add(nums.get(temp).get(j));
                temp--;
            }
        }
        var lastRowLength = nums.get(maxColIx).size();
        for (int i = 1; i < lastRowLength; i++) {
            var temp = numsLength - 1;
            var startCol = i;
            while (temp >= 0) {
                if (startCol < nums.get(temp).size())
                    ans.add(nums.get(temp).get(startCol));
                temp--;
                startCol++;
            }
        }
        var ansArr = new int[ans.size()];
        for (int i = 0; i < ansArr.length; i++) ansArr[i] = ans.get(i);
        System.out.println(Arrays.toString(ansArr));
    }

    @Override
    public void better() {
        var map = new TreeMap<Integer,ArrayList<Integer>>();
        int totalElement=0;
        int vSize = nums.size();
        for(int i=vSize-1;i>=0;i--){
            for(int j=nums.get(i).size()-1;j>=0;j--){
                var lis = new ArrayList<Integer>();
                if(map.containsKey(i+j)) lis = map.get(i+j);
                lis.add(nums.get(i).get(j));
                map.put(i+j, lis);
                totalElement++;
            }
        }
        var ans = new int[totalElement];
        var c=0;
        for(var key: map.keySet()){
            var val = map.get(key);
            for (Integer integer : val) {
                ans[c++] = integer;
            }
        }
        System.out.println(Arrays.toString(ans));
    }

    @Override
    public void optimal() {
        var map = new HashMap<Integer, LinkedList<Integer>>();
        int totalSum =0;
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.get(i).size();j++){
                map.computeIfAbsent(i+j, k->new LinkedList<>()).addFirst(nums.get(i).get(j));
                totalSum++;
            }
        }
        var ans = new int[totalSum];
        int c =0;

        for(int i=0; i<map.size();i++){
            for(int n:map.get(i)) ans[c++]=n;
        }
        System.out.println(Arrays.toString(ans));

    }
}

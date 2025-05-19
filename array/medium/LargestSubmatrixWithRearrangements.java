package array.medium;

import util.IIntutuionClass;

import java.util.Arrays;
//leetCode 1727
public class LargestSubmatrixWithRearrangements implements IIntutuionClass {
    public static final int[][] matrix = {{0,0,1},{1,1,1},{1,0,1}};

    public static void main(String[] args) {
        var cls =  new LargestSubmatrixWithRearrangements();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        int ans  =0;
        int[] tempArr = new int[matrix[0].length];
        for(int i=0;i< matrix.length;i++){
            int[] c = new int[tempArr.length];
            for(int j=0;j< matrix[0].length;j++){
                if(matrix[i][j]==0) tempArr[j]=0;
                tempArr[j]+=matrix[i][j];
                c[j]=tempArr[j];
            }
            Arrays.sort(c);
            ans = Math.max(findMax(ans, c),ans);
        }
        System.out.println(ans);
    }
    public static int findMax(int ans, int[] arr){
        int n =arr.length;
        int min = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            ans = Math.max(arr[i]*(n-i), ans);
        }
        return ans;
    }
}

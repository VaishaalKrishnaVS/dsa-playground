package array.easy;

import util.IBaseClass;

import java.util.ArrayList;
import java.util.Arrays;
//leetCode 1380
public class LuckyNumbersInAMatrix implements IBaseClass {
    public static final int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};

    public static void main(String[] args) {
        var cls = new LuckyNumbersInAMatrix();
        cls.optimal();
    }
    @Override
    public void bruteForce() {
        int vArr[] = new int[matrix.length];
        int hArr[] = new int[matrix[0].length];
        int ii=0;
        for(int[] ar:matrix){
            vArr[ii++]=Arrays.stream(ar).min().getAsInt();
        }
        ii=0;
        for(int i = 0;i<matrix[0].length;i++){
            int sm = Integer.MIN_VALUE;
            for(int j =0;j<matrix.length;j++){
                sm = Math.max(sm, matrix[j][i]);
            }
            hArr[ii++] = sm;
        }
        var ans =new ArrayList<Integer>();
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j< matrix[0].length;j++){
                int v = matrix[i][j];
                if(v==vArr[i]&&v==hArr[j])ans.add(v);
            }
        }
        System.out.println(ans);

    }

    @Override
    public void better() {
        int[] vArr = new int[matrix.length];
        int[] hArr = new int[matrix[0].length];
        for(int i =0;i< matrix.length;i++){
            int sm = Integer.MAX_VALUE;
            for(int j=0;j<matrix[0].length;j++){
                sm = Math.min(sm, matrix[i][j]);
                hArr[j] = Math.max(hArr[j], matrix[i][j]);
            }
            vArr[i]=sm;
        }
        var ans =new ArrayList<Integer>();
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j< matrix[0].length;j++){
                int v = matrix[i][j];
                if(v==vArr[i]&&v==hArr[j])ans.add(v);
            }
        }
        System.out.println(ans);
    }

    @Override
    public void optimal() {
        var ans = new ArrayList<Integer>();

        for(int i=0;i<matrix.length;i++){
            int columnIdx=-1;
            int min = Integer.MAX_VALUE;
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]<min){
                    min = matrix[i][j];
                    columnIdx=j;
                }
            }
            boolean mayBe = true;
            for(int j =0;j<matrix.length;j++){
                if(matrix[j][columnIdx]>min) {
                    mayBe = false;
                    break;
                }
            }
            if(mayBe){
                ans.add(min);
            }
        }
        System.out.println(ans);
    }
}

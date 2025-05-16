package array.medium;

import util.IIntutuionClass;

import java.util.ArrayList;
//leetCode 54
public class SpiralMatrix implements IIntutuionClass {
    public static final int[][] matrix =  {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

    public static void main(String[] args) {
        var cls = new SpiralMatrix();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        var list = new ArrayList<Integer>();
        int r=0;
        int c=0;
        int mr= matrix.length-1;
        int mc = matrix[0].length-1;
        int cr =matrix.length* matrix[0].length;
        while (cr>0){
            for(int i=c;i<=mc && cr>0;i++){
                list.add(matrix[r][i]);
                cr--;
            }
            r++;
            for(int i=r;i<=mr&& cr>0;i++){
                list.add(matrix[i][mc]);
                cr--;
            }
            mc--;
            for(int i=mc;i>=c && cr>0;i--){
                list.add(matrix[mr][i]);
                cr--;
            }
            mr--;
            for(int i=mr;i>=r&& cr>0;i--){
                list.add(matrix[i][c]);
                cr--;
            }
            c++;
        }
        System.out.println(list);
    }
}

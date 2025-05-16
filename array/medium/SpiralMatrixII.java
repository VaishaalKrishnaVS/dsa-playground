package array.medium;

import util.IIntutuionClass;

import java.util.Arrays;
//leetCode 59
public class SpiralMatrixII implements IIntutuionClass {
    public static final int n =3;

    public static void main(String[] args) {
        var cls =  new SpiralMatrixII();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        var mat = new int[n][n];
        int t = 1;
        int r=0;
        int c=0;
        int b=n*n;
        int mr = n-1;
        int mc = n-1;
        while(t<=b){
            for(int i=c;i<=mc && t<=b;i++) mat[r][i] = t++;
            r++;
            for(int i=r;i<=mr && t<=b;i++) mat[i][mc] = t++;
            mc--;
            for(int i=mc;i>=c && t<=b;i--) mat[mr][i] = t++;
            mr--;
            for(int i=mr;i>=r && t<=b;i--) mat[i][c] = t++;
            c++;
        }
        System.out.println(Arrays.deepToString(mat));
    }
}

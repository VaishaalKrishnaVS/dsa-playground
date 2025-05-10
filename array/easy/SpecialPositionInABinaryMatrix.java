package array.easy;

import util.IBaseClass;

//leetCode 1582
public class SpecialPositionInABinaryMatrix implements IBaseClass {
    public static final int[][] mat = {{1,0,0},{0,0,1},{1,0,0}};

    public static void main(String[] args) {
        var cls = new SpecialPositionInABinaryMatrix();
        cls.better();
    }
    @Override
    public void better() {
        int r = mat.length;
        var rowArr = new int[r];
        int c = mat[0].length;
        var colArr = new int[c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                rowArr[i]+=mat[i][j];
                colArr[j]+=mat[i][j];
            }
        }

        int ans = 0;
        for(int row = 0; row< r; row++){
            for(int col = 0; col< c; col++){
                if(mat[row][col]!=1)continue;
                if(rowArr[row]==1&&colArr[col]==1)ans++;
            }
        }
        System.out.println(ans);
    }

    @Override
    public void bruteForce() {
        int ans=0;
        for(int row =0; row<mat.length;row++){
            for(int col=0;col<mat[0].length;col++){
                ans+=calc(mat, row, col);
            }
        }
        System.out.println(ans);
    }
    private static int calc(int[][]arr, int r, int c){
        int rs =0;
        for(int i=0;i<arr[0].length;i++) rs+=arr[r][i];
        int cs =0;
        for (int[] ints : arr) cs += ints[c];
        if(rs ==1 && cs ==1 && arr[r][c]==1) return 1;
        return 0;
    }

    @Override
    public void optimal() {

    }
}

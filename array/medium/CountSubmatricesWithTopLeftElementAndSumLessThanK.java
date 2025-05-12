package array.medium;

import util.IIntutuionClass;
//leetCode 3070
public class CountSubmatricesWithTopLeftElementAndSumLessThanK implements IIntutuionClass {
    public static final int[][] grid = {{7,6,3},{6,6,1}};
    public static final int k =18;

    public static void main(String[] args) {
        var cls = new CountSubmatricesWithTopLeftElementAndSumLessThanK();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        var n = grid.length;
        var m = grid[0].length;
        var map = new int[n][m];
        map[0][0] = grid[0][0];

        for(int i=1;i<m;i++){
            map[0][i] = map[0][i-1]+grid[0][i];
        }
        for(int i=1;i<n;i++){
            map[i][0] = map[i-1][0]+ grid[i][0];
        }
        for(int i=1; i<n;i++){
            for(int j=1;j<m;j++){
                map[i][j] = grid[i][j]+map[i][j-1]+map[i-1][j]-map[i-1][j-1];
            }
        }
        int ans = 0;
        for(int[] i:map){
            for(int j:i) {
                if (j <= k) ans++;
            }
        }
        System.out.println(ans);

    }
}

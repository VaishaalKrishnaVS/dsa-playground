package recursion.level02;

import java.util.ArrayList;

public class PartitionInKSubsets {
  public static void main(String[] args) {
    int n = 4;
    int k = 3;
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < k; i++) ans.add(new ArrayList<>());
    solve(ans, 1, n, k, 0);
  }

  private static void solve(ArrayList<ArrayList<Integer>> ans, int i, int n, int k, int sso) {
    if (i > n) {
      if (k == sso) {
        for (var set : ans) {
          System.out.print(set);
        }
        System.out.println();
      }
      return;
    }
    for (int j=0;j<ans.size();j++){
        if(!ans.get(j).isEmpty()){
            ans.get(j).add(i);
            solve(ans, i+1, n, k, sso);
            ans.get(j).removeLast();
        }
        else {
            ans.get(j).add(i);
            solve(ans, i+1, n, k, sso+1);
            ans.get(j).removeLast();
            break;
        }
    }
  }
}

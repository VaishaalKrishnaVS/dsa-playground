package graph.level01;

import java.util.ArrayList;

public class GetConnectedComponents {
  public static void main(String[] args) {
    var v = 7;
    int[][] edges = {{0, 1}, {2, 3}, {4, 5}, {4, 6}, {5, 6}};
    getCC(v, edges);
  }

  private static void getCC(int v, int[][] edges) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<Integer>[] gh = new ArrayList[v];
    for (int i = 0; i < v; i++) gh[i] = new ArrayList<>();
    for (var e : edges) {
      gh[e[0]].add(e[1]);
      gh[e[1]].add(e[0]);
    }
    boolean[] vis = new boolean[v];
    for (int i = 0; i < v; i++) {
      if (!vis[i]) {
        var lis = new ArrayList<Integer>();
        if (!vis[i]) rGCC(gh, i, vis, lis);
        ans.add(lis);
      }
    }
    System.out.println(ans);
  }

  private static void rGCC(ArrayList<Integer>[] gh, int s, boolean[] vis, ArrayList<Integer> lis) {
    vis[s] = true;
    lis.add(s);
    for (var v : gh[s]) {
      if (!vis[v]) {
        rGCC(gh, v, vis, lis);
      }
    }
  }
}

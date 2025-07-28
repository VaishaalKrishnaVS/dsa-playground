package graph.level01;

import java.util.ArrayList;

/**
 * You are given n people and their friendship relationships. Two people can be perfect friends if
 * they are not in the same friend group (connected component). Find the total number of ways to
 * select pairs of perfect friends.
 *
 * <p>Given n people (numbered 0 to n-1) and edges representing friendships, calculate how many
 * pairs of people from different friend groups can be formed.
 */
public class PerfectFriends {
  public static void main(String[] args) {
    var n = 7;
    var edges =
        new int[][] {
          {0, 1},
          {2, 3},
          {4, 5},
          {5, 6},
          {4, 6}
        };
    solve(n, edges);
  }

  private static void solve(int n, int[][] edges) {
    ArrayList<Integer>[] gh = new ArrayList[n];
    for (int i = 0; i < n; i++) gh[i] = new ArrayList<>();
    for (var ed : edges) {
      gh[ed[0]].add(ed[1]);
      gh[ed[1]].add(ed[0]);
    }
    var vis = new boolean[n];
    var flis = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      if (!vis[i]) {
        var temp = new int[1];
        rec(gh, vis, i, temp);
        flis.add(temp[0]);
      }
    }
    System.out.println(flis);
    int ans = 0;
    for (int i = 0; i < flis.size(); i++) {
      for (int j = i + 1; j < flis.size(); j++) {
        ans += flis.get(i) * flis.get(j);
      }
    }
    System.out.println(ans);
  }

  private static void rec(ArrayList<Integer>[] gh, boolean[] vis, int s, int[] temp) {
    vis[s] = true;
    temp[0]++;
    for (var v : gh[s]) {
      if (!vis[v]) {
        rec(gh, vis, v, temp);
      }
    }
  }
}

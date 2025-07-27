package graph.level01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

public class Bipartite {
  public static void main(String[] args) {
    int vertices = 7;
    int[][] edges = {{0, 1}, {0, 3}, {1, 2}, {2, 5}, {3, 4}, {4, 5}, {4, 6}, {5, 6}, {2, 3}};
    solve(vertices, edges);
  }

  private static void solve(int vertices, int[][] edges) {
    HashSet<Integer>[] gh = new HashSet[vertices];
    for (int i = 0; i < vertices; i++) gh[i] = new HashSet<>();
    for (var e : edges) {
      gh[e[0]].add(e[1]);
      gh[e[1]].add(e[0]);
    }
    int[] vis = new int[vertices];
    Arrays.fill(vis, -1);
    for (int i = 0; i < vertices; i++) {
      if (vis[i] != -1) {
        if (!isBipartite(gh, vis, i)) {
          System.out.println(false);
          return;
        }
      }
    }
    System.out.println(true);
  }

  private static boolean isBipartite(HashSet<Integer>[] gh, int[] vis, int i) {
    var q = new ArrayDeque<int[]>();
    q.add(new int[] {i, 0});
    while (!q.isEmpty()) {
      var node = q.poll();
      if (vis[node[0]] != -1) {
        if (vis[node[0]] != node[1]) return false;
      } else vis[node[0]] = node[1];
      for (var n : gh[node[0]]) {
        q.offer(new int[] {n, node[1] + 1});
      }
    }
    return true;
  }
}

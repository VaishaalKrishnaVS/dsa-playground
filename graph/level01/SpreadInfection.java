package graph.level01;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class SpreadInfection {
  public static void main(String[] args) {
    int n = 7;
    int[][] edges = {
      {0, 1},
      {0, 2},
      {1, 3},
      {2, 3},
      {3, 4},
      {4, 5},
      {4, 6}
    };
    solve(n, edges);
  }

  private static void solve(int n, int[][] edges) {
    ArrayList<Integer>[] gh = new ArrayList[n];
    IntStream.range(0, n).forEach(i -> gh[i] = new ArrayList<>());
    Arrays.stream(edges)
        .forEach(
            edge -> {
              gh[edge[0]].add(edge[1]);
              gh[edge[1]].add(edge[0]);
            });
    var vis = new int[n];
    var q = new ArrayDeque<int[]>();
    q.add(new int[] {0, 1});

    while (!q.isEmpty()) {
      var node = q.poll();
      if (vis[node[0]] != 0) continue;
      vis[node[0]] = node[1];
      gh[node[0]].stream()
          .filter(nod -> vis[nod] == 0)
          .forEach(i -> q.offer(new int[] {i, node[1] + 1}));
    }
    System.out.println(Arrays.toString(vis));
  }
}

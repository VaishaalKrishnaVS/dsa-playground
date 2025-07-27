package graph.level01;

import java.util.ArrayDeque;
import java.util.HashSet;

public class CyclicGraph {
  public static void main(String[] args) {
    int vertices = 7;
    int edges[][] = {
      {0, 1},
      {2, 3},
      {4, 5},
      {4, 6},
      {5, 6}
    };
    solve(vertices, edges);
  }

  private static void solve(int vertices, int[][] edges) {
    HashSet<Integer>[] gh = new HashSet[vertices];
    for (int i = 0; i < vertices; i++) {
      gh[i] = new HashSet<>();
    }
    for (int[] edge : edges) {
      gh[edge[0]].add(edge[1]);
      gh[edge[1]].add(edge[0]);
    }
    for (int i = 0; i < vertices; i++) {
      var vis = new HashSet<Integer>();
      if (bfs(gh, vis, i)) {
        System.out.println(true);
        return;
      }
    }
  }

  private static boolean bfs(HashSet<Integer>[] gh, HashSet<Integer> vis, int start) {
      if (vis.contains(start)) return false;
      
      var q = new ArrayDeque<int[]>();
      q.add(new int[]{start, -1});
      vis.add(start);
      
      while (!q.isEmpty()) {
          var curr = q.poll();
          int node = curr[0];
          int parent = curr[1];
          
          for (int neighbor : gh[node]) {
              if (!vis.contains(neighbor)) {
                  vis.add(neighbor);
                  q.add(new int[]{neighbor, node});
              } else if (neighbor != parent) {
                  return true;
              }
          }
      }
      return false;
  }
}

package graph.level01;

import java.util.*;

public class HamiltonianPathAndCycle {
  public static void main(String[] args) {
    int vertices = 7;
    int[][] edges = {{0, 1}, {0, 3}, {1, 2}, {2, 5}, {3, 4}, {4, 5}, {4, 6}, {5, 6}, {2, 3}};
    solve(vertices, edges);
  }

  private static void solve(int v, int[][] edges) {
    List<Integer>[] graph = new ArrayList[v];
    for (int i = 0; i < v; i++) graph[i] = new ArrayList<>();

    for (int[] e : edges) {
      graph[e[0]].add(e[1]);
      graph[e[1]].add(e[0]);
    }

    Set<Integer> visited = new HashSet<>();
    dfs(graph, 0, 0, visited, "0");
  }

  private static void dfs(
      List<Integer>[] graph, int curr, int start, Set<Integer> visited, String path) {
    if (visited.size() == graph.length - 1) {
      if (graph[curr].contains(start)) {
        System.out.println(path + "-" + start + " is Hamiltonian Cycle");
      } else {
        System.out.println(path + " is Hamiltonian Path");
      }
      return;
    }
    visited.add(curr);
    for (int nbr : graph[curr]) {
      if (!visited.contains(nbr)) {
        dfs(graph, nbr, start, visited, path + "-" + nbr);
      }
    }
    visited.remove(curr);
  }
}

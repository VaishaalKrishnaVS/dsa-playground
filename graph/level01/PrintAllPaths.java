package graph.level01;

import java.util.ArrayList;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths
 * from node 0 to node n-1 and return them in any order.
 *
 * <p>The graph is given as follows: graph[i] is a list of all nodes you can visit from node i
 * (i.e., there is a directed edge from node i to node graph[i][j]).
 */
public class PrintAllPaths {
  public static void main(String[] args) {
    /*
     * Visual Graph:
     *     0
     *    / \
     *   1   2
     *   |   |
     *   3---3
     *       |
     *       4
     *      / \
     *     5   6
     */
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
    var source = 0;
    var des = 6;
    printAllPaths(n, edges, source, des);
  }

  private static void printAllPaths(int n, int[][] edges, int source, int des) {
    ArrayList<Integer>[] gh = new ArrayList[n];
    for (int i = 0; i < n; i++) gh[i] = new ArrayList<>();
    for (var e : edges) {
      gh[e[0]].add(e[1]);
      gh[e[1]].add(e[0]);
    }
    var vis = new boolean[n];
    printAllGpPaths(gh, source, des, vis, "");
  }

  private static void printAllGpPaths(
      ArrayList<Integer>[] gh, int source, int des, boolean[] vis, String path) {
    if (source == des) {
      System.out.println(path + des);
      return;
    }
    vis[source] = true;
    for (var ed : gh[source]) {
      if (!vis[ed]) {
        printAllGpPaths(gh, ed, des, vis, path + source);
      }
    }
    vis[source] = false;
  }
}

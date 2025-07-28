package graph.level01;

import java.util.ArrayList;

/**
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1
 * (inclusive). The edges in the graph are represented as a 2D integer array edges, where each
 * edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex
 * pair is connected by at most one edge, and no vertex has an edge to itself.
 *
 * <p>You want to determine if there is a valid path that exists from vertex source to vertex
 * destination.
 *
 * <p>Given edges and the integers n, source, and destination, return true if there is a valid path
 * from source to destination, or false otherwise.
 */
public class HasPath {
  public static void main(String[] args) {
    int n = 3;
    int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
    int source = 0;
    int destination = 2;

    System.out.println(validPath(n, edges, source, destination));
  }

  static class Edge {
    int v1;
    int v2;

    public Edge(int v1, int v2) {
      this.v1 = v1;
      this.v2 = v2;
    }

    @Override
    public String toString() {
      return this.v1 + "->" + this.v2;
    }
  }

  private static boolean validPath(int n, int[][] edges, int source, int destination) {
    ArrayList<Edge>[] gh = new ArrayList[n];
    for (int i = 0; i < n; i++) gh[i] = new ArrayList<>();
    for (var edge : edges) {
      gh[edge[0]].add(new Edge(edge[0], edge[1]));
      gh[edge[1]].add(new Edge(edge[1], edge[0]));
    }
    var vis = new boolean[n];
    return hasPath(gh, source, destination, vis);
  }

  private static boolean hasPath(ArrayList<Edge>[] gh, int source, int destination, boolean[] vis) {
    if (source == destination) return true;
    vis[source] = true;
    for (var lis : gh[source]) {
      if (!vis[lis.v2]) {
        var isPathPresent = hasPath(gh, lis.v2, destination, vis);
        if (isPathPresent) return true;
      }
    }
    return false;
  }
}

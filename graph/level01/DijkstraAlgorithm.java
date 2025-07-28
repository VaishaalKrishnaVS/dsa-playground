package graph.level01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class DijkstraAlgorithm {
  public static void main(String[] args) {
    int n = 7;
    int[][] edges = {
      {0, 1, 10}, {0, 3, 40}, {1, 2, 10}, {2, 3, 10}, {3, 4, 2}, {4, 5, 3}, {4, 6, 8}, {5, 6, 3}
    };
    solve(n, edges);
  }

  private static class Edge {
    int s;
    int d;
    int val;

    public Edge(int s, int d, int val) {
      this.s = s;
      this.d = d;
      this.val = val;
    }
  }

  private static class Node implements Comparable<Node> {
    int s;
    String p;
    int ps;

    public Node(int s, String p, int ps) {
      this.s = s;
      this.p = p;
      this.ps = ps;
    }

    @Override
    public String toString() {
      return "Node{" + "s=" + s + ", p='" + p + '\'' + ", ps=" + ps + '}';
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(this.ps, o.ps);
    }
  }

  private static void solve(int n, int[][] edges) {
    ArrayList<Edge>[] graph = new ArrayList[n];
    IntStream.range(0, n).forEach(i -> graph[i] = new ArrayList<>());
    Arrays.stream(edges)
        .forEach(
            edge -> {
              graph[edge[0]].add(new Edge(edge[0], edge[1], edge[2]));
              graph[edge[1]].add(new Edge(edge[1], edge[0], edge[2]));
            });
    var pq = new PriorityQueue<Node>();
    var vis = new boolean[n];
    pq.add(new Node(0, "0", 0));

    while (!pq.isEmpty()) {
      var node = pq.poll();
      if (vis[node.s]) continue;
      vis[node.s] = true;
      System.out.println(node);
      graph[node.s].stream()
          .filter(nod -> !vis[nod.d])
          .forEach(nod -> pq.offer(new Node(nod.d, node.p + nod.d, node.ps + nod.val)));
    }
  }
}

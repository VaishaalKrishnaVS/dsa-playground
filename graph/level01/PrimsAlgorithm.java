package graph.level01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class PrimsAlgorithm {
  static class Edge {
    int sr;
    int ds;
    int val;

    public Edge(int sr, int ds, int val) {
      this.sr = sr;
      this.ds = ds;
      this.val = val;
    }
  }

  static class Node implements Comparable<Node> {
    int sr;
    int par;
    int val;

    public Node(int sr, int par, int val) {
      this.sr = sr;
      this.par = par;
      this.val = val;
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(this.val, o.val);
    }

    @Override
    public String toString() {
      return "Node{" + "sr=" + sr + ", par=" + par + ", val=" + val + '}';
    }
  }

  public static void main(String[] args) {
    int n = 7;
    int[][] edges = {
      {0, 1, 10}, {0, 3, 40}, {1, 2, 10}, {2, 3, 10}, {3, 4, 2}, {4, 5, 3}, {4, 6, 8}, {5, 6, 3}
    };
    solve(n, edges);
  }

  private static void solve(int n, int[][] edges) {
    ArrayList<Edge>[] gh = new ArrayList[n];
    IntStream.range(0, n).forEach(i -> gh[i] = new ArrayList<>());
    Arrays.stream(edges)
        .forEach(
            edge -> {
              gh[edge[0]].add(new Edge(edge[0], edge[1], edge[2]));
              gh[edge[1]].add(new Edge(edge[1], edge[0], edge[2]));
            });
    var pq = new PriorityQueue<Node>();
    pq.add(new Node(0, -1, 0));
    var vis = new boolean[n];
    while (!pq.isEmpty()) {
      var node = pq.poll();
      if (vis[node.sr]) continue;
      vis[node.sr] = true;
      System.out.println(node);
      gh[node.sr].stream()
          .filter(e -> !vis[e.ds])
          .forEach(e -> pq.add(new Node(e.ds, node.sr, e.val)));
    }
  }
}

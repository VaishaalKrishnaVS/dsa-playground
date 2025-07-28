package graph.level01;

import java.util.ArrayList;
import java.util.Stack;

public class IterativeDFS {
  public static void main(String[] args) {
    int v = 7;
    int[][] edges = {
      {0, 1},
      {0, 2},
      {1, 3},
      {2, 3},
      {3, 4},
      {4, 5},
      {4, 6}
    };
    solve(v, edges);
  }

  private static void solve(int n, int[][] edges) {
    ArrayList<Integer>[] adj = new ArrayList[n];
    for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
    for (var e : edges) {
      adj[e[0]].add(e[1]);
      adj[e[1]].add(e[0]);
    }
    boolean[] visited = new boolean[n];
    var st = new Stack<Integer>();
    st.push(0);
    while (!st.isEmpty()) {
      var node = st.pop();
      if (visited[node]) continue;
      visited[node] = true;
      System.out.println(node);
      for (var e : adj[node]) {
        if (visited[e]) continue;
        st.push(e);
      }
    }
  }
}

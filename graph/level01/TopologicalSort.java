package graph.level01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class TopologicalSort {
  public static void main(String[] args) {
    int n = 7;
    int[][] edges = {
      {0, 1, 10}, {0, 3, 40}, {1, 2, 10}, {2, 3, 10}, {4, 3, 2}, {4, 5, 3}, {4, 6, 8}, {5, 6, 3}
    };
    solve(n, edges);
  }

  private static void solve(int n, int[][] edges) {
    ArrayList<Integer>[] gh = new ArrayList[n];
    IntStream.range(0, n).forEach(i -> gh[i] = new ArrayList<>());
    Arrays.stream(edges).forEach(edge -> gh[edge[0]].add(edge[1]));
    boolean[] vis = new boolean[n];
    var st = new Stack<Integer>();
    for(int i=0;i<n;i++){
        if(!vis[i]) dfs(gh, vis, i, st);
    }
    System.out.println(st);
  }
  private static void dfs(ArrayList<Integer>[] gh, boolean[] vis, int cur, Stack<Integer> st){
      vis[cur]=true;
      for(var node: gh[cur]){
          if(!vis[node]){
              dfs(gh, vis, node, st);
          }
      }
      st.push(cur);
  }
}

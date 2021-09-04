package dfs;

import Adjacency.Nograph;
import graph.Graph;

import java.util.LinkedList;

/** @Author: 云萧YYY @DateTime: 2021/09/04 @Description: 图的深度优先算法 */
public class DepthFirstSearch {

  // 标记图中结点是否被访问到
  private boolean[] marked;
  // 纪录与当前结点连通的结点个数
  private int count;

  /**
   * @param nograph 图对象
   * @param v 开始的结点
   */
  public DepthFirstSearch(Graph graph, int v) {
    this.marked = new boolean[graph.vertex()];
    this.count = 0;
    dfs(graph, v);
  }

  /**
   * 图的深度优先算法
   *
   * @param nograph
   * @param vertex
   */
  private void dfs(Graph graph, int vertex) {

    /** 遍历 vertex 结点 及其子节点 子节点 */
    LinkedList<Integer> adj = graph.adj(vertex);
    for (Integer w : adj) {
      // 该节点没有被遍历
      if (!marked[w]) {
        System.out.print(w + "->");
        marked[w] = true;
        this.count++;
        dfs(graph, w);
      }
    }
  }

  /**
   * 判断 w结点 与顶点是否连通
   *
   * @param w
   * @return
   */
  public boolean mark(int w) {
    return this.marked[w];
  }

  /**
   * 返回图中与顶点连通的个数
   *
   * @return
   */
  public int count() {
    return this.count;
  }
}

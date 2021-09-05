package topology;

import digraph.Digraph;

import java.util.LinkedList;

/** @Author: 云萧YYY @DateTime: 2021/09/05 @Description: 检测一个有向图是否有环 */
public class DirectedCyde {

  /** 是否有环 */
  private boolean isCyde;
  /** 纪录当前结点是否被访问,标记 */
  private boolean[] marked;
  /** 纪录当前结点是否在前面出现 */
  private boolean[] onStack;

  public DirectedCyde(Digraph graph) {

    isCyde = false;

    marked = new boolean[graph.vertex()];

    onStack = new boolean[graph.vertex()];

    for (int i = 0; i < graph.vertex(); i++) {

      // 如果结点没有被访问到那么开始dfs检测
      if (!marked[i] && isCyde == false) {
        dfs(graph, i);
      }
    }
  }

  /**
   * 通过dfs遍历 来检测有向图中是否有环
   *
   * @param graph 有向图
   * @param vertex 开始顶点
   */
  private void dfs(Digraph graph, int vertex) {

    marked[vertex] = true;
    if (onStack[vertex]) {
      isCyde = true;
      return;
    }
    onStack[vertex] = true;
    LinkedList<Integer> adj = graph.adj(vertex);
    for (Integer w : adj) {
      //marked[w] = true;
      dfs(graph, w);
    }
    onStack[vertex] = false;
  }

  public boolean hasCyde() {
    return isCyde;
  }
}

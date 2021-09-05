package topology;

import digraph.Digraph;

import java.util.LinkedList;
import java.util.Stack;

/** @Author: 云萧YYY @DateTime: 2021/09/05 @Description: 顶点排序 ，对无环的拓扑图进行排序 */
public class DepthFirstOrder {

  private boolean[] marked;

  private Stack<Integer> stack;

  public DepthFirstOrder(Digraph digraph) {

    this.marked = new boolean[digraph.vertex()];

    this.stack = new Stack<>();

    /** 对每一个结点都进行排序 */
    for (int i = 0; i < digraph.vertex(); i++) {
      // 结点没有被标记
      if (!marked[i]) {
        dfs(digraph, i);
      }
    }
  }

  private void dfs(Digraph digraph, int v) {

    // 标记当前结点
    marked[v] = true;
    LinkedList<Integer> adj = digraph.adj(v);
    for (Integer w : adj) {
      // 防止遍历到已经遍历的结点
      if (!marked[w]) {
        dfs(digraph, w);
      }
    }
    // 当前结点压栈
    stack.push(v);
  }

    /**
     * 返回当前排序玩的stack
     * @return
     */
  public Stack<Integer> resverPost(){
      return this.stack;
  }
}

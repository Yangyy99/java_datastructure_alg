package bfs;

import graph.Graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/** @Author: 云萧YYY @DateTime: 2021/09/04 @Description: 广度优先遍历 */
public class BreadthFirstSearch {

  // 标记
  private boolean[] marks;
  // count
  private int count;

  public BreadthFirstSearch(Graph graph, int v) {

    marks = new boolean[graph.vertex()];
    count = 0;

    bfs(graph, v);
  }

  private void bfs(Graph graph, int v) {

    if (v > graph.vertex() - 1) {
      throw new IndexOutOfBoundsException("结点越界");
    }
    LinkedList<Integer> adj = graph.adj(v);
    /** 需要一个辅助队列 ，因为对一层遍历 */
    Queue<Integer> queue = new ArrayDeque(graph.vertex());
    /** 先将子节点全部遍历 ，在遍历下一层 */
    for (Integer w : adj) {
      if (!marks[w]) {
        System.out.print(w + "->");
        marks[w] = true;
        count++;
        if (w != v) {
          queue.add(w);
        }
      }
    }
    while (!queue.isEmpty()) {
      bfs(graph, queue.remove());
    }
  }

  public int count() {
    return this.count;
  }
}

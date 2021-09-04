package digraph;

import graph.Graph;

import java.util.LinkedList;

/** @Author: 云萧YYY @DateTime: 2021/09/04 @Description: 有向图 */
public class Digraph implements Graph {

  private final int vertex;
  private int edge;
  private LinkedList<Integer>[] edges;

  public Digraph(int vertex) {

    this.vertex = vertex;
    this.edge = 0;
    this.edges = new LinkedList[vertex()];

    for (int i = 0; i < edges.length; i++) {
        //
        edges[i]=new LinkedList<>();
    }
  }

  @Override
  public int vertex() {
    return this.vertex;
  }

  @Override
  public int edge() {
    return this.edge;
  }

  /**
   * 添加有向关系 v -> w
   *
   * @param v
   * @param w
   */
  public void addEdge(int v, int w) {
    // 将w 添加进v的关系中
    edges[v].add(w);
  }

  public LinkedList<Integer> adj(int v) {
    return edges[v];
  }

  /**
   * 反向图
   *
   * @return
   */
  public Digraph resever() {

    Digraph digraph = new Digraph(vertex);
    // 遍历结点
    for (int v = 0; v < vertex; v++) {
      LinkedList<Integer> adj = adj(v);
      for (Integer p : adj) {
        digraph.addEdge(p, v);
      }
    }
    return digraph;
  }
}

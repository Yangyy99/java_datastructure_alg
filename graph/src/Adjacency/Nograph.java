package Adjacency;

import graph.Graph;

import java.util.LinkedList;

/** @Author: 云萧YYY @DateTime: 2021/09/04 @Description: 无向图,使用临接表来构建图 */
public class Nograph implements Graph {

  // 顶点个数
  private final int v;
  // 边数量
  private int e;
  // 存顶点的数组
   private LinkedList<Integer>[] edges;

  public Nograph(int v) {

    this.v = v;
    this.e = 0;
    // this.edges=new ArrayList<>(v);
    this.edges = new LinkedList[v];
    for (int i = 0; i < edges.length; i++) {
      edges[i] = new LinkedList<Integer>();
      edges[i].add(i);
    }
  }

  /**
   * 返回顶点数量
   *
   * @return
   */
  public int vertex() {
    return v;
  }

  /**
   * 返回边的个数
   * @return
   */
  public int edge() {
    return e;
  }

  /**
   * 添加边关系
   *
   * @param v
   * @param w
   */
  public void addEdge(int v, int w) {

    edges[v].add(w);
    edges[w].add(v);
    this.e++;
  }

  /**
   * 返回该结点所有的连结点
   *
   * @param v
   * @return
   */
  public LinkedList<Integer> adj(int v) {
    return edges[v];
  }
}

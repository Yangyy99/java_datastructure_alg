package graph;

import java.util.LinkedList;

/** @Author: 云萧YYY @DateTime: 2021/09/04 @Description: TODO */
public interface Graph {

   int vertex();

  /**
   * 返回边的个数
   *
   * @return
   */
   int edge();

  /**
   * 添加边关系
   *
   * @param v
   * @param w
   */
   void addEdge(int v, int w);

  /**
   * 返回该结点所有的连结点
   *
   * @param v
   * @return
   */
   LinkedList<Integer> adj(int v);
}

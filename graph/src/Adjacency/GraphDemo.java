package Adjacency;

import bfs.BreadthFirstSearch;

/** @Author: 云萧YYY @DateTime: 2021/09/04 @Description: 实现图，并且通过深度优先遍历dfs 和广度优先遍历 bfs 来遍历这个图 */
public class GraphDemo {

  public static void main(String[] args) {

    Nograph nograph = new Nograph(13);
    nograph.addEdge(0, 5);
    nograph.addEdge(0, 1);
    nograph.addEdge(0, 2);
    nograph.addEdge(0, 6);

    nograph.addEdge(5, 3);
    nograph.addEdge(5, 4);
    nograph.addEdge(3, 4);
    nograph.addEdge(4, 6);

    nograph.addEdge(7, 8);

    nograph.addEdge(9, 10);
    nograph.addEdge(9, 12);
    nograph.addEdge(9, 11);
    nograph.addEdge(11, 12);

    // DepthFirstSearch dfsearch = new DepthFirstSearch(nograph, 0);
    BreadthFirstSearch bfsearch = new BreadthFirstSearch(nograph, 0);
    //    System.out.println("\r\n"+dfsearch.count());
    System.out.println("\r\n" + bfsearch.count());
  }
}

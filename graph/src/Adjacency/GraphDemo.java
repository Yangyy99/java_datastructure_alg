package Adjacency;

import bfs.BreadthFirstSearch;

/** @Author: 云萧YYY @DateTime: 2021/09/04 @Description: 实现图，并且通过深度优先遍历dfs 和广度优先遍历 bfs 来遍历这个图 */
public class GraphDemo {

  public static void main(String[] args) {

    Ungraph ungraph = new Ungraph(13);
    ungraph.addEdge(0, 5);
    ungraph.addEdge(0, 1);
    ungraph.addEdge(0, 2);
    ungraph.addEdge(0, 6);

    ungraph.addEdge(5, 3);
    ungraph.addEdge(5, 4);
    ungraph.addEdge(3, 4);
    ungraph.addEdge(4, 6);

    ungraph.addEdge(7, 8);

    ungraph.addEdge(9, 10);
    ungraph.addEdge(9, 12);
    ungraph.addEdge(9, 11);
    ungraph.addEdge(11, 12);

    // DepthFirstSearch dfsearch = new DepthFirstSearch(ungraph, 0);
    BreadthFirstSearch bfsearch = new BreadthFirstSearch(ungraph, 0);
    //    System.out.println("\r\n"+dfsearch.count());
    System.out.println("\r\n" + bfsearch.count());
  }
}

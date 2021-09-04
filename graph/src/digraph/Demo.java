package digraph;

import bfs.BreadthFirstSearch;

/**
 * @Author: 云萧YYY
 * @DateTime: 2021/09/04
 * @Description: demo
 */
public class Demo {

  public static void main(String[] args) {

      Digraph graph = new Digraph(13);
      graph.addEdge(0, 5);
      graph.addEdge(0, 1);
      graph.addEdge(0, 2);
      graph.addEdge(0, 6);

      graph.addEdge(5, 3);
      graph.addEdge(5, 4);
      graph.addEdge(3, 4);
      graph.addEdge(4, 6);

      graph.addEdge(7, 8);

      graph.addEdge(9, 10);
      graph.addEdge(9, 12);
      graph.addEdge(9, 11);
      graph.addEdge(11, 12);

      BreadthFirstSearch bfs=new BreadthFirstSearch(graph.resever(),5);

      

  }
}

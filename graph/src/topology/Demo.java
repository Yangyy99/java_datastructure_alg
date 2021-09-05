package topology;

import digraph.Digraph;

/** @Author: 云萧YYY @DateTime: 2021/09/05 @Description: TODO */
public class Demo {

  public static void main(String[] args) {

    Digraph digraph = new Digraph(6);

    digraph.addEdge(0, 2);
    digraph.addEdge(0, 3);
    digraph.addEdge(2, 4);
    digraph.addEdge(3, 4);
    digraph.addEdge(4, 5);
    digraph.addEdge(1, 3);

    Topological topological = new Topological(digraph);
    System.out.println(topological.orderList());
  }
}

package topology;

import digraph.Digraph;

import java.util.*;

/** @Author: 云萧YYY @DateTime: 2021/09/05 @Description: 对拓扑图进行排序， */
public class Topological {

  private List<Integer> order;

  private DirectedCyde directedCyde;

  private DepthFirstOrder dfOrder;

  public Topological(Digraph digraph) {
    directedCyde = new DirectedCyde(digraph);
    if (!directedCyde.hasCyde()) {
      dfOrder = new DepthFirstOrder(digraph);
      order = new ArrayList<>();
      Stack<Integer> stack = dfOrder.resverPost();
      while (!stack.isEmpty()) {
        order.add(stack.pop());
      }
    }
  }

  public List<Integer> orderList() {
    return order;
  }
}

package prim;

import java.util.Arrays;

/**
 * @Author: 云萧YYY @DateTime: 2021/09/11 @Description: 普利姆算法 ，，解决修路问题 ,从给定的结点开始，寻找与该结点权值最小的点 ，加入
 * ，然后再通过找这两个结点相连中 权值最小的结点，再加入 ，直到所有的结点都加入 ， 所得到的最小生成子树 ，结点与边的关系为 v（点）=d（边）+1 <br>
 * 此时 生成的最小生成树(最小的无向连通图)权值是最小的
 */
public class PrimCase {

  public static void main(String[] args) {

    char[] data = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    // 10000表示不连通
    int[][] weight =
        new int[][] {
          {10000, 5, 7, 10000, 10000, 10000, 2},
          {5, 10000, 10000, 9, 10000, 10000, 3},
          {7, 10000, 10000, 10000, 8, 10000, 10000},
          {10000, 9, 10000, 10000, 10000, 4, 10000},
          {10000, 10000, 8, 10000, 10000, 5, 4},
          {10000, 10000, 10000, 4, 5, 10000, 6},
          {2, 3, 10000, 10000, 4, 6, 10000},
        };

    MGraph graph = new MGraph(7, data, weight);
    MinTree minTree = new MinTree();

//    minTree.printGraph(graph);
      minTree.minTree(graph,1);
  }
}

/** 最小生成树 ， */
class MinTree {

  public void printGraph(MGraph graph) {

    for (int i = 0; i < graph.weight.length; i++) {
      System.out.println(Arrays.toString(graph.weight[i]));
    }
  }

  public void minTree(MGraph graph, int vertex) {

    // 有一个标记数组，来标记哪些结点被访问过
    int[] visited = new int[graph.vertex];
    // 标记当前结点
    visited[vertex] = 1;
    // 指向标记的结点
    int h1 = -1;
    // 指向未标记的结点
    int h2 = -1;
    // 存放最小的权值
    int minweight = 10000;
    /** 要生成vertex-1 条边 所以要遍历这么多次 */
    for (int k = 1; k < graph.vertex; k++) {

      // 遍历要访问的结点，
      for (int i = 0; i < graph.vertex; i++) {
        // 遍历所有结点 查看是否有适合的结点
        for (int j = 0; j < graph.vertex; j++) {
          /** 将访问的结点与所有周围没有访问的最小权值的边 记录下来 */
          if (visited[i] == 1 && visited[j] == 0 && minweight > graph.weight[i][j]) {
            h1 = i;
            h2 = j;
            minweight = graph.weight[i][j];
          }
        }
      }
      // 遍历了全部结点 找到权值最小的连通边
      System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权:"+graph.weight[h1][h2]);
      visited[h2]=1;
      minweight=10000;
    }
  }
}

/** 图结构 */
class MGraph {
  /** 结点个数 */
  public int vertex;
  /** 结点数据 */
  public char[] data;
  /** 邻接矩阵，相邻之间权重 */
  public int[][] weight;

  public MGraph(int vertex, char[] data, int[][] weight) {
    this.vertex = vertex;
    this.data = data;
    this.weight = weight;
  }
}

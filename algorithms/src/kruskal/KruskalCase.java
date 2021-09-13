package kruskal;

import java.util.Arrays;

/** @Author: 云萧YYY @DateTime: 2021/09/13 @Description: TODO */
public class KruskalCase {

  public static final int INT = Integer.MAX_VALUE;

  public static void main(String[] args) {

    char[] vertex = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
    int[][] weight = {
      {0, 12, INT, INT, INT, 16, 14},
      {12, 0, 10, INT, INT, 7, INT},
      {INT, 10, 0, 3, 5, 6, INT},
      {INT, INT, 3, 0, 4, INT, INT},
      {INT, INT, 5, 4, 0, 2, 8},
      {16, 7, 6, INT, 2, 0, 9},
      {14, INT, INT, INT, 8, 9, 0},
    };

    MGraph graph = new MGraph(vertex, weight);

    System.out.println(Arrays.toString(kruskal(graph)));
  }


  public static EData[] kruskal(MGraph graph){

      // 放置kruskal选择出来的边
      EData[] ret=new EData[graph.edgeCount];
      //纪录每个结点终点位置
      int[] ends=new int[graph.vertex];
      //获取边关系
      EData[] edges = getEdges(graph);

      int index=0;
      sortEdges(edges);

    for (int i = 0; i < edges.length; i++) {

        // 选取边上两个点的索引
        int p1 = getIndex(edges[i].start, graph);
        int p2=getIndex(edges[i].end,graph);

        // 获取两个结点的终点，终点不同说明没有连通
        int m = end(ends, p1);
        int n=end(ends,p2);

        if (m!=n){
            ret[index++]=edges[i];
            // 将终点m放置进去
            ends[m]=n;
        }


    }

    return Arrays.copyOf(ret,index);
  }

  /**
   * 将图中边转化成边对象，
   *
   * @param graph
   * @return 边对象数组
   */
  public static EData[] getEdges(MGraph graph) {

    EData[] edges = new EData[graph.edgeCount];
    int index = 0;
    for (int i = 0; i < graph.weight.length; i++) {
      for (int j = i + 1; j < graph.weight[i].length; j++) {
        if (graph.weight[i][j] != Integer.MAX_VALUE)
          edges[index++] = new EData(graph.data[i], graph.data[j], graph.weight[i][j]);
      }
    }
    return edges;
  }

  /** * 对边进行排序,从小->大 */
  public static void sortEdges(EData[] edges) {

    for (int i = 0; i < edges.length; i++) {
      for (int j = 0; j < edges.length - 1 - i; j++) {
        if (edges[j].weight > edges[j + 1].weight) {
          EData temp = edges[j];
          edges[j] = edges[j + 1];
          edges[j + 1] = temp;
        }
      }
    }
  }

  /**
   * 判断形成回路 ,通过是否有同一个终点来看
   *
   * @param ends 是一个终点数组 ，记录每一个结点的下一个连通结点的索引，标记数组一个
   * @param i 表示结点索引
   * @return 终点索引
   */
  public static int end(int[] ends, int i) {

    while (ends[i] != 0) {
      i = ends[i];
    }
    return i;
  }

  /**
   * 返回一个字符在结点数组中的索引
   *
   * @param ch
   * @param graph
   * @return
   */
  public static int getIndex(char ch, MGraph graph) {

    for (int i = 0; i < graph.data.length; i++) {
      if (graph.data[i] == ch) {
        return i;
      }
    }
    return -1;
  }
}

/** 边的关系 */
class EData {

  public char start;
  public char end;
  public int weight;

  public EData(char start, char end, int weight) {
    this.start = start;
    this.end = end;
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "<" + start + ", " + end + "> weight=" + weight;
  }
}

class MGraph {

  public int vertex;

  public int edgeCount;

  public char[] data;

  public int[][] weight;

  public MGraph(char[] data, int[][] weight) {

    this.vertex = data.length;
    this.data = Arrays.copyOf(data, data.length);
    this.weight = Arrays.copyOf(weight, weight.length);

    for (int i = 0; i < weight.length; i++) {

      for (int j = i + 1; j < weight[i].length; j++) {
        if (weight[i][j] != Integer.MAX_VALUE) this.edgeCount++;
      }
    }
  }

  public void print() {
    for (int i = 0; i < weight.length; i++) {
      System.out.println(Arrays.toString(weight[i]));
    }
  }
}

package dijkstra;

import java.util.Arrays;

/** @Author: 云萧YYY @DateTime: 2021/09/13 @Description: 迪杰斯特拉算法 解决求图中 某一个点 到另一个结点 最短路径 */
public class DijkstraCase {


  public static final int N=65535;

  public static void main(String[] args) {


    char[] data=new char[]{'A','B','C','D','E','F','G'};
    int[][] matrix={
            {N,5,7,N,N,N,2},
            {5,N,N,9,N,N,3},
            {7,N,N,N,8,N,N},
            {N,9,N,N,N,4,N},
            {N,N,8,N,N,5,4},
            {N,N,N,4,5,N,6},
            {2,3,N,N,4,6,N},
    };

    Graph graph=new Graph(data,matrix);
    dijkstra(graph,6);


  }

  public static void dijkstra(Graph graph,int index){

    VisitedVertex vv = new VisitedVertex(graph.data.length, index);
    update(index,graph,vv);

    for (int i=1;i<graph.data.length;i++){
      // 每次选取一个权值最小的结点
      int minIndex = vv.updateArr();
      //更新路径
      update(minIndex,graph,vv);
      //System.out.println(vv.path(graph.data, minIndex));
    }

    for (int j=0;j<graph.data.length;j++){
      System.out.println(graph.data[j]+":"+Arrays.toString(vv.path(graph.data,j)));
    }
    //vv.show();


  }

  /**
   * 更新 前驱结点和dis
   * @param index 当前结点
   * @param graph
   * @param vv
   */
  public static void update(int index,Graph graph,VisitedVertex vv){

    int len=0;
    for (int i = 0; i < graph.matrix[index].length; i++) {

      len=vv.getDis(index)+graph.matrix[index][i];
      //如果初始结点到i 结点的距离 要小于 通过index结点到达初始的结点的话
      if (!vv.isvisited(i)&&len<vv.getDis(i)){
        vv.updateDis(i,len);
        vv.updatePre(i,index);
      }
    }
  }



}

/** 该类存放各个结点的信息 */
class VisitedVertex {

  // 纪录当前结点访问情况，访问过 标记为1
  public int[] already_arr;
  // 到各个结点的最短路径
  public int[] dis;
  // 纪录前驱结点的索引
  public int[] pre_visited;

  /**
   * 初始化
   *
   * @param length 顶点个数
   * @param index 出发顶点对应下标
   */
  public VisitedVertex(int length, int index) {

    already_arr = new int[length];
    dis = new int[length];
    pre_visited = new int[length];
    //给dis 符一个最大默认值
    Arrays.fill(dis, 65535);
    dis[index] = 0;
    already_arr[index] = 1;
  }

  /**
   * index 索引的顶点是否被访问过
   *
   * @param index
   * @return
   */
  public boolean isvisited(int index) {
    return already_arr[index] == 1;
  }

  /**
   * 更新该节点的长度
   * @param index
   * @param len
   */
  public void updateDis(int index, int len) {
    dis[index] = len;
  }

  /**
   * 更新 pre结点
   * @param index
   * @param pre
   */
  public void updatePre(int index,int pre){
    this.pre_visited[pre]=index;
  }

  /**
   * 返回从出发顶点到该节点的距离
   * @param index
   * @return
   */
  public int getDis(int index){
    return dis[index];
  }

  /**
   * 寻找当前的节点中没有被访问过 而且权值最小的
   * @return
   */
  public int updateArr(){

    int min=65535;
    int index=0;
    for (int i = 0; i < already_arr.length; i++) {
      if (already_arr[i]==0&&dis[i]<min){
        index=i;
        min=dis[i];
      }
    }
    already_arr[index]=1;
    return index;
  }


  public char[] path(char[] data,int index){
    char[] path=new char[data.length];
    int i=0;
    while(pre_visited[index]!=0){
      path[i++]=data[pre_visited[index]];
      index=pre_visited[index];
    }
    return i==0?new char[]{'0'}:Arrays.copyOf(path,i);
  }


  public void show(){

    System.out.println(Arrays.toString(already_arr));
    System.out.println(Arrays.toString(pre_visited));
    System.out.println(Arrays.toString(dis));
  }
}

class Graph {

  public char[] data;
  public int[][] matrix;

  public Graph(char[] data, int[][] matrix) {

    this.data = Arrays.copyOf(data, data.length);
    this.matrix = Arrays.copyOf(matrix, matrix.length);
  }
}

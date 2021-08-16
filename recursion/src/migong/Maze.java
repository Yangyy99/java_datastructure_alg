package migong;

/** @Author: 云萧YYY @DateTime: 2021/08/13 @Description: 递归解决迷宫问题 */
public class Maze {

  public static void main(String[] args) {
    // 初始化数组
    int[][] map = new int[8][7];
    // 外围一圈为墙 ，用1表示
    for (int i = 0; i < 7; i++) {
      map[0][i] = 1;
      map[7][i] = 1;
    }
    for (int i = 1; i < 8; i++) {
      map[i][0] = 1;
      map[i][6] = 1;
    }
    // 设置迷宫 挡板，
    map[3][1] = 1;
    map[3][2] = 1;
    map[2][2] = 1;
    map[3][3] = 1;
    map[2][3] = 1;
    printMap(map);
    setway(map, 1, 1);
    System.out.println();
    printMap(map);
  }

  /**
   * 走迷宫，需要走出迷宫的出路，使用递归,寻找通路
   *
   * <p>指定约定：
   *
   * <p>2表示该结点可以走，成功的路线，能走通就设置为2，1表示不能走，即障碍，迷宫的墙3 表示这个结点位置是死路，走不通
   *
   * <p>策略：
   *
   * <p>走到一个位置 按照 从下->右->上->左的方向探路，
   *
   * @param map 传入一个迷宫
   * @param i 起点坐标
   * @param j
   * @return
   */
  public static boolean setway(int[][] map, int i, int j) {

    // 递归出口，当出口可以走通了，说明通路已经找到了
    if (map[6][5] == 2) {
      return true;
    } else {
      // 这个位置没有走过
      if (map[i][j] == 0) {
        // 假设能够走通
        // 将这个结点设置为走过，防止回来
        map[i][j] = 2;
        if (setway(map, i + 1, j)) {
          return true;
        } else if (setway(map, i, j + 1)) {
          return true;
        } else if (setway(map, i - 1, j)) {
          return true;
        } else if (setway(map, i, j - 1)) {
          return true;
        } else {
          // 四个方向都走过了，不通这条路
          map[i][j] = 3;
          return false;
        }
      } else {
        // 该结点不为0 已经走过了
        return false;
      }
    }
  }

  public static void printMap(int[][] map) {

    for (int i = 0; i < map.length; i++) {
      //
      for (int j = 0; j < map[1].length; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }
}

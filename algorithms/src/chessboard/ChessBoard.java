package chessboard;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: 云萧YYY @DateTime: 2021/09/14 @Description:
 * 马踏棋盘问题：国际象棋的棋盘为8*8的方格棋盘。现将”马”放在任意指定的方格中，按照”马”走棋的规则将”马”进行移动<br>
 * (如图所示，如果将空格标成点，就是象棋中的马走“日”字)。要求每个方格只能进入一次，最终使得”马”走遍棋盘的64个方格。<br>
 * 如图所示，任意一个位置，“马”最多有8个方向可以跳动，所以每次都要依据这最多8个方向进行选择。
 */
public class ChessBoard {

  // 棋盘的行
  private static int X;
  // 棋盘的列
  private static int Y;
  // 棋盘
  private static int[][] board;
  // 标记数组 ，用于纪录是否被访问过 ，以及当前棋盘的网格的步数
  private static int[] visvited;
  //
  private static boolean finished;

  public static void main(String[] args) {

    //
    X = 6;
    Y = 6;
    int x = 1; // 从编号1 开始
    int y = 1;
    board = new int[X][Y];
    visvited = new int[X * Y];

    long start = System.currentTimeMillis();
    chessBoard(board, x - 1, y - 1, 1);
    long end = System.currentTimeMillis();

    for (int[] column : board) {
      System.out.println(Arrays.toString(column));
    }

    System.out.println(end - start);
  }

  public static void chessBoard(int[][] board, int x, int y, int step) {

    board[x][y] = step;
    visvited[x * Y + y] = 1;
    ArrayList<Point> points = nextPoints(new Point(x, y));
    // 贪心策略 优先访问下一个结点中可以访问坐标个数最小的 减少回溯次数
    sort(points);
    while (!points.isEmpty()) {
      Point point = points.remove(0);
      // 该坐标位置没有被访问过 才能进入该坐标
      if (visvited[point.x * Y + point.y] == 0) {
        chessBoard(board, point.x, point.y, step + 1);
      }
    }
    /**
     * step <x+y 说明没有走完,不能完成step ，所以需要一个标记表示能不能走完的 这个finished对成功有影响 由于 每个栈帧的step都不同 是局部变量
     * 都不同，而且只有最后一个step是满足跳出条件的 所以 不能根据step 作为退出条件 需要一个全局标记 finished
     */
    if (step < X * Y && !finished) {
      visvited[x * Y + y] = 0;
      // 没有完成这个坐标 应置0
      board[x][y] = 0;
    } else {
      finished = true;
    }
  }

  /**
   * 获取 棋盘可以走的点
   *
   * @param currentPoint
   * @return
   */
  public static ArrayList<Point> nextPoints(Point currentPoint) {

    ArrayList<Point> points = new ArrayList<>();
    int x = currentPoint.x;
    int y = currentPoint.y;
    if (x - 1 >= 0 && y - 2 >= 0) {
      points.add(new Point(x - 1, y - 2));
    }
    if (x - 2 >= 0 && y - 1 >= 0) {
      points.add(new Point(x - 2, y - 1));
    }
    if (x - 2 >= 0 && y + 1 < Y) {
      points.add(new Point(x - 2, y + 1));
    }
    if (x - 1 >= 0 && y + 2 < Y) {
      points.add(new Point(x - 1, y + 2));
    }
    if (x + 1 < X && y - 2 >= 0) {
      points.add(new Point(x + 1, y - 2));
    }
    if (x + 2 < X && y - 1 >= 0) {
      points.add(new Point(x + 2, y - 1));
    }
    if (x + 2 < X && y + 1 < Y) {
      points.add(new Point(x + 2, y + 1));
    }
    if (x + 1 < X && y + 2 < Y) {
      points.add(new Point(x + 1, y + 2));
    }
    return points;
  }

  /**
   * 非递减排序 按照该节点的下一次可以跳到坐标个数 从小到大排
   *
   * @param points
   */
  public static void sort(ArrayList<Point> points) {

    points.sort(
        new Comparator<Point>() {
          @Override
          public int compare(Point o1, Point o2) {

            int p1 = nextPoints(o1).size();
            int p2 = nextPoints(o2).size();
            return p1 - p2;
          }
        });

  }

}

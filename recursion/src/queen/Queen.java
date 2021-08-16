package queen;

/** @Author: 云萧YYY @DateTime: 2021/08/14 @Description: 回溯法解决八皇后问题 */
public class Queen {

  private int max = 8;
  /** array 是这样子的一个数组 {0，4，7，5，2，6，1，3} ，此时这个数组的i表示棋盘的行 */
  private int[] array = new int[max];

  public static void main(String[] args) {
    //
    Queen queen = new Queen();
    // 从第一个皇后开始寻找
    queen.check(0);
  }

  /**
   * *
   *
   * @param n 1.第几个皇后表示，当前的皇后是第几个
   */
  public void check(int n) {

    // 如果是第九个皇后那么我就结束
    if (n == 8) {
      printArray();
      return;
    }
    /** 循环棋盘的每一行 */
    for (int i = 0; i < 8; i++) {
      /** 将第n个皇后的位置记录下来，放入数组，看看是否发生冲突 */
      array[n] = i;
      /** 如果这一个皇后放着不会产生冲突 ，那么看下一皇后 */
      if (judge(n)) {
        check(n + 1);
      }
    }
  }

  /**
   * * 判断这个皇后是否可以放在这个棋盘上的这个位置
   *
   * @param n 第几个皇后
   * @return
   */
  public boolean judge(int n) {
    // 由于每个皇后在棋盘上的每一行只能放一个，
    for (int i = 0; i < n; i++) {
      // 判断 是否在同一列上 和对角线上
      if (array[i] == array[n] || Math.abs(i - n) == Math.abs(array[i] - array[n])) {
        return false;
      }
    }
    return true;
  }

  public void printArray() {
    for (int i = 0; i < array.length; i++) {
      //
      System.out.print(array[i] + ",");
    }
    System.out.println();
  }
}

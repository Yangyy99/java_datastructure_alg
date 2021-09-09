package hannoitower;

/** @Author: 云萧YYY @DateTime: 2021/09/06 @Description: 汉诺塔问题 */
public class HannoiTower {

  public static void main(String[] args) {
    //
    tower(3, 'a', 'b', 'c');
  }

  /**
   * 汉诺塔问题<br>
   * 将汉诺塔从 a->c <br>
   * 这是个递归问题 ，分治思想，我们将汉诺塔的层数分为两部分:<br>
   * 1. 第一个部分，最后一层上面的部分为A <br>
   * 2.第二个部分，最后一层为B <br>
   * 过程： A->b ,B->c ,A->c的过程
   *
   * @param num 汉诺塔的层数
   * @param a 原位置
   * @param b 中间辅助位置
   * @param c 目标位置
   */
  public static void tower(int num, char a, char b, char c) {
    /** 汉诺塔就一层 ，那么直接从a->c 即可 */
    if (num == 1) {
      System.out.println("第" + num + "层 " + a + "->" + c);
      return;
    }
    /** 大于一层 那么 我们将除去最后一层的移动到b柱，最下层移动到c柱，最后再将b柱上的移动会c柱 */
    tower(num - 1, a, c, b);
    // 最后一层 移动到c柱
    System.out.println("第" + num + "层 " + a + "->" + c);
    tower(num - 1, b, a, c);
  }
}

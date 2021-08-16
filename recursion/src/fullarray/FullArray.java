package fullarray;

/** @Author: 云萧YYY @DateTime: 2021/08/15 @Description: 全排列问题 */
public class FullArray {

  private int[] array = new int[3];


  public static void main(String[] args) {

    FullArray fullArray = new FullArray();
    fullArray.fun(0);
  }

  public void fun(int n) {

    // 遍历次数
    if (n == 3) {
      printArray();
      return;
    }
    //每一行
    for (int i = 0; i < 3; i++) {
      // 往数组中存元素
      array[n] = i + 1;
      if (isRepeat(n)) {
        fun(n + 1);
      }
    }
  }

  /**
   * 判断是否选取了重复的元素 深度优先遍历的条件 哪些不遍历
   *
   * @param n
   * @return
   */
  public boolean isRepeat(int n) {
    for (int i = 0; i < n; i++) {
      //
      if (array[i] == array[n]) {
        return false;
      }
    }
    return true;
  }

  public void printArray() {
      StringBuffer sb=new StringBuffer();
    for (int i = 0; i < array.length; i++) {
      //
       // sb.append(array[i]);
      System.out.print(array[i] + ",");
    }
    System.out.println();
  }
}

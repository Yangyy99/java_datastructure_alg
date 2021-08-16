import java.util.Arrays;

/** @Author: 云萧YYY @DateTime: 2021/08/16 @Description: 冒泡排序法 时间复杂度 n^2 */
public class BubbleSort {
  public static void main(String[] args) {
    //
    int[] arrays = {3, 9, -1, 10, -2};
    boolean flag = true;
    int temp = 0;
    for (int i = 0; i < arrays.length - 1; i++) {
      // 相互交换
      for (int j = 0; j < arrays.length - 1 - i; j++) {
        /** 大数往后排 */
        if (arrays[j] > arrays[j + 1]) {
          flag = false;
          temp = arrays[j];
          arrays[j] = arrays[j + 1];
          arrays[j + 1] = temp;
        }
      }
      // 如果发现一趟交换完之后，没有发生元素间的交换 那么说明该数组已经是有序的了
      if (flag) {
        break;
      } else {
        // 重置标记，
        flag = true;
      }
    }
    System.out.println(Arrays.toString(arrays));
  }
}

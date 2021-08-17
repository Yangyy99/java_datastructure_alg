import java.util.Arrays;

/** @Author: 云萧YYY @DateTime: 2021/08/16 @Description: 希尔排序，也叫做缩小增量排序，分组 然后对每个组进行插入排序 */
public class ShellSort {

  public static void main(String[] args) {
    //
      int[] arr={3, 9, -1, 10, 8, -2};
      shellSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void shellSort(int[] arr) {

    // 分组排序的次数，gap 为步长
    for (int gap = arr.length / 2; gap > 0; gap /= 2) {
      // 对分组的每一个组进行插入排序
      for (int i = gap; i < arr.length; i++) {
        // 插入位置
        int index = i;
        // 插入值
        int value = arr[i];
        // 只有当前插入值小于前一个位置时 才进行插入
        if (arr[i] < arr[i - gap]) {
          while (index - gap >= 0 && value < arr[index - gap]) {
            arr[index] = arr[index - gap];
            index -= gap;
          }
          // 将value 插入进去
          arr[index]=value;
        }
      }
    }
  }
}

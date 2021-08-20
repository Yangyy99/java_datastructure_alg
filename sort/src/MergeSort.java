import java.util.Arrays;

/** @Author: 云萧YYY @DateTime: 2021/08/19 @Description: 归并排序 */
public class MergeSort {

  public static void main(String[] args) {
    //
    int[] arr = {
      1, 4, 7, 8, 3, 6
    };
    sort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  /**
   * * 归并排序
   *
   * @param arr
   * @param leftBound 左边界
   * @param rightBound 有边界
   */
  public static void sort(int[] arr, int leftBound, int rightBound) {

    // 只有一个元素
    if (leftBound == rightBound) {
      return;
    }
    if (leftBound > rightBound || leftBound < 0 || rightBound < 0) {
      throw new RuntimeException("边界异常");
    }
    // 中间分开
    int mid = leftBound + (rightBound - leftBound) / 2;
    // 左边排序
    sort(arr, leftBound, mid);
    // 右边排序
    sort(arr, mid + 1, rightBound);
    // 合并,
    merge(arr, leftBound, mid + 1, rightBound);
  }

  /**
   * 两个数组合并
   *
   * <p>默认从小到大
   *
   * @param arr 排序的数组
   * @param leftPtr 左指针
   * @param rightPtr 右指针
   * @param rightBound 右边界
   */
  public static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound) {

    // 临时辅助数组,存放合并完的数组
    int[] temp = new int[rightBound - leftPtr + 1];

    int i = leftPtr;
    int j = rightPtr;
    int k = 0;
    while (i < rightPtr && j <= rightBound) {

      temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
    }
    while (i < rightPtr) temp[k++] = arr[i++];
    while (j <= rightBound) temp[k++] = arr[j++];

    for (int m = 0; m < temp.length; m++) {
      arr[leftPtr + m] = temp[m];
    }
  }
}

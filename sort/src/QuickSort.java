import java.util.Arrays;

/** @Author: 云萧YYY @DateTime: 2021/08/17 @Description: 快速排序 */
public class QuickSort {

  public static void main(String[] args) {
    //

    int[] arr = {3, 9, -1, 10, 21, -2};
    quickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
    Arrays.sort(arr);
  }

  public static void quickSort(int[] array, int leftBound, int rightBound) {
    if (leftBound >= rightBound) {
      return;
    }
    //先分区
    int mid = partition(array, leftBound, rightBound);
    // 排序左边
    quickSort(array, leftBound, mid - 1);
    // 排序右边
    quickSort(array, mid + 1, rightBound);
  }

  /**
   * 分区返回中轴位置
   *
   * @param array
   * @param leftBound 分区左边界
   * @param rightBound 分区有边界
   * @return 返回轴的位置
   */
  public static int partition(int[] array, int leftBound, int rightBound) {
    // 选取最后一个元素为轴
    int pivot = array[rightBound];
    int left = leftBound;
    int right = rightBound - 1;

    while (left <= right) {
      while (left <= right && array[left] <= pivot) left++;
      while (left <= right && array[right] > pivot) right--;
      if (left < right) {
        // 将轴两边的交换
        swap(array, left, right);
      }
    }
    swap(array, left, rightBound);
    return left;
  }

  /**
   * 左右交换
   *
   * @param array
   * @param l
   * @param r
   */
  public static void swap(int[] array, int l, int r) {

    int temp = array[l];
    array[l] = array[r];
    array[r] = temp;
  }
}

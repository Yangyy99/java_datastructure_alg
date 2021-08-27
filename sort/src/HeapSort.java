import java.util.Arrays;

/** @Author: 云萧YYY @DateTime: 2021/08/27 @Description: 堆排序,大顶堆为升序，小顶堆为降序 */
public class HeapSort {

  public static void main(String[] args) {
    //
    int[] arr = {2, 1, 3, 9};
    heapSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  /**
   * 大顶堆 升序排列
   *
   * @param arr
   */
  public static void heapSort(int[] arr) {

    // 将整个树 转化成大顶堆树
    for (int j = arr.length / 2 - 1; j >= 0; j--) {
      turnToArrTree(arr, j, arr.length);
    }
    // 此时数组第一个结点就是最大的数，
    for (int k = arr.length - 1; k > 0; k--) {
      // 将最大元素放到最后
      swap(arr, 0, k);
      turnToArrTree(arr, 0, k);
    }
  }

  /**
   * 将一个数组转化成大顶堆的顺序存储二叉树 将数组中的某一个非叶子结点 转换成大顶堆的子树
   *
   * @param arr
   * @param i 调整第i非叶子结点的结点
   * @param len 结点个数
   */
  public static void turnToArrTree(int[] arr, int i, int len) {
    int temp = arr[i];
    // 从i结点后的左节点开始，将最大的元素放入该节点
    for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {
      // 如果有右子树,那么得看下右边结点是否大于左边结点
      if ((k + 1) < len && arr[k] < arr[k + 1]) {
        k++;
      }
      if (temp < arr[k]) {
        // 将大元素放入堆顶
        arr[i] = arr[k];
        // 记录这交换的索引
        i = k;
      } else {
        break;
      }
    }
    arr[i] = temp;
  }

  /**
   * 交换
   *
   * @param arr
   * @param i 第i个索引位置元素
   * @param j 第j个索引位置元素
   */
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}

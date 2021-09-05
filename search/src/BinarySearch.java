/** @Author: 云萧YYY @DateTime: 2021/08/21 @Description: 二分查找，但是只能针对有序序列 */
public class BinarySearch {

  public static void main(String[] args) {
    //
    int[] arr = {3, 14, 53, 214, 542, 748};

    int val = bisear(arr, 0, arr.length - 1, 748);
    System.out.println(val);
  }

  /**
   * 递归方式进行二分查找 <br>
   * 查找某个数据，若存在 则返回索引，不存在则返回-1
   *
   * @param array 查找的数组位置
   * @param leftBound 左边界
   * @param rightBound 有边界
   * @param findVal 查找的值
   * @return 返回所在位置索引
   */
  public static int bisearch(int[] array, int leftBound, int rightBound, int findVal) {

    if (findVal < array[leftBound] || findVal > array[rightBound]) {
      return -1;
    }
    if (leftBound == rightBound) {
      return array[leftBound] == findVal ? leftBound : -1;
    }

    /** 中间位置 */
    int mid = leftBound + (rightBound - leftBound) >> 1;
    if (findVal < array[mid]) {
      /** 往左递归 */
      return bisearch(array, leftBound, mid - 1, findVal);
    } else if (findVal > array[mid]) {
      return bisearch(array, mid + 1, rightBound, findVal);
    } else {
      return mid;
    }
  }

  /**
   * * 通过非递归方式完成二分查找
   *
   * @param array
   * @param leftBound 左边界
   * @param rightBound 有边界
   * @param findVal 索要查找的val
   * @return 返回第一个位置所在的索引,查找不到则返回-1
   */
  public static int bisear(int[] array, int leftBound, int rightBound, int findVal) {

    if (findVal < array[leftBound] || findVal > array[rightBound]) {
      return -1;
    }
    int left = leftBound;
    int right = rightBound;

    int mid = left + (right - left) >> 1;

    while (left <= right) {
      // 如果大于 说明val在左边
      if (array[mid] > findVal) {
        right = mid - 1;
      } else if (array[mid] < findVal) {
        left = mid + 1;
      } else {
        return mid;
      }
      mid = left + (right - left) >> 1;
    }
    return -1;
  }
}

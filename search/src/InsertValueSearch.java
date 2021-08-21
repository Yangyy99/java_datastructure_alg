/** @Author: 云萧YYY @DateTime: 2021/08/21 @Description: 插值查找 --》二分查找的优化，也是用于已经排序好的序列中来查找要寻找的value */
public class InsertValueSearch {

  public static void main(String[] args) {
    //
    int[] arr = {3, 14, 53, 214, 542, 748};
    int i = insertValueSearch(arr, 0, arr.length - 1, 758);
    System.out.println(i);
  }

  /**
   * 优化的二分查找，原来的1/2系数 优化->(findVal-arr[leftBound])/(arr[rightBound]-arr[leftBound])
   *
   * @param arr
   * @param leftBound
   * @param rightBound
   * @param findVal
   * @return 返回第一个位置所在的索引,查找不到则返回-1
   */
  public static int insertValueSearch(int[] arr, int leftBound, int rightBound, int findVal) {

    if (leftBound == rightBound) {
      return arr[leftBound] == findVal ? leftBound : -1;
    }

    // 每次比较的位置
    int insertIndex =
        leftBound
            + (findVal - arr[leftBound])
                / (arr[rightBound] - arr[leftBound])
                * (rightBound - leftBound);
    /**
     * 由于每次查询的索引位置与所要查找的值有关系，故需要判断防止越界溢出 <br>
     * 该系数>1 所得到的insertIndex>rightBound <br>
     * 该系数<2 所得到的insertIndex<leftBound
     */
    if (insertIndex > rightBound || insertIndex < leftBound) {
      return -1;
    }
    if (arr[insertIndex] > findVal) {
      return insertValueSearch(arr, leftBound, insertIndex - 1, findVal);
    } else if (arr[insertIndex] < findVal) {
      return insertValueSearch(arr, insertIndex + 1, rightBound, findVal);
    } else {
      return insertIndex;
    }
  }
}

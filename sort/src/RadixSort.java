import java.util.Arrays;

/** @Author: 云萧YYY @DateTime: 2021/08/20 @Description: 基数排序 桶排序 */
public class RadixSort {

  public static void main(String[] args) {
    //
    int[] arr = {53, 3, 542, 748, 14, 214};
    radixSort(arr);


    System.out.println(Arrays.toString(arr));
  }

  /**
   * 基数排序
   *
   * @param arr
   */
  public static void radixSort(int[] arr) {

    /** 获取位数 */
    int digit = arrMaxDigit(arr);

    /** 计数的数组 */
    int[] count = new int[10];
    /** 存放一次排序的结果 */
    int[] result = new int[arr.length];

    /** 每一次循环都是一次计数排序 */
    for (int i = 0; i < digit; i++) {

      /** 除去的位数 */
      int div = (int) Math.pow(10, i);

      for (int j = 0; j < arr.length; j++) {
        /** 每一位的值 个位-> 十位->百位.... */
        count[arr[j] / div % 10]++;
      }

      for (int m = 1; m < count.length; m++) {
        count[m] = count[m - 1] + count[m];
      }

      /** 排序还原数组 */
      for (int k = arr.length - 1; k >= 0; k--) {
        result[--count[arr[k] / div % 10]] = arr[k];
      }

      System.arraycopy(result, 0, arr, 0, result.length);
      /** 重置count数组 */
      Arrays.fill(count, 0);
    }
  }

  /**
   * * 返回数组中 最大的位数
   *
   * @param arr
   * @return
   */
  private static int arrMaxDigit(int[] arr) {

    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return (max + "").length();
  }
}

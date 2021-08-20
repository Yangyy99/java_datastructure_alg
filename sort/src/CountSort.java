import java.util.Arrays;

/** @Author: 云萧YYY @DateTime: 2021/08/20 @Description: 计数排序，适合于量大但范围较少的情况 */
public class CountSort {

  public static void main(String[] args) {
    //
    int[] arr = {12, 10, 12, 13, 15, 19, 20};
    int[] sort = countSort(arr);
    System.out.println(Arrays.toString(sort));
  }

  public static int[] countSort(int[] arr) {

    // 分配桶，分配一个范围的桶 排序的范围为10-20
    int[] count = new int[11];
    //
    int[] result = new int[arr.length];

    // 遍历arr，桶里计数
    for (int i = 0; i < arr.length; i++) {
      // 计数
      count[arr[i] - 10]++;
    }
    /** 为了排序的稳定性 */
    for (int j = 1; j < count.length; j++) {
      count[j] = count[j - 1] + count[j];
    }
    /**
     * 逆序遍历arr
     *  <p> 遍历之后相同的元素仍然可以保持的原有的相对位置不变，增加稳定性
     *
     */
    for (int k = arr.length - 1; k >= 0; k--) {
      result[--count[arr[k] - 10]] = arr[k];
    }

    // 排序还原桶
    //    for (int i = 0; i < count.length; i++) {
    //      //
    //      for (int j = 0; j < count[i]; j++) {
    //        //
    //        result[index++] = 10 + i;
    //      }
    //    }
    return result;
  }
}

import java.util.Arrays;

/** @Author: 云萧YYY @DateTime: 2021/08/16 @Description: 选择排序 */
public class SelectSort {
  public static void main(String[] args) {
    //
    int[] arrays = {3, 9, -1, 10, -2};
    selectSort(arrays);
    System.out.println(Arrays.toString(arrays));
  }


  public static void selectSort(int[] arrays){
    for (int i = 0; i < arrays.length; i++) {
      //
      int minIndex = i; // 最小数的索引，擂台法
      for (int j = i + 1; j < arrays.length; j++) {
        //
        if (arrays[minIndex] > arrays[j]) {
          // 指向最小元素的指针
          minIndex = j;
        }
      }
      // 当当前元素就是最小的元素时，不发生交换
      if (minIndex != i) {
        int temp = arrays[i];
        arrays[i] = arrays[minIndex];
        arrays[minIndex] = temp;
      }
    }
  }
}

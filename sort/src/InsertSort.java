import java.util.Arrays;

/** @Author: 云萧YYY @DateTime: 2021/08/16 @Description: 插入排序 */
public class InsertSort {

  public static void main(String[] args) {

    int[] arrays = {3, 9, -1, 10, 8, -2};
    insertSort(arrays);
    System.out.println(Arrays.toString(arrays));
  }
  /**
   * 插入排序
   * @param arrays 要排序的数组
   */
  public static void insertSort(int[] arrays){

    int insertValue = 0;
    int insertIndex = 0;
    for (int i = 1; i < arrays.length; i++) {
      // 表示要插入的值
      insertValue = arrays[i];
      // 插入的索引位置
      insertIndex = i;
      // 条件判断，当插入的元素小于插入位置之前的元素 ，那么将插入位置之前的元素后移
      while (insertIndex > 0 && arrays[insertIndex - 1] > insertValue) {
        // 将前一个位置元素后移
        arrays[insertIndex] = arrays[insertIndex - 1];
        insertIndex--;
      }
      // 插入元素
      arrays[insertIndex] = insertValue;
    }

  }
}

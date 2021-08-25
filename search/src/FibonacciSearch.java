import java.util.Arrays;

/** @Author: 云萧YYY @DateTime: 2021/08/22 @Description: 斐波那契查找算法 ,需要在一个有序数组中*/
public class FibonacciSearch {

  public static void main(String[] args) {
    //
    int[] arr = {3, 14, 53, 214, 542, 748};
    int value = fibSearch(arr, 3);
    System.out.println(value);
  }

  /**
   * 非递归方式<br>
   * 关键在于寻找mid位置 通过斐波那契数列可以得到 F(k)-1=[F(k-1)-1]+1+[F(k-2)-1] 此时中间1位置就是我们需要的位置<br>
   * 所以索引mid=leftBound +F（k-1）-1 黄金分割点
   *
   * @param arr
   * @param findVal 查找的值
   * @return 若存在返回第一个索引位置 否则 返回-1
   */
  public static int fibSearch(int[] arr, int findVal) {
    int left = 0;
    int right = arr.length - 1;
    int mid = 0;
    int k = 0;
    // 找到一个k值 对应的斐波那契的位值接近数组长度
    while (right > fibonacci(k)-1) {
      k++;
    }
    // 如果k>arr.length 那么需要对数组扩容至f(k)的长度,因为构建的数组就是斐波那契长度的数组
    int[] temp = Arrays.copyOf(arr, fibonacci(k));
    if (fibonacci(k) > arr.length) {
      // 对后面扩容的位置初始化成arr数组最后位置的值，因为涉及比较
      for (int i = arr.length; i < temp.length; i++) {
        temp[i] = arr[right];
      }
    }
    // 获取mid值
    while (left <= right) {
      // 获取黄金分割点
      mid = left + fibonacci(k - 1) - 1;
      if (temp[mid] > findVal) {
        right = mid - 1;
        // f(k-1)=f(k-1-1)+f(k-1-2)
        k--;
      } else if (temp[mid] < findVal) {
        // 右边分区
        left = mid + 1;
        k -= 2;
      } else {
        //可能会超出原数组返回索引需要更正
        if (mid<=right){
          return mid;
        }else{
          return right;
        }
      }
    }
    return -1;
  }
  /**
   * 获取第n位斐波那契的数字
   *
   * @param n
   * @return
   */
  public static int fibonacci(int n) {
    if (n <= 2) {
      return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}

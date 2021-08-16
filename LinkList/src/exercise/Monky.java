package exercise;

import javafx.scene.SnapshotParameters;

import java.lang.reflect.Array;
import java.util.*;

/** @Author: 云萧YYY @DateTime: 2021/08/03 @Description: 猴子偷桃问题 */
public class Monky {

  public static int taozi(int day) {
    if (day == 1) {
      return 1;
    }
    return (taozi(day - 1) + 1) * 2;
  }

  public static int age(int count) {
    if (count == 1) {
      return 10;
    }
    return age(count - 1) + 2;
  }

  public static int daffodilCount(int count) {
    int sum = 0;
    for (int i = 100; i <= count; i++) {

      // 个位数
      int a = i % 10;
      // 十位
      int b = i / 10 % 10;
      // 百位
      int c = i / 100;
      if (i == (a * a * a + b * b * b + c * c * c)) {
        sum++;
      }
    }

//    Scanner in =new Scanner(System.in);
//    Set set =new HashSet();
//    for (int i = 0; i < 10; i++) {
//      //
//      int i1 = in.nextInt();
//      set.add(i1);
//    }
//    Object[] objects = set.toArray();
//    Arrays.sort(objects);
    return sum;
  }

  public static List<Integer> finshCount(int count) {
    List<Integer> list = new ArrayList<>();
    for (int i = 2; i <= count; i++) {
      //
      int factors = 0;
      for (int j = 1; j < i; j++) {
        // 获取因子数和
        if (i % j == 0) {
          factors += j;
        }
      }
      if (factors == i) {
        list.add(i);
      }
    }
    return list;
  }

  /**
   * * 1,2,3,4 四个数如何组合
   *
   * @return
   */
  public static int number() {
    long begin = System.currentTimeMillis();
    int[] array = new int[] {1, 2, 3, 4};
    int count = 0;
    for (int i = 0; i < array.length; i++) {
      //
      for (int j = 0; j < array.length; j++) {
        //
        for (int z = 0; z < array.length; z++) {
          if (array[i] != array[j] && array[i] != array[z] && array[j] != array[z]) {
            if (count % 6 == 0) {
              System.out.println();
            }
            System.out.print("" + array[i] + array[j] + array[z] + ",");
            count++;
          }
        }
      }
    }
    long end = System.currentTimeMillis();
    System.out.println("\r\n" + (end - begin));
    return count;
  }

  public static int permutations(int source, int target) {
    int result = 1;
    for (int i = 0; i < target; i++) {
      result *= source - i;
    }
    return result;
  }

  public static void number2() {
    long l = System.currentTimeMillis();
    int num = 0;
    for (int i = 1; i <= 4; i++) {
      for (int j = 1; j <= 4; j++) {
        for (int k = 1; k <= 4; k++) {
          if (i != j && i != k && j != k) {
            System.out.print(i + "" + j + "" + k + "\t");
            num++;
          }
        }
      }
      System.out.println();
    }
    System.out.println("一个有" + num + "个");
    long l2 = System.currentTimeMillis();
    System.out.println(l2 - l);
  }

  public static void main(String[] args) {
    //
    //    int count = taozi(10);
    //    System.out.println(count);
    //
    //    int age = age(14);
    //    System.out.println(age);
    //     int i = daffodilCount(2000);
    //     System.out.println(i);
    //    List<Integer> single = finshCount(1000);
    //    System.out.println(single);
    int number = number();
    System.out.println("\r\n" + number);
    //    System.out.println(permutations(4,3));

    System.out.println();
    number2();


  }
}

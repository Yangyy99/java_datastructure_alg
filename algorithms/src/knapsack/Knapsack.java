package knapsack;

import java.util.HashMap;
import java.util.Map;

/** @Author: 云萧YYY @DateTime: 2021/09/06 @Description: 01背包问题 */
public class Knapsack {

  public static void main(String[] args) {
    String[] shop = {"吉他", "音响", "电脑"};
    Double[] price = {1500.0, 3000.0, 2000.0};
    int[] weight = {1, 4, 3};
    Map<String, Double> map = knapsack(shop, price, weight, 4);
    for (Map.Entry<String, Double> entry : map.entrySet()) {
      System.out.println(entry.getKey() + ":" + entry.getValue());
    }
  }

  /**
   * @param shop 商品的名称
   * @param v 与商品对应的价格
   * @param p 背包的容量
   * @return 返回背包装的东西
   */
  public static Map<String, Double> knapsack(String[] shop, Double[] price, int[] weight, int p) {

    if (shop == null || shop.length < 1 || price == null || price.length < 1 || p < 0) {
      throw new RuntimeException("参数错误");
    }

    Map<String, Double> map = new HashMap<>();
    /** 动态规划的表,记录当前背包能够放的最大价值 */
    double[][] val = new double[shop.length + 1][p + 1];
    /** 记录放入背包物品的路径 */
    int[][] path = new int[shop.length + 1][p + 1];
    /** 从1 开始遍历二维数组这张表，因为第一行 ，第一列都为0 */
    for (int i = 1; i < val.length; i++) {
      for (int j = 1; j < val[i].length; j++) {
        /** i从1开始 ，要看当前背包容量能不能放下第i-1个商品 */
        if (j >= weight[i - 1]) {
          /** 放下这个商品的价格是不是大于放上一个商品的背包的价格 */
          if (val[i - 1][j] < price[i - 1] + val[i - 1][j - weight[i - 1]]) {
            val[i][j] = price[i - 1] + val[i - 1][j - weight[i - 1]];
            path[i][j] = 1;
          } else {
            val[i][j] = val[i - 1][j];
          }
        } else {
          val[i][j] = val[i - 1][j];
        }
      }
    }
    /** 将放入背包的商品名称与价格放入map中 */
    int s = val.length - 1;
    int w = val[0].length - 1;
    /** 逆序遍历 */
    while (s > 0 && w > 0) {

      if (path[s][w] == 1) {
        // 将该商品的名称和价格放入map
        map.put(shop[s - 1], price[s - 1]);
        // 把背包当前物品的重量减去， 当前背包中剩余的重量
        w -= weight[s - 1];
      }
      s--;
    }
    return map;
  }
}

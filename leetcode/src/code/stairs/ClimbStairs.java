package code.stairs;

import java.util.*;

/**
 * @Author: 云萧YYY @DateTime: 2021/12/21 @Description: leetcode 70 爬楼梯问题 假设你正在爬楼梯。需要 n
 * 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbStairs {

    private static int count = 0;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        climbStairs(4, 0);
        System.out.println(count);
    }

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 35.3 MB
     * , 在所有 Java 提交中击败了
     * 15.04%
     * 的用户
     * 通过测试用例：
     * 45 / 45
     *
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int l1 = 1;
        int l2 = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = l2 + l1;
            l1 = l2;
            l2 = temp;
        }
        return temp;
    }

    /**
     * 引入 hashmap 来帮助我们存储已经计算的值, 解决重复计算的问题 时间复杂度 为n
     * 第n个台阶只能从第n-1或者n-2个上来。到第n-1个台阶的走法 + 第n-2个台阶的走法 = 到第n个台阶的走法，已经知道了第1个和第2个台阶的走法，一路加上去。
     * <p>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 34.9 MB , 在所有 Java 提交中击败了 88.52% 的用户 通过测试用例：
     * 45 / 45
     *
     * @param n
     * @param map
     * @return
     */
    public static int climbStairs(int n, Map<Integer, Integer> map) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (null != map.get(n)) {
            return map.get(n);
        } else {
            int result = climbStairs(n - 1, map) + climbStairs(n - 2, map);
            map.put(n, result);
            return result;
        }
    }

    /**
     * 抽象 出 一个 递归公式 ，但是 不难看出 会存在重复计算的问题 即 {@code f(6)= f(5) + f(4) f(5)= f(4) + f(3) 此时这个f(4) 就存在重复计算
     * } 超时！ 时间复杂度 nlogn
     * 第n个台阶只能从第n-1或者n-2个上来。到第n-1个台阶的走法 + 第n-2个台阶的走法 = 到第n个台阶的走法，已经知道了第1个和第2个台阶的走法，一路加上去。
     * @param n*n/2
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 2) + climbStairs(n - 1);
    }

    /**
     * 回溯 算法超时 当n >= 44！ 时间复杂度 n*n
     *
     * @param n
     * @param sum
     * @return
     */
    public static boolean climbStairs(int n, int sum) {
        if (sum > n) return false;
        if (sum == n) {
            count++;
            return true;
        }
        for (int i = 1; i <= 2; i++) {
            sum += i;
            boolean b = climbStairs(n, sum);
            if (b) {
                break;
            }
            sum -= i;
        }
        return false;
    }
}

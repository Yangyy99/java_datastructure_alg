package code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 云萧YYY @DateTime: 2021/12/12 @Description: leetcode one two sum
 *
 * <p>执行用时： 2 ms , 在所有 Java 提交中击败了 87.98% 的用户 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 57.77% 的用户 通过测试用例： 57
 * / 57
 */
public class TwoSum {

  public static void main(String[] args) {
    int[] nums = new int[] {2, 7, 11, 15};
    int target = 9;
    System.out.println(Arrays.toString(twoSum(nums,target)));
  }

  public static int[] twoSum(int[] nums, int target) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {

      if (map.containsKey(target - nums[i])) {
        return new int[] {map.get(target - nums[i]), i};
      }
      map.put(nums[i], i);
    }
    return null;
  }
}

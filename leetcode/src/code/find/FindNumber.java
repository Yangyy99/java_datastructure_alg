package code.find;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: 云萧YYY
 * @DateTime: 2021/12/28
 * @Description: 给你一个含 n个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果.
 */
public class FindNumber {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = findNumbers(arr);
        System.out.println(list);
    }

    /**
     * 数组中的每一个数都是1-n 之间的数组 ，数组的长度是n 如果存在消失的数字那么必定有相同的元素
     * 要利用当前给出的数组来记录已经存在的信息，由于数字是1-n之间的 每一个元素都是索引到数组中的某一个元素上
     * 那么我们只需要对索引到的元素进行操作，当数组中的某一个元素没有发生改变时，那么我们就可以认为该元素所在的索引的数子不存在
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        if (nums == null || nums.length < 1) {
            return null;
        }
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                list.add(i + 1);
            }
        }
        return list;
    }

    /**
     * 方法二  将数组中元素变为负数
     *
     * @param nums
     * @return
     */
    public static List<Integer> findNumbers(int[] nums) {

        if (nums == null || nums.length < 1) {
            return null;
        }
        int index = 0;
        for (int num : nums) {
            index = num < 0 ? -num - 1 : num - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}

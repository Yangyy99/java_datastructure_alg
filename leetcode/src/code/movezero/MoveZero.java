package code.movezero;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * @Author: 云萧YYY
 * @DateTime: 2021/12/23
 * @Description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZero {
    public static void main(String[] args) {

        int[] nums = {1, 0, 0, 3, 4, 0};
        // 移动符合条件的元素，移动出数组 ，或者或删除满足条件的元素
        moveZeroes(nums, i -> i == 0);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums, Predicate<Integer> predicate) {

        if (nums == null || nums.length < 1) {
            return;
        }
        //offset 纪录非零元素个数,其实这样就想当于纪录一个偏移量,
        int offset = 0;
        for (int i = 0; i < nums.length; i++) {
            //这里的条件不一定是移动零
            if (!predicate.test(nums[i])) {
                // 将非零元素往前移动,占据零的位置,offset != i 说明 i要移动的元素,移动完毕置零
                if (offset != i) {
                    //此时 offset 指向0的位置
                    nums[offset] = nums[i];
                    nums[i] = 0;
                }
                offset++;
            }
        }
        //此时 ,非零的元素全部移动完了,将后面的元素置零
//        for (; offset < nums.length; offset++) {
//            nums[offset] = 0;
//        }
    }


}

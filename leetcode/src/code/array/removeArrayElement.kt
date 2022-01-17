package code.array

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/01/17
 * @Description: TODO
 */

import code.mergeArray.ListNode

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/01/17
 * @Description: TODO
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */

fun main() {

}

/**
 *  与删除0的思路一样， 数组中双指针的应用
 */
fun removeElement(nums: IntArray, `val`: Int): Int? {

    var offset = 0
    nums.forEachIndexed() { i, num ->
        if (num != `val`) {
            if (i != offset) {
                nums[offset] = num
                nums[i] = 0
            }
            offset++
        }
    }

    return offset
}
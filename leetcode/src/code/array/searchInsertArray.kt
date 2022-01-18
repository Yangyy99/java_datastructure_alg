package code.array

import code.stack.isValid

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/01/18
 * @Description: TODO 35
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
fun main() {
    //: nums = [1,3,5,6], target = 7
    val arr = IntArray(4).apply {
        this[0] = 1
        this[1] = 3
        this[2] = 5
        this[3] = 6
    }
    searchInsertToBinary(arr, 4).apply(::print)
}

/**
 *  二分查找的思想 ，数组是有序的 ,使用
 *
 */
fun searchInsert(nums: IntArray, target: Int): Int {

    var index = nums.size / 2
    var piovt = nums[index]
    var flag = 0;
    while (true) {
        if (piovt == target) return index
        flag = index;
        if (piovt > target) {
            index /= 2
        } else {
            index += (nums.size - index) / 2
        }
        if (flag == index) return index + 1;
        piovt = nums[index]
    }

}


/**
 *  二分查找的思想 ，首尾指针法
 */
fun searchInsertToBinary(nums: IntArray, target: Int): Int {

    var left = 0
    var right = nums.size - 1

    var middian = 0
    var find = 0

    while (left <= right) {
        middian = (left + right) / 2
        find = nums[middian]
        if (target == find) return middian
        if (target < find) {
            right = middian - 1
        }
        if (target > find) {
            left = middian + 1
        }

    }
    return left
}


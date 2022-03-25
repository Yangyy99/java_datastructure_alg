package code.array

import java.util.*
import kotlin.collections.HashSet
import kotlin.math.min

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/03/25
 * @Description: leetcode 349  给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 */
fun main() {

    //nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    val nums1 = intArrayOf(4, 9, 5)
    val nums2 = intArrayOf(9, 4, 9, 8, 4)
    intersection(nums1, nums2).contentToString().apply(::println)
}

/***
 * hashse
 */
fun intersection(nums1: IntArray, nums2: IntArray): IntArray {

    if (nums1.isEmpty() || nums2.isEmpty()) return intArrayOf()
    val set = HashSet<Int>()
    nums1.forEach(set::add)


    val result = IntArray(min(nums1.size, nums2.size))
    var index = 0
    nums2.forEach {
        if (set.contains(it)) {
            result[index++] = it
            set.remove(it)
        }
    }
    return result.copyOfRange(0, index)
}
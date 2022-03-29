package code.leetcode57

import java.util.*
import kotlin.math.max
import kotlin.math.min

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/03/25
 * @Description:
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */

fun main() {
    //intervals = [[1,3],[6,9]], newInterval = [2,5]
    //intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8
    val intervals = arrayOf(intArrayOf(1, 5))
//    val intervals = arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7), intArrayOf(8, 10), intArrayOf(12, 16))
    val newInterval = intArrayOf(6, 8)

//    insert(intervals, newInterval).forEach {
//        it.contentToString().apply(::println)
//    }
//    println()
    greedyInsert(intervals, newInterval).forEach {
        it.contentToString().apply(::println)
    }
//    insert(intervals, newInterval).contentEquals(greedyInsert(intervals, newInterval)).apply(::println)

    isEquals(insert(intervals, newInterval), greedyInsert(intervals, newInterval)).apply(::println)


}

/**
 * 比较两个二维数组是否相等
 */
fun isEquals(arr1: Array<IntArray>, arr2: Array<IntArray>): Boolean {

    if (arr1.size != arr2.size) return false

    for (i in arr1.indices) {
        if (arr1[i].contentEquals(arr2[i])) {
            return true
        }
    }
    return false

}

/***
 * 贪心算法，解决合并区间，在插入时解决,不完善
 *  包括 初始放入时 以及size 为1 时
 *
 *
 */
fun greedyInsert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

    if (intervals.isEmpty()) return arrayOf(newInterval)

    if (newInterval.isEmpty()) return intervals

    val result = Array<IntArray>(intervals.size + 1) {
        intArrayOf()
    }
    var index = 0

    result[index++] = intArrayOf(intervals[0][0], intervals[0][1])

    if (intervals.size == 1) {
        if (newInterval[0] > intervals[0][1]) {
            result[index++] = newInterval
        } else {
            val left = min(intervals[0][0], newInterval[0])
            val right = max(intervals[0][1], newInterval[1])
            result[0] = intArrayOf(left, right)

        }
        return result.copyOfRange(0, index)
    }




    for (i in 1 until intervals.size) {

        var point = result[index - 1][1]
        /**
         * 直接插入 两个区间不会重合
         */
        if (point < newInterval[0] && newInterval[0] < intervals[i][0]) {
            result[index++] = newInterval
            point = newInterval[1]
        }

        /**
         * 合并区间
         */
        if (point >= newInterval[0] && result[index - 1][1] < newInterval[1]) {
            result[index - 1][1] = newInterval[1]
            point = newInterval[1]
        }
        /**
         * 放入元素也要查看是否要合并
         */
        if (intervals[i][0] <= point && result[index - 1][1] < intervals[i][1]) {
            result[index - 1][1] = intervals[i][1]
            continue
        }

        if (intervals[i][0] > point && intervals[i][1] > result[index - 1][1]) result[index++] = intervals[i];
    }

    return result.copyOfRange(0, index)
}

/***
 * 插入区间  排序法 结合leetcode 56
 * 新增的区间先放入最后, 在合并区间
 */
fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

    val newArray = copy(intervals)
    newArray[intervals.size] = newInterval
    Arrays.sort(newArray) { o1, o2 -> o1[0] - o2[0] };
    return mergeInterval(newArray);

}

/***
 * 区间合并leetcode56,这里只合并
 * @param intervals 有序的数组
 */
private fun mergeInterval(intervals: Array<IntArray>): Array<IntArray> {

    if (intervals.size < 2) return intervals

    val result = Array<IntArray>(intervals.size) {
        IntArray(it)
    }
    var index = 0
    result[index++] = intArrayOf(intervals[0][0], intervals[0][1])

    for (i in 1 until intervals.size) {

        val left = intervals[i][0];
        val right = intervals[i][1];
        /**
         * 要合并的区间
         */
        if (result[index - 1][1] in (left) until right) result[index - 1][1] = right
        /**
         * 不需要合并 直接放入result
         */
        if (left > result[index - 1][1]) {
            result[index++] = intArrayOf(left, right)
        }
    }

    return result.copyOfRange(0, index);
}

/**
 * copy数组
 */
private fun copy(old: Array<IntArray>): Array<IntArray> {

    val newArray = Array<IntArray>(old.size + 1) {
        intArrayOf(it)
    }
    System.arraycopy(old, 0, newArray, 0, old.size);
    return newArray
}

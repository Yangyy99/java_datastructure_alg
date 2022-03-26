package code.leetcode57

import java.util.*

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/03/25
 * @Description:
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */

fun main() {
    //intervals = [[1,3],[6,9]], newInterval = [2,5]
    //intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8
    val intervals = arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7), intArrayOf(8, 10), intArrayOf(12, 16))
    val newInterval = intArrayOf(4, 8)

    insert(intervals, newInterval).forEach {
        it.contentToString().apply(::println)
    }
}

/***
 * 贪心算法，解决合并区间，在插入时解决
 */
fun greedyInsert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    return arrayOf()
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

package code.leetocde56

import java.util.*

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/02/10
 * @Description:  leetcode  56
 *以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals [] = [start, end] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 *输出：[[1,6],[8,10],[15,18]]
 *解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
fun main() {

    //[[1,3],[2,6],[8,10],[15,18]]
    val array = arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))
    /**
     * [[1,4],[0,2],[3,5]]
     */
    //val array = arrayOf(intArrayOf(1, 4), intArrayOf(0, 2), intArrayOf(3, 5))
    merge(array).forEach {
        println(it.contentToString())
    }
}

/**
 *  根据区间的特点 右区间大于左区间 那么需要合并,这样内存超出限制 （）
 */
fun merge(intervals: Array<IntArray>): Array<IntArray> {

    if (intervals.size < 2) return intervals

    val result = Array(intervals.size) {
        IntArray(it)
    }
    var index = 0
    Arrays.sort(intervals) { o1, o2 -> o1[0] - o2[0] };
    /**
     * 初始化 第一个结点
     */
    result[index++] = intArrayOf(intervals[0][0], intervals[0][1])

    for (i in 1 until intervals.size) {

        if (result[index - 1][1] in intervals[i][0]..intervals[i][1])
            result[index - 1][1] = intervals[i][1]

        if (intervals[i][0] > result[index - 1][1])
            result[index++] = intArrayOf(intervals[i][0], intervals[i][1])

    }
    return result.copyOfRange(0, index)
}


package code.mergeArray

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/01/20
 * @Description: TODO leetcode 53
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 */
fun main() {

    val array = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    maxSubArray2(array).also(::println)

}

/***
 * Dynamic Programing
 * 动态规划
 *
 *  三要素
 */
fun maxSubArray2(nums: IntArray): Int {


    var max = 0
    var subMax = nums[0];
    nums.forEach {
        //  对于每一个元素当前的最大子序列和 要么是当前元素 ,要么为当前元素 加上上一个元素的最大子序列和
        if (max + it >= it) max += it
        else max = it
        // 擂台法比较出最大的
        if (max > subMax) subMax = max
    }
    return subMax
}

/**
 * 分治法
 */
fun maxSubArray(nums: IntArray): Int {
    return getMaxSubArray(nums, 0, nums.size - 1)
}

/***
 * 分治思想切分 ,
 */
fun getMaxSubArray(nums: IntArray, left: Int, right: Int): Int {

    if (left == right) return nums[left]
    val mid = left + (right - left) / 2;
    val leftValue = getMaxSubArray(nums, left, mid)
    val rightValue = getMaxSubArray(nums, mid + 1, right);
    //中间的片段
    val sumMiddum = getCrossArray(nums, left, right);
    return mergeSubArray(leftValue, rightValue, sumMiddum)
}

/**
 * left --> right的value
 */
fun getCrossArray(nums: IntArray, left: Int, right: Int): Int {
    if (left == right) return nums[left]
    val mid = left + (right - left) / 2
    // 取左边最大字串value
    var leftSum = nums[mid]
    var leftMax = leftSum
    for (i in mid - 1 downTo left) {
        leftSum += nums[i]
        leftMax = max(leftSum, leftMax)
    }
    //同理右面
    var rightSum = nums[mid + 1]
    var rightMax = rightSum
    for (j in mid + 2..right) {
        rightSum += nums[j]
        rightMax = max(rightMax, rightSum)
    }
    return rightMax + leftMax
}

/***
 * merge 分而治之 治
 */
fun mergeSubArray(leftVal: Int, rigthVal: Int, sumMiddum: Int): Int {
    return max(leftVal, max(sumMiddum, rigthVal))
}

fun max(num1: Int, num2: Int): Int {
    return if (num1 >= num2) num1 else num2
}

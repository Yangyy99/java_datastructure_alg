package code.array

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/01/17
 * @Description: 给定一个二进制数组， 计算其中最大连续 1 的个数。 擂台法
 */
fun main() {

    val array = IntArray(7).apply {
        this[0] = 1
        this[1] = 1
        this[2] = 0
        this[3] = 0
        this[4] = 1
        this[5] = 1
        this[6] = 1
    }
    findMaxConsecutiveOnes(array).apply(::println)
}

fun findMaxConsecutiveOnes(nums: IntArray): Int {

    if (nums.isEmpty()) return 0

    var count = 0
    var max = 0
    nums.forEach {
        if (it == 1) {
            count++
        } else {
            if (max < count) {
                max = count
            }
            count = 0
        }
    }
    return if (max > count) max else count
}

fun findMaxConsecutiveOnesTwo(nums: IntArray): Int {

    if (nums.isEmpty()) return 0

    var count = 0
    var max = 0
    nums.forEach {
        if (it == 1) {
            count++
            if (max < count) {
                max = count
            }
        } else {

            count = 0
        }
    }
    return max
}


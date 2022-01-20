package code.permution

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/01/20
 * @Description: TODO leetcode 46 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
fun main() {

    val nums = IntArray(3).apply {
        this[0] = 1
        this[1] = 2
        this[2] = 3
    }
    permute(nums).also(::println)

}

fun permute(nums: IntArray): List<List<Int>> {

    val list = ArrayList<List<Int>>()
    val target = ArrayList<Int>();
    permute(nums, target, list)
    return list

}

fun permute(nums: IntArray, target: ArrayList<Int>, list: ArrayList<List<Int>>) {

    if (target.size == nums.size) {
        list.add(ArrayList(target))
        return
    }

    for (num in nums) {
        if (!target.contains(num)) {
            target.add(num)
            permute(nums, target, list)
            target.remove(num)
        }
    }

}



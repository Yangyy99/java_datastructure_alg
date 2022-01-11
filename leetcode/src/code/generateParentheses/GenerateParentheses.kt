package code.generateParentheses

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/01/11
 * @Description: TODO leetcode 22 有效括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
fun main() {

    generateParenthesis(0).apply(::println)
}

fun generateParenthesis(n: Int): List<String> {


    return mutableListOf<String>().apply {
        backtracking(n, this as ArrayList<String>, 0, 0, "")
    }
}

/**
 *
 * 回溯法
 * 使用左右计数 来纪录生成括号对数
 * @param n 生成括号对数 ,
 * @param result 结果列表
 * @param left 左边括号数量
 * @param right 右边括号数量
 * @param str 临时的字符串
 */
fun backtracking(n: Int, result: ArrayList<String>, left: Int, right: Int, str: String) {
    if (right > left) return
    if (left == right && right == n) {
        result.add(str)
    }
    // 加左括号
    if (left < n) backtracking(n, result, left + 1, right, "$str(")

    // 加右括号
    if (right < left) backtracking(n, result, left, right + 1, "$str)")

}
    
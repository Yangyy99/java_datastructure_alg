package code.stackorqueue

import java.util.*
import kotlin.text.StringBuilder

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/01/09
 * @Description: TODO 394 字符串解码
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入
 *
 */
fun main() {
    // val s = "abc3[cd]xyz"
    val s = "3[a]2[bc]"
    // val s="3[a2[c]]"
    //  val s = "100[leetcode]"
    decodeString(s).let {
        print(it)
    }
}

/**
 * 使用stack的方式 ,
 *
 */
fun decodeString(s: String): String {
    val stack = Stack<String>()
    val str = StringBuilder();
    var value = "0"
    s.forEach {

        if (it == ']') {
            while (stack.peek() != "[") {
                str.append(stack.pop())
            }
            stack.pop()
            while (stack.isNotEmpty() && stack.peek().matches(Regex("\\d"))) {
                value += stack.pop()
            }
            value = value.reversed()
            if (value.length > 1) value = value.run {
                this.substring(0, this.length - 1)
            }
            stack.push(str.repeat(value.toInt()))
            value = "0"
            str.clear()
        } else
            stack.push(it.toString())
    }
    while (stack.isNotEmpty()) {
        str.append(stack.pop())
    }
    return str.reverse().toString()
}
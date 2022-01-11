package code.stack

import java.util.*

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/01/11
 * @Description: TODO leetocde 20 匹配括号  2021 bilibili
 */
fun main() {
    val s = "}"
    isValid(s).apply(::println)
}

/**
 *  括号匹配一看就需要使用stack 来解决
 *  需要明确: 满足条件时 就需要弹栈 ，不满足所要的条件则入栈即可
 */
fun isValid(s: String): Boolean {
    if (s.isEmpty()) return true
    val stack = Stack<Char>()
    val map = hashMapOf<Char, Char>().apply {
        this['{'] = '}'
        this['('] = ')'
        this['['] = ']'
    }
    s.forEach {
        if (map.values.contains(it)) {
            if (stack.isNotEmpty() && map[stack.peek()] == it) {
                stack.pop()
            } else {
                return false
            }
        } else
            stack.push(it)
    }
    return stack.isEmpty()
}
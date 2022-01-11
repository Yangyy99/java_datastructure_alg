package code.stack

import java.util.*

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/01/09
 * @Description: TODO leetcode 232 两个stack 模拟 queue
 *  stack 是 后入先出的 而queue是先进先出的，所以 需要用两个stack 来完成,
 *   入栈  1->2->3  出栈 3 -> 2 -> 1 在入栈  再出栈 1->2->3
 */
class MyQueue() {

    //输入栈
    private val inStack = Stack<Int>();

    // 输出栈
    private val outStack = Stack<Int>();

    fun push(x: Int) {
        inStack.push(x)
    }

    fun pop(): Int {
        if (outStack.empty() && inStack.isNotEmpty()) {
            transfer()
        }
        return outStack.pop()
    }

    fun peek(): Int {
        if (outStack.empty() && inStack.isNotEmpty()) {
            transfer()
        }
        return outStack.peek()
    }

    fun empty(): Boolean {

        return outStack.empty() && inStack.empty()
    }

    private fun transfer() {
        while (inStack.isNotEmpty()) {
            outStack.push(inStack.pop())
        }

    }
}
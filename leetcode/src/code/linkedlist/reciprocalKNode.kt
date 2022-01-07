package code.linkedlist

import code.mergeArray.ListNode
import java.lang.IndexOutOfBoundsException
import java.lang.RuntimeException

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/01/07
 * @Description: TODO  输出链表中 倒数第K个结点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 */
fun main() {
    val head: ListNode = ListNode(1, ListNode(2, ListNode(2, ListNode(2, ListNode(1, null)))))
    getKthFromEnd(head, 2).apply(::println)
}

/**
 * 使用滑动窗口的思想 , 需要用到双指针
 * 假设有一个窗口大小为 K的窗口 当窗口的右侧到达链表尾部的时候，
 * 窗口左侧的指针正好对应倒数第K个结点
 */
fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {

    if (head == null || k < 1) return null
    var offset = k - 1
    var left: ListNode? = head
    var right: ListNode? = head
    // 初始化 右窗口位置
    while (offset-- > 0 && right != null) {
        right = right.next
    }
    if (right == null) throw IndexOutOfBoundsException("k 不合法")
    // 开始移动
    while (right?.next != null) {
        right = right.next
        left = left?.next
    }
    return left
}
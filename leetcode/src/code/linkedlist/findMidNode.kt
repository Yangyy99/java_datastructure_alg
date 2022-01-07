package code.linkedlist

import code.mergeArray.ListNode

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/01/07
 * @Description: TODO leetcode 876
 *  给定一个头结点为 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
 */
fun main() {
    val head: ListNode = ListNode(1, ListNode(2, ListNode(2, ListNode(2, ListNode(1, null)))))
    middleNode(head).apply(::println)
}

/**
 * 快慢指针的求解方式
 */
fun middleNode(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    var fast = head
    var slow = head
    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }
    return fast?.let {
        slow
    } ?: slow
}
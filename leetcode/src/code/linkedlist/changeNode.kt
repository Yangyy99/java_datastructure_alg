package code.linkedlist

import code.mergeArray.ListNode

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/01/16
 * @Description: TODO
 */
fun main() {
    val head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, null))));
    swapPairsToIterator(head).apply(::println)

}

/**
 * 递归解决
 */
fun swapPairs(head: ListNode?): ListNode? {

    if (head?.next == null) return head
    val next = head.next

    head.next = swapPairs(head.next!!.next)
    next?.next = head
    return next
}

/**
 * 迭代法,0 期待 fork
 */
fun swapPairsToIterator(head: ListNode?): ListNode? {
    return null;
}


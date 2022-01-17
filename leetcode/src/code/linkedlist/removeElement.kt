package code.linkedlist

import code.array.removeElement
import code.mergeArray.ListNode

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/01/17
 * @Description: TODO 203 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */

fun main() {
    //[1,2,6,3,4,5,6]
    val head = ListNode(1, ListNode(2, ListNode(6, ListNode(3, ListNode(4, ListNode(5, ListNode(6, null)))))))
    removeElementsRecursion(head, 6)
    println(head)
}

/**
 * kotlin 语言存在问题
 */
fun removeElements(head: ListNode?, `val`: Int): ListNode? {

    if (head == null) head
    val result = ListNode(0, head)
    var pre = result
    while (pre.next != null) {
        //remove
        if (pre.next?.`val` == `val`) {
            pre.next = pre.next?.next
        }
        pre = pre.next!!

    }
    return result.next
}

/**
 * 递归
 */
fun removeElementsRecursion(head: ListNode?, `val`: Int): ListNode? {

    if (head == null) return head
    head.next = removeElementsRecursion(head.next, `val`)
    return if (head.`val` == `val`) head.next else head
}
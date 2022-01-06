package code.linkedlist

import code.mergeArray.ListNode


/**
 * @Author: 云萧YYY
 * @DateTime: 2022/01/05
 * @Description: TODO  leetcode
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
fun main() {
    val head: ListNode = ListNode(1, ListNode(1, ListNode(1, ListNode(2, null))));
    println(reverseList(head))
    println(reserve(null, head))
}

/**
 * 循环方式 ,迭代 ,
 * 核心思想 有两个变量 分别指向 当前节点 和 上一个节点  ，这两个进行反转 ，
 * 然后当前节点往下移动，自然的上一个节点也会变化 ，以此类推
 */
fun reverseList(head: ListNode?): ListNode? {

    if (head == null) return null
    var pre: ListNode? = null
    var cur: ListNode? = head
    var temp: ListNode? = null
    while (cur != null) {
        temp = cur.next
        cur.next = pre
        pre = cur
        cur = temp
    }
    return pre;
}

/**
 * 尾递归方式  反转链表 需要两个变量 ，来记录当前和上一个节点位置  ,
 * 从开头就反转 ，递归反转后面
 */
fun reserve(per: ListNode?, head: ListNode?): ListNode? {
    if (head == null) return per
    val tempNode: ListNode? = head.next
    head.next = per
    return reserve(head, tempNode)
}
package code.linkedlist

import code.mergeArray.ListNode

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/01/06
 * @Description: TODO leetcode 234
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
fun main() {
    val head: ListNode = ListNode(1, ListNode(2, ListNode(2, ListNode(2, ListNode(1, null)))));
    // println(reverse(null, head))
    println(isPalindrome(head))
}

/**
 *  回文链表特点 左右对称， 那么就是说 将一边反转后 与另一边是相等的
 *  引入快慢双指针 帮助定位中间结点 ,
 */
fun isPalindrome(head: ListNode?): Boolean {
    if (head == null) return false
    if (head.next == null) return true
    var fast = head
    var slow = head
    // 由于fast 一次走两步 ,所以当fast到最后结点时，slow 是位于链表中间结点
    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }
    //判断该链的奇偶 奇数链表只需要从中间结点下一个位置开始反转即可
    if (fast != null) {
        // 说明该链表是奇数链表 ,slow 往下移动
        slow = slow?.next
    }
    //反转右半部分
    slow = reverse(null, slow)
    //fast 回到起始位置
    fast = head
    return equals(slow, fast);
}

fun reverse(per: ListNode?, cur: ListNode?): ListNode? {
    if (cur == null) return per
    val temp = cur.next
    cur.next = per
    return reverse(cur, temp)
}

/**
 *  这个比较 只适用于 src 链<= dest 链的长度
 */
fun equals(src: ListNode?, dest: ListNode?): Boolean {
    if (src == null || dest == null) return false
    var p1 = src
    var p2 = dest
    while (p1 != null) {
        if (p1.`val` != p2?.`val`) return false
        p1 = p1.next
        p2 = p2.next
    }
    return true
}
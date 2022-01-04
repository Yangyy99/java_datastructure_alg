import code.mergeArray.ListNode

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/01/04
 * @Description: leetcode160
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
fun main() {
    val l1 = ListNode(1, ListNode(2, ListNode(4, null)));
    val l2 = ListNode(1, ListNode(3, ListNode(4, null)));
    // 1 ->2 ->3 -> 4 -> null   , 1->3->4 -> null
    l1.next?.next = l2.next;
    println(getIntersectionNode1(l1, l2))

}

/**
 * 方法1.
 * 这种方式 设 公共的长度部分为c  A 链除公共长度为 a B链为b  那么 一定有 a+b+c = b+a+c
 * 所以 需要将指针移到另一个链表的头部，
 * 此时 一定会有公共交点为n 或者null ,所以等式 一定成立
 *
 */
fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    if (headA == null || headB == null) return null
    var p1: ListNode? = headA
    var p2: ListNode? = headB
    while (p1 != p2) {
        // A 这条链走到最后 需要换到B链头
        p1 = p1?.next ?: headB
        // B 这条链走到最后 换到A链头
        p2 = p2?.next ?: headA
    }
    return p1
}

/***
 * 方法二 补偿法
 * 先将长的链表 移动至与 链表2相同长度的位置 再开始比较
 *
 *
 */
fun getIntersectionNode1(headA: ListNode?, headB: ListNode?): ListNode? {
    if (headA == null || headB == null) return null
    val l1 = size(headA)
    val l2 = size(headB)

    var p1: ListNode? = headA
    var p2: ListNode? = headB

    val offset = l1 - l2
    if (offset < 0) {
        p2 = move(p2, -offset)
    } else
        p1 = move(p1, offset)
    while (p1 != p2) {
        p1 = p1?.next
        p2 = p2?.next
    }
    return p1
}

fun size(node: ListNode): Int {
    var p: ListNode? = node
    var count = 0
    while (p != null) {
        count++
        p = p.next
    }
    return count
}

fun move(p: ListNode?, offset: Int): ListNode? {

    if (offset == 0) return p
    var pointer: ListNode? = p
    var count = offset
    while (count > 0) {
        pointer = pointer?.next
        count--
    }
    return pointer
}
package code.mergeArray

/**
 * @Author: 云萧YYY
 * @DateTime: 2021/12/29
 * @Description: 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
fun main() {
    //[1,2,4]
    //[1,3,4]
    val l1 = ListNode(1, ListNode(2, ListNode(4, null)));
    val l2 = ListNode(1, ListNode(3, ListNode(4, null)));
    println(mergeTwoList(l1, l2))
}

/***
 * 执行用时204 ms 在所有 Kotlin 提交中击败了64.15%的用户内存消耗：37.3 MB
 * , 在所有 Kotlin 提交中击败了30.19%的用户
 * 通过测试用例：
 * 218 / 218
 * 递归还是有些慢的 推荐 循环
 */
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1
    //返回小的节点
    if (l1.`val` > l2.`val`) {
        l2.next = mergeTwoLists(l1, l2.next)
        return l2;
    }
    l1.next = mergeTwoLists(l1.next, l2)
    return l1;
}

/**
 * 循环迭代方式
 */
fun mergeTwoList(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1

    var node1 = l1;
    var node2 = l2;
    val node: ListNode = ListNode(0, null);
    var tempNode: ListNode = node;
    while (node1 != null && node2 != null) {
        if (node1.`val` <= node2.`val`) {
            tempNode.next = node1;
            tempNode = node1;
            node1 = node1.next;
        } else {
            tempNode.next = node2
            tempNode = node2
            node2 = node2.next
        }
    }
    if (node1 != null) tempNode.next = node1;

    if (node2 != null) tempNode.next = node2

    return node.next;
}


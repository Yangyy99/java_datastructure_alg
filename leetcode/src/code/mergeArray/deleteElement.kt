package code.mergeArray

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/01/03
 * @Description: leetcode 83
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次
 */
fun main() {
    //[1,1,2]
    val head: ListNode = ListNode(1, ListNode(1, ListNode(1, ListNode(2, null))));
    //println(deleteDuplicates(head))
    //  println(reserve(head))
}

/**
 * 循环链表
 * 执行用时：180 ms
 * , 在所有 Kotlin 提交中击败了74.47%的用户
 * 内存消耗：34.8 MB, 在所有 Kotlin 提交中击败了80.85%的用户
 * 通过测试用例：166 / 166
 */
fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head == null) {
        return null;
    }

    var currentNode: ListNode? = head;
    while (currentNode?.next != null) {
        if (currentNode.`val` == currentNode.next?.`val`) {
            currentNode.next = currentNode.next?.next;
            continue;
        }
        currentNode = currentNode.next;
    }
    return head;
}

/**
 * 递归方式 不完善
 */
fun deleteDuplicatesRecursion(head: ListNode?): ListNode? {
    if (head == null) {
        return null;
    }

    head.next = deleteDuplicatesRecursion(head.next);
    return null;
}



package code.twosum;

/**
 * @Author: 云萧YYY @DateTime: 2021/12/13 @Description:
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * <p>请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * <p>你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers
 *
 * <p>执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 38.4 MB , 在所有 Java 提交中击败了 83.90% 的用户 通过测试用例：
 * 1568 / 1568
 */
public class TwoSumAdd {

  public static void main(String[] args) {

    ListNode l1 = new ListNode(2);
    ListNode l2 = new ListNode(4);
    ListNode l3 = new ListNode(3);
    l1.next = l2;
    l2.next = l3;
    // [2,4,3]
    // [5,6,4]
    ListNode l4 = new ListNode(5);
    ListNode l5 = new ListNode(6);
    ListNode l6 = new ListNode(4);
    l4.next = l5;
    l5.next = l6;

    ListNode listNode = addTwoNumbers(l2, l5);
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return computeTwo(l1, l2, 0);
  }

  /**
   * 2->4->3
   * 5->6->4
   * 每一位 进行计算 , 但是需要注意两个数字不是同一位数,当前位需要补零计算
   *
   * @param l1
   * @param l2
   * @param carry 进位 0 或 1
   * @return
   */
  public static ListNode computeTwo(ListNode l1, ListNode l2, int carry) {

    if (l1 == null && l2 == null && carry == 0) {
      return null;
    }
    int num1 = 0;
    if (l1 != null) {
      num1 = l1.val;
      l1 = l1.next;
    }
    int num2 = 0;
    if (l2 != null) {
      num2 = l2.val;
      l2 = l2.next;
    }
    int sum = num1 + num2 + carry;
    carry = 0;
    if (sum > 9) {
      sum -= 10;
      carry = 1;
    }
    return new ListNode(sum, computeTwo(l1, l2, carry));
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    return this.val + "";
  }
}

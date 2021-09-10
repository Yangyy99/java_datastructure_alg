package bstree;

import java.util.ArrayDeque;
import java.util.Queue;

/** @Author: 云萧YYY @DateTime: 2021/08/31 @Description: 二叉排序树 */
public class Test {

  public static void main(String[] args) {

    BinarySortTree bstree = new BinarySortTree();
    int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
    for (int i = 0; i < arr.length; i++) {
      bstree.add(arr[i]);
    }
    //    bstree.midOrder();
    //    bstree.delete(3);
    //    System.out.println();
    //    bstree.midOrder();
    System.out.println(isCompleteBeast(bstree.getRoot()));
  }

  /**
   * 判断一个树是否是完全二叉树
   *
   * @param head
   * @return
   */
  public static boolean isComplete(Node head) {
    if (head == null || head.getLeft() == null && head.getRight() == null) {
      return true;
    }
    Queue<Node> queue = new ArrayDeque<>();
    addNodeToQueue(head, queue);

    while (!queue.isEmpty()) {
      Node temp = queue.remove();
      if (temp.getLeft() == null && temp.getRight() != null) {
        return false;
      }
      /** 左右孩子不双全 后面的结点全都是叶子结点 才是完全二叉树 */
      if (temp.getLeft() != null && temp.getRight() == null) {
        while (!queue.isEmpty()) {
          Node node = queue.remove();
          if (node.getLeft() != null || node.getRight() != null) {
            return false;
          } else {
            return true;
          }
        }
      }
    }
    return true;
  }
  /**
   * 判断一个树是否是完全二叉树
   *
   * @param head
   * @return
   */
  public static boolean isCompleteBeast(Node head) {
    if (head == null || head.getLeft() == null && head.getRight() == null) {
      return true;
    }
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(head);
    // 标记 是否是左右不双全的孩子结点
    boolean flag = false;
    Node left = null;
    Node right = null;
    while (!queue.isEmpty()) {
      Node temp = queue.remove();

      left = temp.getLeft();
      right = temp.getRight();
      /**
       * 如果 左节点为空 右结点不为空 那么不是完全二叉树
       * 如果 左右结点不全 那么后面的结点全为叶子结点才是完全二叉树
       */
      if (flag && (left != null || right != null) || left == null && right != null) {
        return false;
      }
      if (left != null) {
        queue.add(left);
      }
      if (right != null) {
        queue.add(right);
      }
      if (left == null || right == null) {
        flag = true;
      }
    }
    return true;
  }

  public static void addNodeToQueue(Node node, Queue<Node> queue) {

    Queue<Node> temp = new ArrayDeque<>();
    temp.add(node);
    queue.add(node);
    while (!temp.isEmpty()) {
      Node node1 = temp.remove();
      if (node1.getLeft() != null) {
        queue.add(node1.getLeft());
        temp.add(node1.getLeft());
      }
      if (node1.getRight() != null) {
        queue.add(node1.getRight());
        temp.add(node1.getRight());
      }
    }
  }
}

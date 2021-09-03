package pagefolding;

import java.util.ArrayDeque;

import java.util.Queue;

/**
 * @Author: 云萧YYY @DateTime: 2021/09/02 @Description: 折纸问题：
 *
 * <p>请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展 开。此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕
 * ；突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。
 */
public class PageFoldingOrigami {

  public static void main(String[] args) {
    //
      Node<String> root = createFoldingTree(3);
      printTree(root);
  }

  /**
   * * 折纸问题使用二叉树来存放折痕
   *
   * @param n 折纸的次数
   * @return 根节点
   */
  public static Node<String> createFoldingTree(int n) {

    Node<String> root = null;
    for (int i = 0; i < n; i++) {

      // 树为空 直接创建结点
      if (root == null) {
        root = new Node<String>("down", null, null);
      } else {
        // 辅助队列存放结点 ，因为我们要对叶子结点操作，所以使用层序遍历方式,对一层一层的元素进行操作
        Queue<Node<String>> queue = new ArrayDeque<>();
        queue.add(root);
        Node<String> temp = null;
        while (!queue.isEmpty()) {

          temp = queue.remove();
          // 该节点有左子树
          if (temp.left != null) {
            // 入队
            queue.add(temp.left);
          }
          // 该节点有右子树
          if (temp.right != null) {
            // 入队
            queue.add(temp.right);
          }
          if (temp.left == null && temp.right == null) {
            temp.left = new Node<>("up", null, null);
            temp.right = new Node<>("down", null, null);
          }
        }
      }
    }
    return root;
  }

  public static void printTree(Node<String> root) {
    if (root == null) {
      return;
    }
    printTree(root.left);
    System.out.print(root.item + ",");
    printTree(root.right);
  }

  /**
   * 存放折痕
   *
   * @param <T>
   */
  private static class Node<T> {

    private T item;
    private Node<T> left;
    private Node<T> right;

    public Node(T item, Node<T> left, Node<T> right) {
      this.item = item;
      this.left = left;
      this.right = right;
    }
  }
}

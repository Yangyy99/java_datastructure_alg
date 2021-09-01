package avltree;

/** @Author: 云萧YYY @DateTime: 2021/09/01 @Description: AVL 二叉树结点 */
public class Node {

  private int value;
  private Node left;
  private Node right;

  public Node(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }

  @Override
  public String toString() {
    return "[" + "value=" + value + ']';
  }
}

/** @Author: 云萧YYY @DateTime: 2021/08/24 @Description: 模拟树结构(int) */
public class BinaryTree {

  private TreeNode root;

  public BinaryTree(int value) {
    root = new TreeNode(value);
  }

  public BinaryTree() {}
  //
  public void add(int value) {

    if (root == null) {
      root = new TreeNode(value);
    }
    add(value, root);
  }

  /**
   * 二叉树的添加方法
   *
   * @param value
   * @param node
   */
  private void add(int value, TreeNode node) {

    if (value <= node.getValue()) {
      if (node.getLeft() == null) {
        TreeNode treeNode = new TreeNode(value);
        node.setLeft(treeNode);
        return;
      } else {
        add(value, node.getLeft());
      }
    } else {
      if (node.getRight() == null) {
        TreeNode treeNode = new TreeNode(value);
        node.setRight(treeNode);
        return;
      } else {
        add(value, node.getRight());
      }
    }
  }

  /** 前序遍历 */
  public void preOrder() {
    preOrder(root);
  }

  private void preOrder(TreeNode node) {
    if (node == null) {

      return;
    }
    System.out.print(node.getValue() + ",");
    preOrder(node.getLeft());
    preOrder(node.getRight());
  }

  /**
   * 前序查找
   *
   * @param value 要查找的值
   * @return 返回查找位置的结点
   */
  public TreeNode preSearch(int value) {
    if (root == null) {
      throw new RuntimeException("树为空");
    }
    TreeNode treeNode = preSearch(value, root);
    if (treeNode == null) {
      System.out.println("该节点不存在");
      return null;
    }
    return treeNode;
  }

  private TreeNode preSearch(int value, TreeNode node) {

    if (node == null) {
      return null;
    }
    if (node.getValue() == value) {
      return node;
    }
    if (node.getValue() > value) {
      return preSearch(value, node.getLeft());
    } else {
      return preSearch(value, node.getRight());
    }
  }

  /**
   * 删除指定value的节点
   *
   * @param value
   */
  public void delete(int value) {
    if (root == null) {
      throw new RuntimeException("树为空");
    }
    if (root.getValue() == value) {
      root = null;
    }
    this.delNode(value, root);
  }

  private void delNode(int value, TreeNode node) {

    if (node == null) {
      return;
    }

    if (node.getLeft() != null && node.getLeft().getValue() == value) {
      node.setLeft(null);
      return;
    } else {
      if (node.getRight() != null && node.getRight().getValue() == value) {
        node.setRight(null);
        return;
      }
    }
    if (node.getLeft() != null) {
      delNode(value, node.getLeft());
    }
      if (node.getRight() != null) {
        delNode(value, node.getRight());
    }
  }
}

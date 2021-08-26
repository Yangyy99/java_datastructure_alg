package threadedtree;

/** @Author: 云萧YYY @DateTime: 2021/08/25 @Description: 线索化二叉树实现 */
public class ThreadedBinaryTree {

  // 二叉树的根结点
  private Node root = null;
  // 记录当前结点的前一个结点（中序）
  private Node pre = null;

  public ThreadedBinaryTree(int data) {
    root = new Node(data);
  }

  public ThreadedBinaryTree() {}

  public void add(int data) {
    if (root == null) {
      root = new Node(data);
    }
    add(data, root);
  }

  public void threaded() {
    if (root == null) {
      throw new RuntimeException("树为空");
    }
    this.midThreaded(root);
  }

  /**
   * 以中序方式线索化这个二叉树
   *
   * @param node
   */
  private void midThreaded(Node node) {

    if (node == null) {
      return;
    }
    // 线索化左子树
    midThreaded(node.getLeft());
    if (node.getLeft() == null) {
      // 线索化当前结点
      node.setLeft(pre);
      node.setLeftType(1);
    }
    // 此时pre正好指向前一个结点 ,pre的right指针正好应该指向当前结点
    if (pre != null && pre.getRight() == null) {
      pre.setRight(node);
      pre.setRightType(1);
    }
    pre = node;
    // 线索化右子树
    midThreaded(node.getRight());
  }

  /** 前序线索化 */
  public void preThread() {
    if (root == null) {
      throw new RuntimeException("树为空");
    }
    this.preThread(root);
  }

  /**
   * 前序方式线索化
   *
   * @param node
   */
  private void preThread(Node node) {

    if (node == null) {
      return;
    }
    // 先处理当前结点
    if (node.getLeft() == null) {
      node.setLeft(pre);
      node.setLeftType(1);
    }
    if (pre != null && pre.getRight() == null) {
      pre.setRight(node);
      pre.setRightType(1);
    }
    pre = node;

    // 左子树线索化
    if (node.getLeftType() == 0) {
      preThread(node.getLeft());
    }
    // 右子树线索化
    if (node.getRightType() == 0) {
      preThread(node.getRight());
    }
  }

  /**
   * 二叉树的添加方法
   *
   * @param data
   * @param node
   */
  private void add(int data, Node node) {

    if (data <= node.getData()) {
      if (node.getLeft() == null) {
        Node node1 = new Node(data);
        node.setLeft(node1);
        return;
      } else {
        add(data, node.getLeft());
      }
    } else {
      if (node.getRight() == null) {
        Node node1 = new Node(data);
        node.setRight(node1);
        return;
      } else {
        add(data, node.getRight());
      }
    }
  }

  /** 中序遍历 ，遍历线索树 */
  public void midOrder() {
    // 需要一个辅助结点
    Node node = root;
    while (node != null) {
      // 需要中序遍历第一个结点， leftType=1，
      while (node.getLeftType() == 0) {
        node = node.getLeft();
      }
      // 找到第一个结点了
      System.out.println(node);
      // 通过后继结点遍历了
      while (node.getRightType() == 1) {
        node = node.getRight();
        System.out.println(node);
      }
      // 此时说明右边是一颗树
      node = node.getRight();
    }
  }

  public void preOrder() {

    // 从第一个结点开始
    if (root == null) {
      throw new RuntimeException("树为空");
    }

    Node node = root;
    while (node != null) {
      System.out.println(node);
      // 说明这边是左子树
      if (node.getLeftType()==0){
          node=node.getLeft();
      }else{
          // 到达最左边的叶子结点了 往右找
          node=node.getRight();
      }
    }
  }
  /**
   * 前序查找
   *
   * @param data 要查找的值
   * @return 返回查找位置的结点
   */
  public Node preSearch(int data) {
    if (root == null) {
      throw new RuntimeException("树为空");
    }
    Node Node = preSearch(data, root);
    if (Node == null) {
      System.out.println("该节点不存在");
      return null;
    }
    return Node;
  }

  private Node preSearch(int data, Node node) {

    if (node == null) {
      return null;
    }
    if (node.getData() == data) {
      return node;
    }
    if (node.getData() > data) {
      return preSearch(data, node.getLeft());
    } else {
      return preSearch(data, node.getRight());
    }
  }

  /**
   * 删除指定Data的节点
   *
   * @param data
   */
  public void delete(int data) {
    if (root == null) {
      throw new RuntimeException("树为空");
    }
    if (root.getData() == data) {
      root = null;
    }
    this.delNode(data, root);
  }

  private void delNode(int data, Node node) {

    if (node == null) {
      return;
    }

    if (node.getLeft() != null && node.getLeft().getData() == data) {
      node.setLeft(null);
      return;
    } else {
      if (node.getRight() != null && node.getRight().getData() == data) {
        node.setRight(null);
        return;
      }
    }
    if (node.getLeft() != null) {
      delNode(data, node.getLeft());
    }
    if (node.getRight() != null) {
      delNode(data, node.getRight());
    }
  }
}

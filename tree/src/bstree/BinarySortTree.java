package bstree;
/**
 * @Author: 云萧YYY @DateTime: 2021/08/24 <br>
 * @Description: 二叉排序树 ，查找快，对数据的增加删除也快，对内存的要求也不高，结合了数组和链表的优点<br>
 * @Description: BST 将比树根结点小的放入左边 ，大的放在右边
 */
public class BinarySortTree {

  private Node root;

  public BinarySortTree(int value) {
    root = new Node(value);
  }

  public BinarySortTree() {}
  //
  public void add(int value) {

    if (root == null) {
      root = new Node(value);
    }
    add(value, root);
  }
  /**
   * 二叉树的添加方法
   *
   * @param value
   * @param node
   */
  private void add(int value, Node node) {

    if (value == node.getValue()) {
      return;
    }
    if (value < node.getValue()) {
      if (node.getLeft() == null) {
        Node Node = new Node(value);
        node.setLeft(Node);
        return;
      } else {
        add(value, node.getLeft());
      }
    } else {
      if (node.getRight() == null) {
        Node Node = new Node(value);
        node.setRight(Node);
        return;
      } else {
        add(value, node.getRight());
      }
    }
  }

  /**
   * 删除树中结点 其中有四种情况： <br>
   * 1.删除的是树根结点 <br>
   * 2.删除的是叶子结点<br>
   * 3.删除的是 非叶子结点而且左右子树都存在<br>
   * 4.删除的是 非叶子结点 但是只有左子树或者右子树<br>
   *
   * @param value
   */
  public void delete(int value) {
    // 当前结点
    Node node = searchNodeByValue(value);
    if (node == null) {
      throw new RuntimeException("没有存入该值");
    }
    // 删除树根
    if (node == root) {
      if (node.getLeft() == null && node.getRight() == null) {
        root = null;
      } else {
        delRootNode();
      }
      return;
    }
    // 获取删除节点的父节点 ,只有树根没有父节点
    Node parentNode = searchParent(value);
    Node temp = null;
    boolean flag = parentNode.getLeft() == node ? true : false;
    // 删除的结点为叶子结点
    if (node.getLeft() == null && node.getRight() == null) {
      if (parentNode.getLeft() != null && parentNode.getLeft() == node) {
        parentNode.setLeft(null);
      } else if (parentNode.getRight() != null && parentNode.getRight() == node) {
        parentNode.setRight(null);
      }
    } else if (node.getLeft() != null && node.getRight() != null) {
      // 删除的结点左右都含有结点
      // 需要右子树中最小的结点
      temp = searchMinNode(node.getLeft());
      // 把最小的结点删了
      delete(temp.getValue());
      // 将最小的结点数据修改要删除的位置即可
      node.setValue(temp.getValue());
    } else {
      // 判断要删除的该结点是父节点的左节点 还是右结点
      // flag = parentNode.getLeft() == node ? true : false;
      // 删除的结点 左边有节点
      temp = node.getLeft() != null ? node.getLeft() : node.getRight();
      // 将删除结点后的结点,加入到父节点的相应左右位置上
      if (flag) {
        parentNode.setLeft(temp);
      } else {
        parentNode.setRight(temp);
      }
    }
  }

  /** 删除树根结点 */
  private void delRootNode() {
    if (root == null) {
      throw new NullPointerException("树不能为空");
    }
    // 树根下面左右子树都存在
    if (root.getLeft() != null && root.getRight() != null) {
      Node temp = searchMinNode(root.getRight());
      delete(temp.getValue());
      root.setValue(temp.getValue());
    } else {
      // 树根下面只有一棵子树
      root = root.getLeft() == null ? root.getLeft() : root.getRight();
    }
  }

  /**
   * 返回最大的结点
   *
   * @param node
   * @return
   */
  private Node searchMaxNode(Node node) {
    if (node == null) {
      throw new NullPointerException("node 为空");
    }
    if (node.getRight() == null) {
      return node;
    }
    return searchMinNode(node.getRight());
  }

  /**
   * 返回树或者子树中最小的元素
   *
   * @param node
   * @return
   */
  private Node searchMinNode(Node node) {
    if (node == null) {
      throw new NullPointerException("node 为空");
    }
    if (node.getLeft() == null) {
      return node;
    }
    return searchMinNode(node.getLeft());
  }

  public Node searchNodeByValue(int value) {
    if (root == null) {
      throw new NullPointerException("树为空");
    }
    return searchNode(root, value, true);
  }

  public Node searchParent(int value) {
    if (root == null) {
      throw new NullPointerException("树为空");
    }
    return searchNode(root, value, false);
  }

  /**
   * 查找相应结点
   *
   * @param node 递归结点
   * @param value 查找的value
   * @param flag 获取当前结点 还是父节点 标志
   * @return
   */
  private Node searchNode(Node node, int value, boolean flag) {

    if (node == null) {
      return null;
    }
    if (flag) {
      if (node.getValue() == value) {
        return node;
      } else {
        if (value < node.getValue()) {
          return searchNode(node.getLeft(), value, true);
        } else {
          return searchNode(node.getRight(), value, true);
        }
      }
    } else {
      if (node.getLeft() != null && node.getLeft().getValue() == value
          || node.getRight() != null && node.getRight().getValue() == value) {
        return node;
      } else {
        if (value < node.getValue() && node.getLeft() != null) {
          return searchNode(node.getLeft(), value, false);
        } else if (value > node.getValue() && node.getRight() != null) {
          return searchNode(node.getRight(), value, false);
        } else {
          return null;
        }
      }
    }
  }

  /** 前序遍历 */
  public void midOrder() {
    midOrder(root);
  }

  private void midOrder(Node node) {
    if (node == null) {

      return;
    }
    midOrder(node.getLeft());
    System.out.print(node.getValue() + ",");
    midOrder(node.getRight());
  }

  public Node getRoot() {
    return root;
  }
}

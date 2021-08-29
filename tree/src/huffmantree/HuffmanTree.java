package huffmantree;

import java.util.ArrayList;
import java.util.Collections;

/** @Author: 云萧YYY @DateTime: 2021/08/28 @Description: 霍夫曼数的实现,需要一个有序的序列来实现 ,结点带权*/
public class HuffmanTree {

  public static void main(String[] args) {
    //
    int[] arr = {13, 7, 8, 3, 29, 6, 1};
    Node tree = createHuffmanTree(arr);
    preOrder(tree);
  }

  public static Node createHuffmanTree(int[] arr) {

    ArrayList<Node> nodes = new ArrayList<Node>();
    // 将数组元素转化成node 集合
    for (int i : arr) {
      nodes.add(new Node(i));
    }
    // 排序
    Collections.sort(nodes);
    while (nodes.size() > 1) {
      // 将前面的两个结点取出，合并成新的结点
      Node leftNode = nodes.get(0);
      Node rightNode = nodes.get(1);
      Node root = new Node(leftNode.getValue() + rightNode.getValue());
      root.setLeft(leftNode);
      root.setRight(rightNode);
      nodes.add(root);
      // 将处理的结点从list中删除
      nodes.remove(leftNode);
      nodes.remove(rightNode);
      // 重新排序
      Collections.sort(nodes);
    }
    return nodes.get(0);
  }

  public static void preOrder(Node root) {

    if (root == null) {
      return;
    }
    preOrder(root.getLeft());
    System.out.println(root);
    preOrder(root.getRight());
  }
}

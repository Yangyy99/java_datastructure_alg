package huffmancode;

import java.util.*;

/** @Author: 云萧YYY @DateTime: 2021/08/29 @Description: TODO */
public class HuffumanCode {

  // 存放生成霍夫曼编码表
  static Map<Byte, String> huffmancode = new HashMap<>();
  // 拼接编码使用
  static StringBuilder stringBuilder = new StringBuilder();

  public static void main(String[] args) {
    //
    String str = "i like like like java do you like a java";
    byte[] bytes = str.getBytes();
    Node huffmanTree = createHuffmanTree(getHuffmanNodes(bytes));
    // preOrder(huffmanTree);
    Map<Byte, String> huffmanCodes = getHuffmanCodes(huffmanTree);
    System.out.println(huffmanCodes);
  }

  /**
   * 返回生成的霍夫曼编码的编码表map
   *
   * @param node 霍夫曼树的根节点
   * @return
   */
  public static Map<Byte, String> getHuffmanCodes(Node node) {
    if (node == null) {
      return null;
    }
    // 左子树
    getHuffmanCodes(node.getLeft(), "0", stringBuilder);
    // 右子树
    getHuffmanCodes(node.getRight(), "1", stringBuilder);
    return huffmancode;
  }

  /**
   * 生成huffman 编码表
   *
   * @param node
   * @param code 编码 左边为 0 右边为 1
   * @param stringBuilder
   */
  private static void getHuffmanCodes(Node node, String code, StringBuilder stringBuilder) {

    if (node == null) {
      return;
    }
    // 纪录当前结点位置StringBuilder的编码
    StringBuilder builder = new StringBuilder(stringBuilder);
    // 拼接当前编码
    builder.append(code);
    // 说明这是非叶子结点
    if (node.getCh() == null) {

      // 递归遍历左子树
      getHuffmanCodes(node.getLeft(), "0", builder);
      // 递归遍历右子树
      getHuffmanCodes(node.getRight(), "1", builder);
    } else {
      // 叶子结点

      huffmancode.put(node.getCh(), builder.toString());
    }
  }

  /**
   * 生成霍夫曼编码的霍夫曼树
   *
   * @param nodes node集合
   * @return 霍夫曼树的头结点
   */
  public static Node createHuffmanTree(List<Node> nodes) {

    if (nodes != null && nodes.size() < 1) {
      throw new RuntimeException("结点集合为空");
    }

    while (nodes.size() > 1) {
      Collections.sort(nodes);
      Node left = nodes.get(0);
      Node right = nodes.get(1);
      // 新节点
      Node rootNode = new Node(null, left.getWeight() + right.getWeight());
      rootNode.setLeft(left);
      rootNode.setRight(right);
      nodes.add(rootNode);
      nodes.remove(left);
      nodes.remove(right);
    }
    return nodes.get(0);
  }

  /**
   * 获取生成霍夫曼树的结点集合
   *
   * @param bytes
   * @return
   */
  private static List<Node> getHuffmanNodes(byte[] bytes) {

    if (bytes != null && bytes.length < 1) {
      throw new RuntimeException("byte[] 不能为空");
    }
    List<Node> nodes = new ArrayList<>();
    // 根据bytes 获取统计字符的map
    Map<Byte, Integer> counts = countCh(bytes);
    for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
      nodes.add(new Node(entry.getKey(), entry.getValue()));
    }
    return nodes;
  }

  /**
   * 统计byte中每个字符的个数
   *
   * @param bytes
   * @return map
   */
  private static Map<Byte, Integer> countCh(byte[] bytes) {
    if (bytes != null && bytes.length < 1) {
      throw new RuntimeException("byte[] 不能为空");
    }
    Map<Byte, Integer> map = new HashMap<>();

    for (byte b : bytes) {
      if (map.containsKey(b)) {
        map.put(b, map.get(b) + 1);
      } else {
        map.put(b, 1);
      }
    }
    return map;
  }

  public static void preOrder(Node node) {
    if (node == null) {
      return;
    }
    System.out.println(node);
    preOrder(node.getLeft());
    preOrder(node.getRight());
  }
}

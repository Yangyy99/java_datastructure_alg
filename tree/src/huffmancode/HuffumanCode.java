package huffmancode;

import java.io.*;
import java.util.*;

/** @Author: 云萧YYY @DateTime: 2021/08/29 @Description: 生成霍夫曼编码表 , string通过霍夫曼压缩，对string进行编码和解码 以字节的单位处理，所以可以编码一切文件 */
public class HuffumanCode {

  // 存放生成霍夫曼编码表
  static Map<Byte, String> huffmancode = new HashMap<>();
  // 拼接编码使用
  static StringBuilder stringBuilder = new StringBuilder();

  public static void main(String[] args) {

    String str = "i like like like java do you like a java";
    //    byte[] code = huffmanZipCode(str);
    //    byte[] decode = decode(code, huffmancode);
    //    System.out.println(new String(decode));
    String srcFile = "D:\\test\\App.ico";
    String zipFile = "D:\\test\\dst.zip";
    String dstFile = "D:\\test\\app.zip";
     zipFile(srcFile,dstFile);
    //unZipFile(zipFile, dstFile);
    System.out.println("压缩完成");
  }

  public static void unZipFile(String zipFile, String dstFile) {

    BufferedInputStream fis = null;
    ObjectInputStream ois = null;
    BufferedOutputStream bos = null;

    try {
      fis = new BufferedInputStream(new FileInputStream(zipFile));
      ois = new ObjectInputStream(fis);
      byte[] fileCode = (byte[]) ois.readObject();
      Map<Byte, String> huffmanCode = (Map<Byte, String>) ois.readObject();
      byte[] bytes = decode(fileCode, huffmanCode);
      bos = new BufferedOutputStream(new FileOutputStream(dstFile));
      bos.write(bytes);
      bos.flush();
    }  catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } finally {
      try {
        bos.close();
        ois.close();
        fis.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  /**
   * 将文件压缩
   *
   * @param srcFile 源文件路径
   * @param dstFile 目标文件路径
   */
  public static void zipFile(String srcFile, String dstFile) {

    BufferedInputStream bis = null;
    BufferedOutputStream bos = null;
    ObjectOutputStream oos = null;

    try {
      bis = new BufferedInputStream(new FileInputStream(srcFile));
      byte[] bytes = new byte[bis.available()];
      bis.read(bytes);
      // 编码
      byte[] zipCode = huffmanZipCode(bytes);
      bos = new BufferedOutputStream(new FileOutputStream(dstFile));
      oos = new ObjectOutputStream(bos);
      // 写入压缩后的byte数组
      oos.writeObject(zipCode);
      // 写入编码表
      oos.writeObject(huffmancode);
      oos.flush();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        oos.close();
        bos.close();
        bis.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * 将编码完的byte 解压
   *
   * @param bytes 压缩后的byte数组
   * @param huffmancode 编码表
   * @return
   */
  public static byte[] decode(byte[] bytes, Map<Byte, String> huffmancode) {

    StringBuilder builder = new StringBuilder();
    ArrayList<Byte> list = new ArrayList<>();
    for (int i = 0; i < bytes.length - 2; i++) {
      builder.append(byteToBitString(bytes[i], true));
    }
    // 有效编码的最后一个不足八位的bitString
    String s = byteToBitString(bytes[bytes.length - 2], false);
    // 编码完最后一位是0的个数
    int count = bytes[bytes.length - 1];
    while (count-- > 0) {
      // 最后一位补0 因为integer 生成二进制String 可能会丢失字符 比如1 ->01  001  0001  0001....
      builder.append("0");
    }
    builder.append(s);
    // 反转编码表 由编码-字符
    Map<String, Byte> decodedMap = new HashMap<>();
    for (Map.Entry<Byte, String> entry : huffmancode.entrySet()) {
      decodedMap.put(entry.getValue(), entry.getKey());
    }
    for (int i = 0; i < builder.length(); ) {
      // 小型计数，字符串匹配使用
      int counter = 1;
      String code = null;
      // 编码
      while (true) {
        code = builder.substring(i, i + counter);
        if (decodedMap.containsKey(code)) {
          list.add(decodedMap.get(code));
          break;
        }
        counter++;
      }
      i += counter;
    }
    byte[] decodedBytes = new byte[list.size()];
    for (int i = 0; i < list.size(); i++) {
      decodedBytes[i] = list.get(i);
    }
    return decodedBytes;
  }

  /**
   * 将压缩编码完的byte 还原成二进制组成的字符串
   *
   * @param b 解码的字节数
   * @param flag 这个byte数值 是否按照八位编码的
   * @return
   */
  private static String byteToBitString(byte b, boolean flag) {
    int temp = b;
    // 如果flag为true，说明是以八位编码的，所以我们要补码，补后八位
    if (flag) {
      temp |= 256;
    }
    String s = Integer.toBinaryString(temp);
    return flag ? s.substring(s.length() - 8) : s;
  }

  /**
   * 通过传入的string 获取根据霍夫曼树编码压缩后的byte数组
   *
   * @param content
   * @return
   */
  public static byte[] huffmanZipCode(String content) {

    if (content == null || content.length() < 1) {
      throw new RuntimeException("string 不能为空");
    }
    // 根据字符串获取byte[]数组
    byte[] contentBytes = content.getBytes();
    // 生成霍夫曼树编码
    Map<Byte, String> huffmanCodes =
        getHuffmanCodes(createHuffmanTree(getHuffmanNodes(contentBytes)));
    // 生成压缩后的byte数组
    return zipCode(contentBytes, huffmanCodes);
  }

  public static byte[] huffmanZipCode(byte[] bytes) {
    if (bytes == null || bytes.length < 1) {
      throw new RuntimeException("数组不能为空");
    }
    // 生成霍夫曼树编码
    Map<Byte, String> huffmanCodes = getHuffmanCodes(createHuffmanTree(getHuffmanNodes(bytes)));
    return zipCode(bytes, huffmanCodes);
  }

  /**
   * 通过霍夫曼编码表，将一个String生成的byte[] 压缩
   *
   * @param bytes 原string 的byte数组
   * @param huffmancode
   * @return
   */
  public static byte[] zipCode(byte[] bytes, Map<Byte, String> huffmancode) {

    if (bytes == null || bytes.length < 1 || huffmancode == null) {
      throw new RuntimeException("参数异常");
    }

    StringBuilder builder = new StringBuilder();
    // 循环byte数组，将数组元素进行编码，->String
    for (byte b : bytes) {
      builder.append(huffmancode.get(b));
    }
    //    System.out.println(builder.length());
    // 将string（0100...二进制）按照八位一组转化成byte数组（压缩）
    // 计算分组长度
    int len = (builder.length() + 7) / 8;
    byte[] zipcode = new byte[len + 1];
    // 纪录当前数组位置
    int index = 0;
    // 纪录最后一个字节0的个数0010 还是010?... 为了解码
    int zereCount = 0;
    // 按照八位步长进行切片
    for (int i = 0; i < builder.length(); i += 8) {
      // 按照八位一组 i+8可能string 越界
      String code = (i + 8) > builder.length() ? builder.substring(i) : builder.substring(i, i + 8);
      // 最后一位不足八位，纪录最后0的个数
      if (i + 8 > builder.length() && builder.length() - 1 - i > 1) {
        String s = builder.substring(i);
        for (int k = 0; k < s.length(); k++) {

          if (s.charAt(k) == '0') {
            zereCount++;
          }
          if (s.charAt(k) == '1') {
            break;
          }
        }
      }
      // 0010 010 ->2 注意
      zipcode[index] = (byte) Integer.parseInt(code, 2);
      index++;
    }
    zipcode[zipcode.length - 1] = (byte) zereCount;
    return zipcode;
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

package huffmancode;

/** @Author: 云萧YYY @DateTime: 2021/08/29 @Description: 霍夫曼编码的结点 */
public class Node implements Comparable<Node> {

  private Byte ch;
  // 权重
  private Integer weight;
  private Node left;
  private Node right;

  public Node(Byte ch, Integer weight) {
    this.ch =  ch;
    this.weight = weight;
  }

    public Byte getCh() {
        return ch;
    }

    public void setCh(Byte ch) {
        this.ch = ch;
    }

    public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
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
    return "Node{" + "ch=" + ch + ", weight=" + weight + '}';
  }

  @Override
  public int compareTo(Node o) {
    return this.weight - o.getWeight();
  }
}

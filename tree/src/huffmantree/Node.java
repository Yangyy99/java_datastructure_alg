package huffmantree;

/**
 * @Author: 云萧YYY
 * @DateTime: 2021/08/28
 * @Description: 霍夫曼树的带权结点
 */
public class Node implements Comparable<Node> {

    private int value;

    private Node left;
    private Node right;

    public Node(int value){
        this.value=value;
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
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }
}

package threadedtree;

/**
 * @Author: 云萧YYY
 * @DateTime: 2021/08/25
 * @Description: 线索化树的结点
 */
public class Node {

    private int data;
    private Node left;
    private Node right;
    //0表示左子树 ，1表示前驱节点
    private int leftType;
    //0表示右子树，1表示后继结点
    private int rightType;

    public Node(int data){
        this.data=data;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
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

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "" +
                "data=" + data +
                ", leftType=" + leftType +
                ", rightType=" + rightType +
                '}';
    }
}

package josepfu;

/**
 * @Author: 云萧YYY
 * @DateTime: 2021/08/04
 * @Description: 孩子结点  完成josepfu问题
 */
public class BoyNode {

    private int no;
    private BoyNode next;

    public BoyNode(int no){
        this.no=no;
    }
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public BoyNode getNext() {
        return next;
    }

    public void setNext(BoyNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "BoyNode{" +
                "no=" + no +
                '}';
    }
}

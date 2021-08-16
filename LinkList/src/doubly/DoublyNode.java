package doubly;

/**
 * @Author: 云萧YYY
 * @DateTime: 2021/08/04
 * @Description: 双向链表的结点
 */
public class DoublyNode <T>{

    private T data;
    private DoublyNode<T> next=null;
    private DoublyNode<T> pre=null;

    public DoublyNode(T data){
        this.data=data;
    }
    public DoublyNode(){}
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoublyNode<T> getNext() {
        return next;
    }

    public void setNext(DoublyNode<T> next) {
        this.next = next;
    }

    public DoublyNode<T> getPre() {
        return pre;
    }

    public void setPre(DoublyNode<T> pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "DoublyNode{" +
                "data=" + data +
                '}';
    }
}

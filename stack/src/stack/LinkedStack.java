package stack;

/** @Author: 云萧YYY @DateTime: 2021/08/05 @Description: 链表模拟stack */
public class LinkedStack {

  private Node head;

  public LinkedStack() {
    head = new Node(0, null);
  }

  public void push(int value) {

    Node node = new Node(value, null);
    // 开始第一个结点
    if (head.getNext()==null){
        head.setNext(node);
        return;
    }
    // 获取最后一个结点的前一个结点
    Node point = endPointPrevious();
    point.getNext().setNext(node);
  }

  public int pop() {
    if (head == null) {
      throw new RuntimeException("stack is empty");
    }
    Node previous = endPointPrevious();
    int value = previous.getNext().getValue();
    //
    previous.setNext(null);
    return value;
  }

  /**
   * ，返回最后一个结点的前一个结点
   *
   * @return
   */
  public Node endPointPrevious() {

    Node temp = head;
    while (true) {
      // 头结点
      if (head.getNext() == null) {
        break;
      }
      if (temp.getNext().getNext() == null) {
//        temp = temp.getNext();
        break;
      }
      temp=temp.getNext();
    }
    return temp;
  }

  public void show() {
    if (head.getNext() == null) {
      System.out.println("stack  is  empty");
    }
    // 倒叙输出
    for (int size = size() - 1; size > 0; size--) {
      //
      System.out.print(getPointByIndex(size).getValue() + ",");
    }
  }

  public Node getPointByIndex(int index) {
    if (index < 0 || index > size()) {
      throw new RuntimeException("index is bad");
    }
    Node temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.getNext();
    }
    return temp;
  }

  public int size() {
    if (head.getNext() == null) {
      return 0;
    }
    int count = 0;
    Node temp = head;
    while (temp != null) {
      count++;
      temp = temp.getNext();
    }
    return count;
  }
}

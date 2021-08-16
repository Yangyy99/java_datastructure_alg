package doubly;

/** @Author: 云萧YYY @DateTime: 2021/08/04 @Description: 模拟双向链表 */
public class DoublyLinkedList<T> {

  /** 头结点 */
  private DoublyNode<T> head;

  public DoublyLinkedList() {
    this.head = new DoublyNode<T>();
  }

  /** * 从链表尾部添加结点 */
  public void add(DoublyNode node) {

    DoublyNode temp = head;
    while (true) {
      // 到达尾部
      if (temp.getNext() == null) {
        node.setPre(temp);
        temp.setNext(node);
        return;
      }
      temp = temp.getNext();
    }
  }

  /**
   * 根据索引更新结点
   *
   * @param index
   * @param data
   */
  public void updateByIndex(int index, T data) {

    if (index < 0 || index > size()) {
      throw new RuntimeException("index 不合理");
    }
    // 指向要本身的指针
    DoublyNode temp = head.getNext();
    for (int i = 0; i < index; i++) {
      //
      temp = temp.getNext();
    }
    temp.setData(data);
  }

  public void addByIndex(int index, DoublyNode node) {

    DoublyNode temp = getNode(index);
    DoublyNode pointer = temp.getPre();
    pointer.getNext().setPre(node);
    node.setNext(pointer.getNext());
    node.setPre(pointer);
    pointer.setNext(node);
  }

  /**
   * 删除index 位置的结点
   *
   * @param index
   */
  public void delete(int index) {

    if (index < 0 || index > size()) {
      throw new RuntimeException("index 不合理");
    }
    DoublyNode node = getNode(index);

    node.getPre().setNext(node.getNext());
    // 防止删除最后一个结点时候空指针异常了
    if (node.getNext() != null) {
      node.getNext().setPre(node.getPre());
    }
  }

  public DoublyNode getNode(int index) {

    if (index < 0 || index > size()) {
      throw new RuntimeException("index 不合理");
    }
    DoublyNode temp = head;
    for (int i = 0; i < index; i++) {
      //
      temp = temp.getNext();
    }
    return temp;
  }

  /**
   * * 目前双向链表中结点个数
   *
   * @return
   */
  public int size() {
    if (head.getNext() == null) {
      return 0;
    }
    int size = 0;
    DoublyNode temp = head.getNext();
    while (temp != null) {
      size++;
      temp = temp.getNext();
    }
    return size;
  }

  public void show() {

    if (head == null) {
      System.out.println("链表为空");
      return;
    }
    DoublyNode temp = head.getNext();
    while (temp != null) {
      System.out.println(temp);
      temp = temp.getNext();
    }
  }
}

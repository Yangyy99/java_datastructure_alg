import doubly.DoublyLinkedList;
import doubly.DoublyNode;

/**
 * @Author: 云萧YYY
 * @DateTime: 2021/08/04
 * @Description: 双向链表测试
 */
public class DoublyTest {

  public static void main(String[] args) {
    //
      DoublyNode<Integer> node1=new DoublyNode<>(1);
      DoublyNode<Integer> node2=new DoublyNode<>(2);
      DoublyNode<Integer> node3=new DoublyNode<>(3);
      DoublyNode<Integer> node4=new DoublyNode<>(4);

      DoublyLinkedList list=new DoublyLinkedList();
      list.add(node1);
      list.add(node2);
      list.add(node3);
    list.addByIndex(1,node4);
     // list.delete(3);
//      list.updateByIndex(1,4);
      list.show();

  }
}

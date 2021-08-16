import single.HeroNode;
import single.SingleLinkList;

/** @Author: 云萧YYY @DateTime: 2021/08/03 @Description: 做个小测试 */
public class LinkListTest {

  public static void main(String[] args) {


    // 创建结点
    HeroNode heroNode1 = new HeroNode(1, "松江", "及时雨");
    HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
    HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
    HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
    HeroNode heroNode4x = new HeroNode(4, "林冲", "豹子头");

    HeroNode heroNode5 = new HeroNode(5, "5", "5");
    HeroNode heroNode6 = new HeroNode(6, "6", "6");
    HeroNode heroNode7 = new HeroNode(7, "7", "7");
    // 创建链表
    SingleLinkList singleLinkList = new SingleLinkList();

    SingleLinkList singleLinkList1 = new SingleLinkList();

    singleLinkList1.addByOrder(heroNode4x);
    singleLinkList1.addByOrder(heroNode5);
    singleLinkList1.addByOrder(heroNode6);
    singleLinkList1.addByOrder(heroNode7);

    singleLinkList.addByOrder(heroNode1);
    singleLinkList.addByOrder(heroNode4);
    singleLinkList.addByOrder(heroNode2);
    singleLinkList.addByOrder(heroNode3);


    System.out.println("合并之前:");
    singleLinkList.list();
    System.out.println("================");
    singleLinkList1.list();
    System.out.println("合并之后");
    SingleLinkList linkList = mergeLinkedList(singleLinkList1.getHead(), singleLinkList.getHead());
    linkList.list();
  }

  /**
   * * 给一个链表的头节点，获取链表中有效的个数
   *
   * @param headNode
   * @return
   */
  public static int getLength(HeroNode headNode) {
    // 只带头节点的空链表
    if (headNode.next == null) {
      return 0;
    }
    int length = 0;
    // 辅助指针,指向头节点的下一个结点
    HeroNode temp = headNode.next;
    while (temp != null) {

      temp = temp.next;
      length++;
    }
    return length;
  }

  /**
   * * 合并两个链表
   *
   * @param head1
   * @param head2
   * @return
   */
  public static SingleLinkList mergeLinkedList(HeroNode head1, HeroNode head2) {

    if (head1 == null && head2 == null) {
      throw new RuntimeException("linkedList can't null ");
    }
    // 指向前一个元素
    HeroNode temp1 = head1;
    HeroNode temp2 = head2;
    // 指向操作结点的指针
    HeroNode node = null;
    //

    /** 以head1 结点 为合并链表的头结点 */
    while (temp1.next != null) {
      // 链表二不为空
      if (temp2.next != null) {
        // 结点相同
        if (temp1.next.getNo() == temp2.next.getNo()) {
          // 指针往下移动
          temp1 = temp1.next;
          temp2 = temp2.next;
          continue;
        }
        // 2 的结点插入到 1 的前面
        if (temp1.next.getNo() > temp2.next.getNo()) {

          node = temp2.next;
          // 将操作的结点从链表中剔除
          temp2.next = temp2.next.next;
          // 操作的结点 加入到1 链表中
          node.next = temp1.next;
          temp1.next = node;
          // 指针往下移动
          temp1 = temp1.next;
          continue;
        }

        if (temp1.next.getNo() < temp2.next.getNo()) {
          temp1 = temp1.next;
          continue;
        }
      } else {
        break;
      }
    }
    // 2 链表有剩余
    if (temp2.next != null) {
      // 加入到1最后
      temp1.next = temp2.next;
    }
    SingleLinkList linkList = new SingleLinkList();

    linkList.setHead(head1);

    return linkList;
  }
}

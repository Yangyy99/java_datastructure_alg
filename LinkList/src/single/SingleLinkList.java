package single;

import java.util.*;

/** @Author: 云萧YYY @DateTime: 2021/08/02 @Description: 模拟单链表 */
public class SingleLinkList {

  /** 创建头结点 */
  private HeroNode head = null;

  public SingleLinkList() {
    this.head = new HeroNode(0, "", "");
  }

  /**
   * * 往单链表添加结点 通过辅助指针，遍历循环到最后一个节点后添加新节点
   *
   * @param heroNode
   */
  public void addNode(HeroNode heroNode) {

    HeroNode temp = head;
    while (true) {

      if (temp.next == null) {
        temp.next = heroNode;
        break;
      }
      temp = temp.next;
    }
  }

  /**
   * * 按照编号顺序进入插入
   *
   * @param heroNode
   */
  public void addByOrder(HeroNode heroNode) {

    // 辅助指针
    HeroNode temp = head;
    // 标记 编号是否存在 默认为false  不存在
    boolean flag = false;
    while (true) {
      // 说明最后一个就可以插入 ，尾结点比较特殊
      if (temp.next == null) {
        break;
      }
      // 说明插入的位置在
      if (temp.next.getNo() > heroNode.getNo()) {
        break;
      }
      if (temp.next.getNo() == heroNode.getNo()) {
        flag = true;
        break;
      }
      temp = temp.next;
    }
    if (!flag) {
      heroNode.next = temp.next;
      temp.next = heroNode;
    } else {
      System.out.println("该编号 已经存在 ！ 不能插入");
    }
  }

  public void updateNode(HeroNode newHeroNode) {
    // 查看这个链表状态 是否为空
    if (head.next == null) {
      System.out.println("队列为空~");
      return;
    }
    // 指向头节点
    HeroNode temp = head;
    while (true) {
      // 说明该队列没有该节点
      if (temp.next == null) {
        return;
      }
      if (temp.next.getNo() == newHeroNode.getNo()) {
        break;
      }
      temp = temp.next;
    }
    temp.next.setName(newHeroNode.getName());
    temp.next.setNickName(newHeroNode.getNickName());
  }

  public void deleteNode(int no) {

    // 判断链表是否为空
    if (head.next == null) {
      throw new RuntimeException("linked single is empty ");
    }
    HeroNode tempNode = head;
    while (true) {
      if (tempNode.next == null) {
        System.out.println("the node not exist in the linked single");
        return;
      }
      if (tempNode.next.getNo() == no) {
        break;
      }
      tempNode = tempNode.next;
    }
    tempNode.next = tempNode.next.next;
  }

  /**
   * * 获取该链表中的有效结点个数
   *
   * @return
   */
  public int getLength() {
    if (head.next == null) {
      return 0;
    }
    int length = 0;
    HeroNode cur = head.next;
    while (cur != null) {
      length++;
      cur = cur.next;
    }
    return length;
  }

  /**
   * * 新浪面试题 获取链表中倒数第K个结点
   *
   * @param index 倒数第k个
   */
  public HeroNode getHeroNodeWithLastIndex(int index) {
    int length = getLength();
    if (index < 0 || index > length) {
      throw new RuntimeException("indexOutOfBound");
    }
    // 表示当前索引
    int pointer = 0;
    HeroNode temp = head.next;
    while (!(pointer == (length - index))) {
      pointer++;
      temp = temp.next;
    }
    return temp;
  }

  /** * 腾讯面试题 反转链表 */
  public void reverseLinkedList() {

    // 指向操作结点的前一个结点
    HeroNode node = head;
    // 反转头节点 临时变量
    HeroNode reverseNode = new HeroNode(0, "", "");
    // 遍历原链表
    while (node.next != null) {
      // 指向当前操作的结点
      HeroNode temp = node.next;
      // 移动指针，指向下一个结点
      node.next = node.next.next;
      // 将原链表的结点 添加到reversNode头结点后
      temp.next = reverseNode.next;
      reverseNode.next = temp;
    }
    // 将头结点指向reverseNode 后面
    head.next = reverseNode.next;
  }

  /**
   * 反转链表
   * @return
   */
  public HeroNode reverse(HeroNode head){

    HeroNode temp=head.next;
    Stack<HeroNode> stack=new Stack<>();
    while(temp!=null){
      stack.push(
              temp
      );
      temp=temp.next;
    }
    temp=head;
    while(!stack.isEmpty()){
      temp.next=stack.pop();
      temp=temp.next;
    }
    temp.next=null;
    return head;
  }



  /**
   * * 从末尾到头打印单链表 百度面试题 反转打印单链表 要求方式： 1.反向遍历 不建议 通过反转单链表进行 遍历 破坏原数据结构 2 . stack 堆栈方式 推荐 逆序考虑stack
   * 数据结构
   */
  public void printWithReverse() {
    // 方式2 通过stack
    Stack stack = new Stack();
    // 指向当前
    HeroNode temp = head.next;
    while (temp != null) {
      stack.push(temp);
      temp = temp.next;
    }
    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }

  /** 打印链表 */
  public void list() {
    if (head.next == null) {
      System.out.println(" link single is empty ");
      return;
    }
    HeroNode temp = head.next;
    while (true) {
      if (temp == null) {
        break;
      }
      System.out.println(temp);
      temp = temp.next;
    }
  }

  public HeroNode getHead() {
    return head;
  }

  public void setHead(HeroNode head) {
    this.head = head;
  }
}

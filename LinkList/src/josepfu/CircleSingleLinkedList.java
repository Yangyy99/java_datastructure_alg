package josepfu;

/** @Author: 云萧YYY @DateTime: 2021/08/04 @Description: 模拟解决约瑟夫问题 ，创建环形链表 不带头结点的环形链表 first它是变化的 */
public class CircleSingleLinkedList {

  /** 创建一个初始结点 */
  private BoyNode first = null;
  /** 指向当前结点 */
  private BoyNode cur = null;

  /**
   * * 初始化构建环形链表
   *
   * @param nums 表示添加孩子节点的个数 比如说 创建一个nums个的环形链表，多少个孩子围坐在一起
   */
  public void add(int nums) {
    // 说明创建孩子人数至少有一个
    if (nums < 1) {
      throw new RuntimeException("num值不能小于1");
    }
    // 编号从1开始
    for (int num = 1; num <= nums; num++) {
      //
      BoyNode boy = new BoyNode(num);
      // 如果是开始链表是kong的
      if (first == null) {
        first = boy;
        boy.setNext(boy);
        cur = boy;
      } else {

        // 不为空，链表中至少有一个
        cur.setNext(boy);
        cur = boy;
        cur.setNext(first);
      }
    }
  }

  /**
   * 约瑟夫问题
   *
   * @param k 从k的编号 开始
   * @param m 报m个数
   */
  public void josepfu(int k, int m) {

    if (k < 1 || m < 0 || k > size()) {
      throw new RuntimeException("k,m 不合理");
    }
    // 定义辅助结点 ，将辅助结点移动到最后一个位置
    BoyNode helper = this.getLastNode();
    // 移动helper，first指针，将first指向开始报数的人
    // first 移动到第k个人上
    for (int i = 0; i < k - 1; i++) {
      first = first.getNext();
      helper = helper.getNext();
    }
    // 开始报数，出链表
    while (true) {
      // 只剩下一个结点了
      if (first.getNext() == first) {
        System.out.print("最后一个出列" + first);
        return;
      }
      // 找到第m个人
      for (int j = 0; j < m - 1; j++) {
        first = first.getNext();
        helper = helper.getNext();
      }
      // 移动结点
      System.out.print(first + "出列了" + ",\t\r\n");
      first = first.getNext();
      helper.setNext(first);
    }
  }

  /**
   * 返回最后一个结点位置
   *
   * @return
   */
  private BoyNode getLastNode() {
    if (first == null) {
      System.out.println("循环链表为空");
    }
    BoyNode end = first;
    do {
      end = end.getNext();
    } while (end.getNext() != first);
    return end;
  }

  public int size() {
    int count = 0;
    if (first == null) {
      return count;
    }
    cur = first;
    do {
      count++;
      cur = cur.getNext();
    } while (cur != first);
    cur = null;
    return count;
  }

  /** 打印一下当前链表 */
  public void printList() {

    if (first == null) {
      return;
    }
    // 辅助指针
    cur = first;
    do {
      System.out.println(cur);
      cur = cur.getNext();
    } while (cur != first);
  }
}

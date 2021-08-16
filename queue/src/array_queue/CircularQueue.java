package array_queue;

/** @Author: 云萧YYY @DateTime: 2021/08/01 @Description: 循环队列 */
public class CircularQueue {

  /** 最大存放数量 */
  private int maxSize;
  /** 入队指针 队尾 指向最后一个元素的下一个元素 */
  private int rear = 0;
  /** 出队指针 开始指向第一个元素, */
  private int front = 0;
  /** 存放数组的指针 */
  private int[] queue;

  /**
   * 通过构造器初始化 数组，出入队指针
   *
   * @param maxSize
   */
  public CircularQueue(int maxSize) {

    this.maxSize = maxSize;
    this.queue = new int[maxSize];
  }

  /**
   * 队列是否为空
   *
   * @return
   */
  private boolean isEmpty() {

    return rear == front;
  }

  /**
   * 队列是否为满
   *
   * @return
   */
  private boolean isFull() {

    return (rear + 1) % maxSize == front;
  }

  /**
   * 入队
   *
   * @param value
   */
  public void addQueue(int value) {

    // 队列是否满了
    if (isFull()) {
      System.out.println("队列满了");
      return;
    }
    queue[rear] = value;
    rear = (rear + 1) % maxSize;
  }

  /**
   * 出队列
   *
   * @return
   */
  public int deQueue() {
    // 队列是否是空的
    if (isEmpty()) {
      throw new RuntimeException("队列是空的，没有数据~");
    }
    int val = queue[front];
    front = (front + 1) % maxSize;
    return val;
  }

  /** 展示队列 */
  public void show() {
      // 通过位移量进行遍历 ，开始位置+ 位移量（数据个数）
    for (int i = front; i <front+size(); i++) {
      //  逻辑环形遍历
      System.out.printf("queue[%d]=%d,",i%maxSize,queue[i%maxSize]);
    }
    System.out.println();
  }

  /**
   * 显示当前队列数据个数
   * @return
   */
  public int size(){
    return (rear-front+maxSize)%maxSize;
  }

  /** 查看第一个元素 */
  public void peekHeadQueue() {
    System.out.println("队列头元素为:" + this.queue[front]);
  }

}

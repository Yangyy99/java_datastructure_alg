package array_queue;

/** @Author: 云萧YYY @DateTime: 2021/08/01 @Description: 简单通过数组实现队列，但不是循环队列  */
public class ArrayQueue {

  /** 最大存放数量 */
  private int maxSize;
  /** 入队指针 队尾 */
  private int rear;
  /** 出队指针 指向对头, */
  private int front;
  /** 存放数组的指针 */
  private int[] queue;

  /**
   * 通过构造器初始化 数组，出入队指针
   *
   * @param maxSize
   */
  public ArrayQueue(int maxSize) {

    this.maxSize = maxSize;
    this.queue = new int[maxSize];
    this.rear = -1;
    // 指向队列前面前一个位置
    this.front = -1;
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
    return rear == maxSize - 1;
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
    rear++;
    this.queue[rear] = value;
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

    return this.queue[++front];
  }

  /** 展示队列 */
  public void show() {
    for (int i = front+1; i <=rear; i++) {
      //
      if (this.queue[i] != 0) {
        System.out.printf("queue[%d]=%d\n", i, this.queue[i]);
      }
    }
  }

  /** 查看第一个元素 */
  public void peekHeadQueue() {
    System.out.println("队列头元素为:" + this.queue[front+1]);
  }
}

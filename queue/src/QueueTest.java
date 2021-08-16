import array_queue.ArrayQueue;
import array_queue.CircularQueue;

import java.util.Scanner;

/** @Author: 云萧YYY @DateTime: 2021/08/01 @Description: 测试所编写的队列 */
public class QueueTest {
  public static void main(String[] args) throws InterruptedException {
    // arrayQueue
    // ArrayQueue queue = new ArrayQueue(5);
    CircularQueue queue = new CircularQueue(5);
    char key = ' ';
    Scanner input = new Scanner(System.in);
    boolean loop = true;

    while (loop) {

      System.out.println("e(exit) 退出程序");
      System.out.println("h(head) 首部元素");
      System.out.println("a(addQueue) 入队列");
      System.out.println("d(deQueue) 出队列");
      System.out.println("s(show) 展示队列全部数据");
      System.out.println("请输入你要操作的指令");

      key = input.next().charAt(0);

      switch (key) {
        case 'e':
          {
            input.close();
            System.out.println("已经退出");
            loop = false;
            break;
          }
        case 'h':
          {
            queue.peekHeadQueue();
            break;
          }
        case 'a':
          {
            System.out.println("请输入你要存入的数据");
            int value = input.nextInt();
            queue.addQueue(value);
            Thread.sleep(200);
            break;
          }
        case 'd':
          {
            System.out.println("出队列元素:" + queue.deQueue());
            break;
          }
        case 's':
          {
            queue.show();
          }
      }
    }
  }
}

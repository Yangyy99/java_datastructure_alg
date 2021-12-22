package code.A1B2C3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 云萧YYY
 * @DateTime: 2021/12/22
 * @Description: TODO 两个线程 交替输出的问题
 */
public class ReetreanLock {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition number = lock.newCondition();
        Condition letter = lock.newCondition();
        char[] a = "abcde".toCharArray();
        char[] ac = "12345".toCharArray();
        new Thread(() -> {
            lock.lock();
            for (char c : a) {
                System.out.print(c);
                try {
                    number.signal();
                    letter.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }).start();

        new Thread(() -> {
            lock.lock();
            for (char c : ac) {
                System.out.print(c);

                try {
                    letter.signal();
                    number.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.unlock();
        }).start();
    }
}

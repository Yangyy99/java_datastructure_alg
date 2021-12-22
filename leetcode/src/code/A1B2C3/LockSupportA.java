package code.A1B2C3;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author: 云萧YYY
 * @DateTime: 2021/12/22
 * @Description: 两个线程 交替输出的问题
 */
public class LockSupportA {
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {

        char[] a = "abcde".toCharArray();
        char[] ac = "12345".toCharArray();

        t1 = new Thread(() -> {

            for (char c : a) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();

            }

        });

        t2 = new Thread(() -> {
            for (char c : ac) {
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);
            }
        });
        t1.start();
        t2.start();


    }

}

package code.philosopher;

/**
 * @Author: 云萧YYY
 * @DateTime: 2021/12/22
 * @Description: 哲学家就餐问题 ，--- >
 */
public class PhilosopherChopsticks {

    public static void main(String[] args) {
        Chopsticks c1 = new Chopsticks();
        Chopsticks c2 = new Chopsticks();
        Chopsticks c3 = new Chopsticks();
        Chopsticks c4 = new Chopsticks();
        Chopsticks c5 = new Chopsticks();

        Philosopher p1 = new Philosopher("p1", 0, c1, c2);
        Philosopher p2 = new Philosopher("p2", 1, c2, c3);
        Philosopher p3 = new Philosopher("p3", 2, c3, c4);
        Philosopher p4 = new Philosopher("p4", 3, c4, c5);
        Philosopher p5 = new Philosopher("p5", 4, c5, c1);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
    }


}

class Chopsticks {

}

class Philosopher extends Thread {

    private String name;
    private Integer no;
    private final Chopsticks left;
    private final Chopsticks right;

    public Philosopher(String name, Integer no, Chopsticks left, Chopsticks right) {
        this.name = name;
        this.no = no;
        this.left = left;
        this.right = right;
    }

    /**
     * 哲学家 就餐 , 奇数编号 先拿左边 偶数 先拿右边 ,这样子可以同时有两个人拿筷子
     * 筷子就是锁
     */
    @Override
    public void run() {
        if (no % 2 == 0) {
            synchronized (left) {
                synchronized (right) {
                    System.out.println(this.name + "----->" + this.no);
                }
            }
        } else {
            synchronized (right) {
                synchronized (left) {
                    System.out.println(this.name + "----->" + this.no);
                }
            }
        }
    }
}

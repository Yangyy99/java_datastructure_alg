package threadedtree;

/** @Author: 云萧YYY @DateTime: 2021/08/26 @Description: 测试线索化 */
public class Test {

  public static void main(String[] args) {

    ThreadedBinaryTree tree = new ThreadedBinaryTree(5);
    tree.add(6);
    tree.add(3);
    tree.add(2);
    tree.add(1);
    tree.add(8);
    tree.add(7);
    // 线索化
    tree.preThread();
    //System.out.println(tree.preSearch(6));

  tree.preOrder();
  }
}

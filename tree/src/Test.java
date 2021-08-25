/** @Author: 云萧YYY @DateTime: 2021/08/24 @Description: 测试类 */
public class Test {
  public static void main(String[] args) {
    //
    BinaryTree tree = new BinaryTree(1);
    tree.add(3);
    tree.add(2);
    tree.add(5);

    tree.preOrder();
    tree.delete(5);
    System.out.println();
    tree.preOrder();

  }
}

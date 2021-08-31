package bstree;

/** @Author: 云萧YYY @DateTime: 2021/08/31 @Description: 二叉排序树 */
public class Test {

  public static void main(String[] args) {

    BinarySortTree bstree = new BinarySortTree();
    int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
    for (int i = 0; i < arr.length; i++) {
      bstree.add(arr[i]);
    }
    bstree.midOrder();
    bstree.delete(3);
    System.out.println();
    bstree.midOrder();
  }
}

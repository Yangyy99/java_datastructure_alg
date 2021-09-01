package avltree;

/** @Author: 云萧YYY @DateTime: 2021/09/01 @Description: TODO */
public class Test {
  public static void main(String[] args) {

    int[] arr = {4, 3, 6, 5, 7, 8};
    AVLTree avlTree = new AVLTree();
    for (int i = 0; i < arr.length; i++) {
      //
      avlTree.add(arr[i]);
    }
    avlTree.midOrder();
  }
}

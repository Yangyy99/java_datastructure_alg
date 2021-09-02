package avltree;

/** @Author: 云萧YYY @DateTime: 2021/09/01 @Description: TODO */
public class Test {
  public static void main(String[] args) {

    // int[] arr = {4, 3, 6, 5, 7, 8};
    // int[] arr = {10, 12, 8, 9, 7, 6};
    int[] arr = {10, 9, 11, 6, 12, 5, 13, 14};
    AVLTree avlTree = new AVLTree();
    for (int i = 0; i < arr.length; i++) {
      //
      avlTree.add(arr[i]);
    }
    avlTree.delete(12);
    avlTree.preOrder();
    System.out.println();
    System.out.println(avlTree.depthTree(avlTree.getRoot()));
    System.out.println(avlTree.depthTree(avlTree.getRoot().getLeft()));
    System.out.println(avlTree.depthTree(avlTree.getRoot().getRight()));
  }
}

package binarytree;

/**
 * @Author: 云萧YYY
 * @DateTime: 2021/08/24
 * @Description: 树的结点
 */
public class TreeNode {

     private int value;
     private TreeNode left;
     private TreeNode right;

     public TreeNode(int value){
         this.value=value;
     }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "binarytree.TreeNode{" +
                "value=" + value +
                '}';
    }
}
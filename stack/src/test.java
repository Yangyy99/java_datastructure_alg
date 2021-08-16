import stack.ArrayStack;
import stack.LinkedStack;

/** @Author: 云萧YYY @DateTime: 2021/08/05 @Description: TODO */
public class test {

  public static void main(String[] args) {
    //
    //ArrayStack stack = new ArrayStack(5);
    LinkedStack stack=new LinkedStack();
    stack.push(5);
    stack.push(4);
    stack.push(3);
    stack.show();
    System.out.println();
    int val = stack.pop();
    int val1 = stack.pop();
    int val2= stack.pop();
    System.out.println(val);

    stack.show();



  }
}

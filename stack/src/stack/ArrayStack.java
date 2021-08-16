package stack;

/** @Author: 云萧YYY @DateTime: 2021/08/05 @Description: 使用数组来模拟stack */
public class ArrayStack {

  private int maxSize;
  /** top 为栈顶指针 */
  private int top = -1;

  private int[] stack;
  // 初始化stack
  public ArrayStack(int maxSize) {
    this.maxSize = maxSize;
    this.stack = new int[maxSize];
  }

  public boolean isFull() {
    return top == maxSize - 1;
  }

  public boolean isEmpty() {
    return top == -1;
  }

  public void push(int value) {
    if (isFull()) {
      System.out.println("stack is full");
      return;
    }
    stack[++top]=value;
  }

  public int pop(){
      if (isEmpty()){
          throw new RuntimeException("stack is empty");
      }
      return stack[top--];
  }

  public int size(){
      return top+1;
  }

  public void show(){

    for (int i = 0; i <= top; i++) {
      //
      System.out.printf("stack["+i+"]="+stack[top]);
    }
  }

  public int peek(){
    return stack[top];
  }


}

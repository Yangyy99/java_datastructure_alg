package calculator;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import stack.ArrayStack;

/**
 * @Author: 云萧YYY @DateTime: 2021/08/09 @Description: 为了模拟计算器而创建的栈结构,通过继承自己写过的ArrayStack，拓展一些独有的功能
 */
public class CalculatorStack extends ArrayStack {

  public CalculatorStack(int maxSize) {
    super(maxSize);
  }

  /**
   * 判断给定运算符的优先级，在这里的规则是数字越大优先级越高
   *
   * @return
   */
  public int priority(int oper) {

    if (oper == '*' || oper == '/') {
      return 2;
    } else if (oper == '+' ) {
      return 0;
    } else if (oper == '-'){
      return 1;
    }else{
      return -1;
    }
  }

  // 判断是不是运算符 + - * /
  public boolean isOperator(char oper) {
    return oper == '*' || oper == '/' || oper == '+' || oper == '-';
  }

  // 计算两个数 返回计算结果
  public int cal(int num1, int num2, int oper) {

    int res = 0; // 存放计算结果
    switch (oper) {
      case '+':
        res = num1 + num2;
        break;
      case '-':
        res = num2 - num1;
        break;
      case '*':
        res = num1 * num2;
        break;
      case '/':
        res = num2 / num1;
        break;
      default:
        break;
    }
    return res;
  }



}

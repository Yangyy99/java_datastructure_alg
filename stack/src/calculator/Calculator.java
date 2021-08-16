package calculator;

/** @Author: 云萧YYY @DateTime: 2021/08/10 @Description: 使用stack 完成对四则公式的计算 */
public class Calculator {

  public static void main(String[] args) {
    //
    String expresion = "90+5*2-20*2";
    int num1 = 0;
    int num2 = 0;
    int res = 0;
    int index = 0;
    char ch = 0;
    String keepNum = ""; //临时保存的数字
    CalculatorStack numStack = new CalculatorStack(10);
    CalculatorStack operStack = new CalculatorStack(10);
    // 扫描expresion 压栈
    while (true) {
      // 获取字符
      ch = expresion.substring(index, index + 1).charAt(0);
      // 判断是否为运算符
      if (operStack.isOperator(ch)) {
        if (!operStack.isEmpty()) {
          // 比较操作符的优先级
          if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
            // 弹出两个数字做运算
            num1 = numStack.pop();
            num2 = numStack.pop();
            res = numStack.cal(num1, num2, operStack.pop());
            // 结果压栈
            numStack.push(res);
            // 运算符压栈
            operStack.push(ch);
          } else {
            operStack.push(ch);
          }
        } else {
          // 若oper为空直接压栈
          operStack.push(ch);
        }
      } else {
        // 是数字，直接压栈，考虑数字是多位数字
        keepNum += ch;
        // 最后一位
        if (index == expresion.length() - 1) {
          numStack.push(Integer.parseInt(keepNum));
        } else {
          // 提前看一位
          if (operStack.isOperator(expresion.substring(index + 1, index + 2).charAt(0))) {
            numStack.push(Integer.parseInt(keepNum));
            keepNum = "";
          }
        }
        //  numStack.push(ch - 48);
      }
      index++;
      if (index >= expresion.length()) {
        break;
      }
    }
    // 计算结果
    while (!operStack.isEmpty()) {

      int temp1 = numStack.pop();
      int temp2 = numStack.pop();
      int opertemp = operStack.pop();
      if (operStack.size() == 0) {
        res = numStack.cal(temp1, temp2, opertemp);
        numStack.push(res);
        break;
      }
      if (operStack.priority(opertemp) < operStack.priority(operStack.peek())) {
        int opertemp2 = operStack.pop();
        int temp3 = numStack.pop();
        res = numStack.cal(temp2, temp3, opertemp2);
        numStack.push(res);
        numStack.push(temp1);
        operStack.push(opertemp);
      } else {
        res = numStack.cal(temp1, temp2, opertemp);
        // 结果压栈
        numStack.push(res);
      }
    }
    System.out.printf("表达式%s=%d", expresion, numStack.pop());
  }
}

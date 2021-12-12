package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/** @Author: 云萧YYY @DateTime: 2021/08/10 @Description: 使用stack 完成后缀表达式 ,逆波兰表达式的运算 */
public class PolishExpression {

  public static void main(String[] args) {

    // 中缀表达式转后缀表达式
    String inffix="4*5-8+60+8/2";
    List<String> infixExpressList = toInfixExpressList(inffix);
    System.out.println(infixExpressList);
    List<String> strings = parseSuffixList(infixExpressList);
    System.out.println(strings);
    int calculate = calculate(strings);
    System.out.println(calculate);
    // 这里为了方便我们每个数值与符号之间空个空格
   // String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
    // 放入list 通过list 遍历后缀表达式
//    List<String> list = getListByExpression(suffixExpression);
//    int calculate = calculate(list);
//    System.out.println(calculate);
    ArrayList a=new ArrayList();
    a.add(1);
  }

  public static List<String> getListByExpression(String suffixExpression) {
    // 分割
    String[] s = suffixExpression.split(" ");
    return Arrays.asList(s);
  }

  /**
   * 将一个中缀字符串转化为一个中缀集合List
   *
   * @param s
   * @return
   */
  public static List<String> toInfixExpressList(String s) {

    int index = 0;
    String str = ""; // 用来拼接的
    char c;
    List<String> list = new ArrayList<>();
    do {
      if ((c = s.charAt(index)) < 48 || (c = s.charAt(index)) > 57) {
        // 说明是字符
        list.add("" + c);
        index++;
      } else {
        // 判断多位数
        while (index < s.length() && (c = s.charAt(index)) >= 48 && (c = s.charAt(index)) <= 57) {
          str += c;
          index++;
        }
        list.add(str);
        str = "";
      }
    } while (index < s.length());
    return list;
  }

  /**
   * 将中缀表达式的list 转化成 后缀表达式的String
   *
   * @param insuffix
   * @return
   */
  public static List<String> parseSuffixList(List<String> insuffix) {

    // 运算符栈
    Stack<String> oper = new Stack<>();
    // 存放中间结果
    List<String> mid = new ArrayList<>();
    for (String s : insuffix) {

      // 如果是数值
      if (s.matches("\\d+")) {
        mid.add(s);
      } else if (oper.isEmpty() || "(".equals(oper.peek())) {
        oper.push(s);
      } else if (")".equals(s)) {
        // 消除括号
        while (!oper.isEmpty() && !"(".equals(oper.peek())) {
          // 弹出的直接加入list
          mid.add(oper.pop());
        }
        // 将小括号弹出去 (
        oper.pop();
      } else {
        // 比较优先级 该优先级小于栈顶优先级
        if (priority(s) <= priority(oper.peek())) {
          // 比栈顶优先级低 说明该运算符在栈顶元素下面 ，将栈顶元素弹出放入mid中
          mid.add(oper.pop());
          // 该运算符 加入到oper栈
        }
          oper.push(s);
        }
      }
    // 此时扫描完成了，然后将oper中元素全部加入 mid中
    while (!oper.isEmpty()) {
      mid.add(oper.pop());
    }
    return mid;
  }
  // 定义优先级
  public static int priority(String s) {

    switch (s) {
      case "*":
      case "/":
        return 2;
      case "-":
      case "+":
        return 1;
      default:
        throw new RuntimeException("该符号不存在");
    }
  }

  /**
   * 计算后缀表达式
   * @param list
   * @return
   */
  public static int calculate(List<String> list) {

    int res = 0;
    Stack<String> stack = new Stack<>();
    for (String s : list) {
      // 如果是数值 ,使用正则去匹配呢，jdk8中能够使用正则表达式进行匹配

      if (s.matches("\\d+")) {
        stack.push(s);
      } else {
        // 是操作符 那么就要计算了
        int num2 = Integer.parseInt(stack.pop());
        int num1 = Integer.parseInt(stack.pop());
        switch (s) {
          case "+":
            res = num1 + num2;
            break;
          case "-":
            res = num1 - num2;
            break;
          case "*":
            res = num1 * num2;
            break;
          case "/":
            res = num1 / num2;
            break;
        }
        stack.push("" + res);
      }
    }

    return Integer.parseInt(stack.pop());
  }
}

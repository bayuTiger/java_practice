package calc;

import java.util.Scanner;
import java.util.Stack;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calc {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    out: while (sc.hasNextLine()) {

      Stack<BigDecimal> stack = new Stack();
      String inFormula = sc.nextLine();

      // 入力チェック
      CheckFormula checkFormula = new CheckFormula();
      if (!checkFormula.isValidFormula(inFormula)) {
        System.out.println("数値 演算子 数値 演算子 数値 … の順に引数を指定してください");
        continue out;
      }
      System.out.println(checkFormula.isValidFormula(inFormula));

      // ConvertRpnクラスのgetRpnメソッドを実行してRpn式に変換する
      ConvertRpn convertRpn = new ConvertRpn();
      String rpnFormula = convertRpn.getRpn(inFormula);
      System.out.println("rpn式：" + rpnFormula);

      // Rpn式を整形したのち配列に変換
      FormatFormula format = new FormatFormula();
      String[] operand = format.format(rpnFormula);
      System.out.println("オペランドの長さ：" + operand.length);

      for (int i = 0; i < operand.length; i++) {
        switch (operand[i]) {
          case "+":
          case "-":
          case "*":
          case "/":
            BigDecimal a = stack.pop();
            BigDecimal b = stack.pop();
            BigDecimal result = new BigDecimal(0);
            if (operand[i].equals("+")) {
              result = a.add(b);
            } else if (operand[i].equals("-")) {
              result = a.subtract(b);
            } else if (operand[i].equals("*")) {
              result = a.multiply(b);
            } else if (operand[i].equals("/")) {
              result = b.divide(a, RoundingMode.HALF_UP);
            }
            stack.push(result);
            break;
          default:
            BigDecimal bdOperand = new BigDecimal(operand[i]);
            stack.push(bdOperand);
        }
      }
      System.out.println(stack.peek());
    }
  }
}

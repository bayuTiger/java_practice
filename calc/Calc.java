package calc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Calc{
  public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

    // 標準入力を1行ずつ読み出す。
    out: while (sc.hasNextLine()) {
      String line = sc.nextLine();
      // 半角スペースで区切る
      String[] arr = line.split(" ");
      BigDecimal total = new BigDecimal("0");
      // 入力項目数の確認
      if (arr.length < 3 || ((arr.length != 3) && (arr.length % 3 != 2))) {
        System.out.println("数値 半角スペース 演算子 半角スペース 数値 半角スペース … の順に最低3つの引数を指定してください");
        continue;
      }
      // 先頭の数値確認
      if (!checkNum(arr[0])) {
        System.out.println("数値 演算子 数値 演算子 数値 … の順に引数を指定してください");
        continue out;
      }
      // 数値変換
      total = new BigDecimal(arr[0]);
      for (int i = 0; i <= ((arr.length - 3) / 2); i++) {
        // 先頭の数値以降は一つとびに演算子と数値が続く
        // 先頭の数値以外の項目確認
        if (!checkOperator(arr[i * 2 + 1]) || !checkNum(arr[i * 2 + 2])) {
          System.out.println("数値 演算子 数値 演算子 数値 … の順に引数を指定してください");
          continue out;
        }
        // 数値変換
        BigDecimal argNumber = new BigDecimal(arr[i * 2 + 2]);
        // 演算子によってtotalに合算する処理を変更
        switch (arr[i * 2 + 1]) {
          case "+":
            total = total.add(argNumber);
            break;
          case "-":
            total = total.subtract(argNumber);
            break;
          case "*":
            total = total.multiply(argNumber);
            break;
          case "/":
            total = total.divide(argNumber, RoundingMode.HALF_UP);
        }
        System.out.println("合計:" + total);
      }
    }
    sc.close();
  }

  /**
   * 数値（整数または小数）チェック
   * 
   * @param str 検証対象の値
   * @return 結果（true：数値、false：数値ではない）
   */
  private static boolean checkNum(String str) {
    try {
      // double型へ変換し、エラーが出なければ数値とみなす
      Double.parseDouble(str);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  // 演算子チェック
  private static boolean checkOperator(String str) {

    if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
      return true;
    } else {
      return false;
    }

  }

}
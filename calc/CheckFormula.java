package calc;

public class CheckFormula {
  public boolean isValidFormula(String inFormula) {

    // 「()」を除外する
    String deletedOpenedBrackets = inFormula.replaceAll("\\(", "");
    String deletedClosedBrackets = deletedOpenedBrackets.replaceAll("\\)", "");

    // 全角スペースを半角スペースに置換する
    String convertHalfSpace = deletedClosedBrackets.replaceAll("  ", " ");

    // 文頭文末の半角スペースを除外する
    String deletedHalfSpaces = convertHalfSpace.trim();

    // 入力文字を半角スペースで区切る
    String[] arr = deletedHalfSpaces.split(" ");

    // 入力項目数の確認
    if (arr.length < 3 || ((arr.length != 3) && (arr.length % 3 != 2))) {
      return false;
    }

    // 先頭の数値確認
    if (!checkNum(arr[0])) {
      return false;
    }

    for (int i = 0; i <= ((arr.length - 3) / 2); i++) {
      // 先頭の数値以降は一つとびに演算子と数値が続く
      // 先頭の数値以外の項目確認
      if (!checkOperator(arr[i * 2 + 1]) || !checkNum(arr[i * 2 + 2])) {
        return false;
      }
    }

    return true;
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

package FunctionPractice;

import java.util.Random;

// 仕様
// - 関数名 generatePassword とする
// - 第二引数にtrueを渡したときは記号を含むパスワードを、falseを渡したときは数字だけのパスワードを生成する
// - 第一引数だけ指定しても動作するよう、関数のオーバーロードを活用してもう一つ関数を追加する。
//   第一引数だけ指定した場合、数字だけのパスワードを生成する。
// - 以下のコード実行時に例外が発生しないこと。

public class prac4 {
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) { // パスワードはランダム生成なので10回検証する
      String pass = generatePassword(6);
      assert pass.length() == 6;
      assert hasOnlyNumber(pass) == true;
      assert hasOnlyNumberOrPunctuation(pass) == true;

      pass = generatePassword(8, true);
      assert pass.length() == 8;
      assert hasOnlyNumber(pass) == false;
      assert hasOnlyNumberOrPunctuation(pass) == true;

      pass = generatePassword(10, false);
      assert pass.length() == 10;
      assert hasOnlyNumber(pass) == true;
      assert hasOnlyNumberOrPunctuation(pass) == true;
    }
  }

  private static boolean hasOnlyNumberOrPunctuation(String pass) {
    String regex = "0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    String[] arr = pass.split("");
    for (int i = 0; i < arr.length; i++) {
      if (!regex.contains(String.valueOf(arr[i]))) {
        System.out.println("false");
        return false;
      }
    }
    return true;
  }

  private static boolean hasOnlyNumber(String pass) {
    String num = "1234567890";
    String[] numbers = pass.split("");
    for (int i = 0; i < numbers.length; i++) {
      if (!num.contains(numbers[i])) {
        return false;
      }
    }
    return true;
  }

  private static String generatePassword(int i, boolean b) {

    StringBuilder temp = new StringBuilder();
    String pass = "";
    String regex = "0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    String[] array = regex.split("");
    Random rd = new Random();

    if (b == false) {
      pass = generatePassword(i);
      return pass;
    } else {
      for (int k = i; k > 0; k--) {
        int j = rd.nextInt(array.length);
        temp.append(array[j]);
      }
      pass = temp.toString();
      return pass;
    }

  }

  private static String generatePassword(int i) {
    String pass = "";
    String[] hands = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
    Random r = new Random();
    StringBuilder temp = new StringBuilder();
    for (int j = 0; j < i; j++) {
      String hand = hands[r.nextInt(9)];
      temp.append(hand);
    }
    pass = temp.toString();
    return pass;
  }
}

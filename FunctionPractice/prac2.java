package FunctionPractice;

// 仕様
// - 関数名 hasOnlyNumber とする。
// - 第一引数には String を取る
// - 渡された文字列がすべて数字で構成されていればtrue。数字以外の値が含まれていればfalseを返す。
// - 以下のコード実行時に例外が発生しないこと。

public class prac2 {
  public static void main(String[] args) {

    assert hasOnlyNumber("123456") == true;
    assert hasOnlyNumber(" 123") == false;
    assert hasOnlyNumber("123 ") == false;
    assert hasOnlyNumber("1.23") == false;
    assert hasOnlyNumber("123a45") == false;
    assert hasOnlyNumber("a1234") == false;

  }

  public static boolean hasOnlyNumber(String str) {
    char[] charArray = str.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      if (!Character.isDigit(charArray[i])) {
        System.out.println("false");
        return false;
      }
    }
    System.out.println("true");
    return true;
  }
}

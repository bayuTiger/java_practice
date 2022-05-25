package FunctionPractice;


// 仕様
// - 関数名 hasOnlyNumberOrPunctuation とする。
// - 第一引数には String を取る
// - 渡された文字列がすべて数字、または記号で構成されていればtrue。そうでなければfalseを返す。
// - ここで示す「記号」とは以下のいずれかを指すものとする。
//   !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~
//   ※上記記号には、そのままだとJavaの文字列にいれられないものが含まれているので、エスケープすること。
// - 以下のコード実行時に例外が発生しないこと。
//     エスケープについて参考した記事: https://www.javadrive.jp/start/num/index4.html

public class prac3 {
  public static void main(String[] args) {
    assert hasOnlyNumberOrPunctuation("1234") == true;
    assert hasOnlyNumberOrPunctuation("!#$%") == true;
    assert hasOnlyNumberOrPunctuation("1234!") == true;

    assert hasOnlyNumberOrPunctuation(" 1234!") == false;
    assert hasOnlyNumberOrPunctuation("1234! ") == false;
    assert hasOnlyNumberOrPunctuation("1234!a") == false;
    assert hasOnlyNumberOrPunctuation("abc") == false;
  }

  private static boolean hasOnlyNumberOrPunctuation(String s) {
    String regex = "0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    String[] arr = s.split("");
    for (int i = 0; i < arr.length; i++) {
      if (!regex.contains(String.valueOf(arr[i]))) {
        System.out.println("false");
        return false;
      }
    }
    System.out.println("true");
    return true;
  }
}

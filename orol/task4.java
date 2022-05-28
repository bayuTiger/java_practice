package orol;

// --- overload --- //
// ここまでの課題で overload を使う場面が何度かあったので、簡単なものを1問だけ
// 以下の println メソッドについて、引数を指定しないでも実行できるものをオーバーロードで作成する
// 引数を指定しない場合は "Hello World" と出力されるようにすること。

public class task4 {

  public static void main(String[] args) {
    // 以下のいずれも動作するようにする
    Hello hello = new Hello();
    hello.println(); // Hello World と出力される
    hello.println("Test"); /// Hello Test と出力される
  }

}

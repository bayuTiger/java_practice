package func_practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// 仕様
// - 関数名は getValueFromMap とする
// - 第一引数は Map<String, Integer> とする。
// - 第二引数は String 型とする。この値で第一引数のMapから値の取得をおこなう。
// - 戻り値の型は Optional<Integer> とする。
//　  もし指定されたキーが存在しない場合はOptional.empty を返す
// - 以下のコード実行時に例外が発生しない
// 
// Optional型 よりも List と Map で値が取れなかったときの挙動が異なることを理解することが目的
// 回答はごく簡単なものになる。
// List -> IndexOutOfBoundsException
// Map -> NullPointerException
// Map型について参考にした記事: https://www.javadrive.jp/start/collection/index3.html

public class prac8 {
  public static void main(String[] args) {

    // HashMapを宣言と同時に初期化するのに、匿名クラスとインスタンスイニシャライザを使用している。
    Map<String, Integer> map = new HashMap<String, Integer>() { // 匿名クラス: https://techacademy.jp/magazine/19027
      { // インスタンスイニシャライザ: https://nompor.com/2017/11/08/post-903/
        put("AAPL", 174);
        put("AMZN", 3510);
        put("FB", 332);
        put("GOOGL", 2952);
        // put("MSFT", 333); // 意図的にコメントアウト
        // put("NFLX", 611); // 意図的にコメントアウト
      }
    };
    Optional<Integer> value = getValueFromMap(map, "AAPL");
    assert value.equals(Optional.empty()) == false;
    assert value.orElse(0).equals(174);

    value = getValueFromMap(map, "NFLX");
    assert value.equals(Optional.empty()) == true;
    assert value.orElse(0).equals(0);
  }

  private static Optional<Integer> getValueFromMap(Map<String, Integer> map, String string) {
    try{
      int value = map.get(string);
      Optional<Integer> optionalValue = Optional.ofNullable(value);
      System.out.println("tryExec");
      return optionalValue;
    }catch(NullPointerException e){
      System.out.println("catchExec");
      return Optional.empty();
    }
  }
}

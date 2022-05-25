package func_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// 仕様
//   例外は出さずに Optional.empty を返す
// - 関数名は getItemFromList とする
// - 第一引数は List<String> とする。
// - 第二引数は int 型とする。この値で第一引数のリストから値の取得をおこなう。
// - 戻り値の型は Optional<String> とする。
// - 以下のコード実行時に例外が発生しない
// Optional型について参考にした記事
// - Java 8 "Optional" ～ これからのnullとの付き合い方 ～ https://qiita.com/shindooo/items/815d651a72f568112910
// - 【Optional入門】Javaでnullを扱うベストプラクティスのご紹介 https://www.bold.ne.jp/engineer-club/java-optional

public class prac7 {
  public static void main(String[] args) {
    List<String> optList = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
    Optional<String> item = getItemFromList(optList, 0);
    assert item.equals(Optional.empty()) == false;
    assert item.orElse("None").equals("a");

    item = getItemFromList(optList, 5);
    assert item.equals(Optional.empty()) == true;
    assert item.orElse("None").equals("None");
  }

  private static Optional<String> getItemFromList(List<String> list, int n) {
    try{
      Optional<String> optionalElement = Optional.ofNullable(list.get(n));
      return optionalElement;
    }catch(IndexOutOfBoundsException e){
      return Optional.empty();
    }

  }
}

package func_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// リストA: ["Hokkaido", "Aomori", "Akita"]
// リストB: ["北海道", "青森", "秋田"]
// 結果リスト: [["Hokkaido", "北海道"], ["Aomori", "青森"], ["Akita", "秋田"]]
// 仕様
// - 関数名は zip とする
// - 第一引数、第二引数にそれぞれ List<T> を取る
// - 戻り値の型は List<List<T>> とする
// - ２つのリストのサイズが異なる場合は、小さいリストの長さ分だけまとめて返す。
//   リストA: [1, 2, 3, 4, 5] 
//   リストB: [10, 20, 30] 
//   結果リスト: [[1, 10], [2, 20], [3, 30]]

public class prac6 {
  public static void main(String[] args) {
    List<String> engList = new ArrayList<>(Arrays.asList("Hokkaido", "Aomori", "Akita"));
    List<String> jpList = new ArrayList<>(Arrays.asList("北海道", "青森", "秋田"));
    List<List<String>> zippedList = zip(engList, jpList);
    assert zippedList.size() == 3;
    assert zippedList.get(0).equals(Arrays.asList("Hokkaido", "北海道"));
    assert zippedList.get(1).equals(Arrays.asList("Aomori", "青森"));
    assert zippedList.get(2).equals(Arrays.asList("Akita", "秋田"));

    List<Integer> onesPlace = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    List<Integer> tensPlace = new ArrayList<>(Arrays.asList(10, 20, 30));
    List<List<Integer>> zippedNumbers = zip(onesPlace, tensPlace);
    System.out.println(zippedNumbers);
    assert zippedNumbers.size() == 3;
    assert zippedNumbers.get(0).equals(Arrays.asList(1, 10));
    assert zippedNumbers.get(1).equals(Arrays.asList(2, 20));
    assert zippedNumbers.get(2).equals(Arrays.asList(3, 30));
  }

  public static <T> List<List<T>> zip(List<T> listA, List<T> listB) {

    int size = listA.size() < listB.size() ? listA.size() : listB.size();

    List<List<T>> resultList = new ArrayList<>();

    for (int i = 0; i < size; i++) {

      // List<T> tmpList = new ArrayList<>();
      // tmpList.add(listA.get(i));
      // tmpList.add(listB.get(i));
      // ↑ の式を ↓ の式に書き換えることができる
      List<T> tmpList = new ArrayList<T>(Arrays.asList(listA.get(i), listB.get(i)));

      resultList.add(tmpList);

    }

    return resultList;

  }
}

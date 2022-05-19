# List

## 4-1

整数が入力されるまで入力を受け付ける
整数以外が入力されたら、それまで入力された数値の一覧と、その合計を表示する

```java
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class training {
  public static void main(String[] args) {

    List<Integer> lIntegers = new ArrayList<Integer>();
    Scanner scanner = new Scanner(System.in);

    System.out.println("整数を入力(整数値以外を入力すると、これまで入力した数値とその合計を出力します)");

    while (scanner.hasNextInt()) {
      lIntegers.add(scanner.nextInt());
    }

    scanner.close();

    System.out.println("\nこれまで入力した数値 ↓");
    int sum = 0;

    for (int lInt : lIntegers) {
      System.out.println(lInt);
      sum += lInt;
    }

    System.out.println("\n入力した数値の合計 ↓");
    System.out.println(sum);
  }
}
```

## 4-2

配列とリストの違い

- データの持ち方
  - 配列ははじめにメモリ上に連続した領域を確保する
  - リストは新しい要素が追加されるたびにメモリ領域を確保する
- 要素数の増減
  - 配列は要素数の増減を行うことはできない
  - リストは要素数の増減やデータの挿入、入れ替えが容易にできる
- 要素の検索
  - 配列はインデックスを指定すれば直接要素を参照できるため、どの要素にも同じ時間でアクセスできる
  - リストはランダムな要素を検索する場合、端の要素からリンクをたどるため時間がかかる場合がある

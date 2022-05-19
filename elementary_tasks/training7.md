# repetition

## 7-1

for文の条件式の中について

- for(a, b, c)とする
  - a = 初期化式。for文が実行されるときに*一度だけ実行*される。
    - カウンター変数の宣言・初期化を行う場所
  - b = 条件式。繰り返しを行おうとするタイミングで*毎回必ず実行*される。
    - この式の評価結果がtrueなら処理部が実行され、falseなら即座にfor文が終了する
  - c = 反復式。処理部が終了した際に*必ず呼び出される*
    - 一般的にカウンター用の変数の操作が行われる
    - この後はb(条件式)が実行される

## 7-2

整数を10回入力し、その平均を求める

```java
    int[] x = new int[10];
    int sum = 0;
    Scanner scanner = new Scanner(System.in);

    for(int i = 0; i< x.length; i++){
      System.out.println("整数を残り" + (10 - i) + "回入力してください");
      x[i] = scanner.nextInt();
      sum += x[i];
    }
    scanner.close();

    int ave = sum / x.length;
    System.out.println("入力された数値の平均値は" + ave);
```

## 7-3

巨人阪神戦の戦況、結果を表示

```java
    int[] pointOfGiants = new int[10];
    int resultOfGiants = 0;
    int[] pointOfTigers = new int[10];
    int resultOfTigers = 0;

    String teamName = "";
    String roundName = "";

    Scanner scanner = new Scanner(System.in);

    for (int i = 1; i < 10; i++) {

      System.out.println(i + "回");

      for (int j = 1; j < 3; j++) {

        if (j % 2 == 0) {

          teamName = "阪神";
          roundName = "裏";
          pointOfTigers[j] = scanner.nextInt();
          resultOfTigers += pointOfTigers[j];

          System.out.println(roundName + teamName + "の得点は" + pointOfTigers[j] + "点");
        } else {
          teamName = "巨人";
          roundName = "表";
          pointOfGiants[j] = scanner.nextInt();
          resultOfGiants += pointOfGiants[j];

          System.out.println(roundName + teamName + "の得点は" + pointOfGiants[j] + "点");
        }
      }
    }

    System.out.println("巨人の得点：" + resultOfGiants + "点");
    System.out.println("阪神の得点：" + resultOfTigers + "点");

    if (resultOfGiants < resultOfTigers) {
      System.out.println("阪神の勝ち!");
    } else if (resultOfGiants > resultOfTigers) {
      System.out.println("巨人の勝ち!");
    } else {
      System.out.println("引き分け...");
    }
```

## 7-4

整数以外の文字が入力されるまで入力を受け付け、整数以外の文字が入力されたら、それまで入力された数値の平均を求める

```java
    List<Integer> lIntegers = new ArrayList<Integer>();
    Scanner scanner = new Scanner(System.in);

    System.out.println("整数を入力(整数値以外を入力すると、これまで入力した数値の平均を出力します)");

    while (true) {
      lIntegers.add(scanner.nextInt());
      if(!scanner.hasNextInt()){
        break;
      }
    }

    scanner.close();
    int sum = 0;

    for (int lInt : lIntegers) {
      sum += lInt;
    }

    int ave = sum / lIntegers.size();
    System.out.println("\n入力した数値の平均 -> " + ave);
```

## 7-5

7-4のプログラムをdo-while文に書き換える

```diff
-   while (true) {
-     lIntegers.add(scanner.nextInt());
-     if(!scanner.hasNextInt()){
-       break;
-     }
-   }
+   do{
+     lIntegers.add(scanner.nextInt());
+   }while (scanner.hasNextInt());
```

## 7-6

do-while文が必要になる状況

- 必ず一回は処理を実行させたいときにdo-while文を利用する
  - while文は条件式の評価を先に行うが、do-whileは処理の実行を先に行うため

## 7-7

配列から奇数のみを取り出したリストを作成して出力

```java
    int num[] = {1,2,3,4,5,6,7,8,9,10,11,12};
    List<Integer> result = new ArrayList<Integer>();

    for(int i = 0;i < num.length; i++){
      int n = num[i];
      if(i % 2 == 1){
        continue;
      }
      result.add(num[i]);
    }

    for(int n: result){
      System.out.printf("%d", n);
    }
```

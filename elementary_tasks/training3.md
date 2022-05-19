# Array

## 3-1

1~10の数値を入力し、配列に保存する
それら入力された数値を２倍にして表示する

```java
import java.util.Scanner;

public class training {
  public static void main(String[] args) {
    int[] x = new int[10];

    Scanner scanner = new Scanner(System.in);
    for(int i = 0; i<x.length; i++){
      System.out.println("整数を入力");
      x[i] = scanner.nextInt();
    }
    for(int i = 0; i<x.length; i++){
      System.out.printf("x[%3d] * 2 = %d\n", i, x[i]*2);
    }
    scanner.close();
  }
}
```

## 3-2

九九を表示するプログラム

```java
for (int i = 1; i <= 9; i++) {
  for (int j = 1; j <= 9; j++) {
    System.out.printf("%3d", i*j);
  }
  System.out.println();
}
```

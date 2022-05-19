# conditional_branch

## 5-1

xとyの数値を比較し、その結果を表示

```java
System.out.println("x,yの値を順番に入力してください");

Scanner  earlierInputtedValue= new Scanner(System.in);
Scanner laterInputtedValue = new Scanner(System.in);

int x = earlierInputtedValue.nextInt();
int y = laterInputtedValue.nextInt();

earlierInputtedValue.close();
laterInputtedValue.close();

System.out.println("\nx,yの比較結果↓\n");

if (x > y) {
  System.out.println("xはyより大きい\n");
} else if (x < y) {
  System.out.println("xはyより小さい\n");
} else {
  System.out.println("xとyは等しい\n");
}
```

## 5-2

日曜午前〜土曜夜間までの間で、開院か休診かを表示する
休診の日は日曜全日、火曜午前、水曜夜間、金曜午前、土曜午後夜間

```java
System.out.println("2桁の数字を入力してください\n(10の位は0~6,1の位は0~2)\n例 ↓\n日曜午前: 00\n水曜午後: 31\n土曜夜間: 62");

Scanner scanner = new Scanner(System.in);
int inputtedValue = scanner.nextInt();

scanner.close();

int[] closedDays = { 00, 01, 02, 20, 32, 50, 61, 62 };
boolean isOpenedHospital = Arrays.asList(closedDays).contains(inputtedValue);

if (isOpenedHospital = true) {
  System.out.println("休診しています");
} else {
  System.out.println("開院しています12");
}
```

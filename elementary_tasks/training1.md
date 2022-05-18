# 型

## 1-1

型の分類

- p = プリミティブ型
- r = 参照型

- int: p
- boolean: p
- String: r
- Character: pppppppppp
- Random: r
- double: p

## 1-2

文字列sをInteger型に変換する
文字列が空もしくはnullの時には、nullを返す

```java
public Integer toInt(String s){
    if(s == null || s.trim().equals("")){
      return null;
    }
      return Integer.valueOf(s);
  }
```

## 1-3

参照型の比較は「==」ではなくequalsを使う

```java
String s = "hello world";
if (s.equals("hello world")){
  System.out.println("True");
}else{
  System.out.println("False");
}
```

## 1-4

- charは「'」を使い、一文字を格納することができる
- Stringは「"」を使い、文字列を格納することができる

## 1-5

- 100 + "1" = "1001"

## 1-6

"70","30","100"を昇順に並び替える

- [100, 30, 70]

## 1-7

70,30,100を昇順に並び替える

- [30, 70, 100]

## 1-8

小数の計算をdouble型で行うと誤差が発生するので、BigDecimal型を用いて計算を行う

```java
BigDecimal x = BigDecimal.valueOf(0.8);
BigDecimal y = BigDecimal.valueOf(0.9);

System.out.println(x.add(y));
```

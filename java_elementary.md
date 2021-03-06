# JAVA基礎

## basic_procedure

1. .javaを記述する(ファイル名とクラス名は一致させる)
2. `javac ファイル名.java`でクラス名.classファイルを生成する(コンパイルする)
3. `java ファイル名.class`で実行する

## basic_syntax

- `public static void main(String[] arg){ 処理 }`
  - public = どこからでも参照可能
  - static = インスタンス化しなくても外部から使用可能
  - void = 戻り値なし
  - main = javaに絶対1つ必要なメソッド
  - String[] = 引数をString型の配列で受け取る
    - コマンドラインから受け取る値は人間が入力するもじだから、という思想
  - arg = 引数名
    - なんでもいい。C言語の慣習が残ってる

## basic_rule

- *クラス名はアッパーキャメルケース*で記述する

### データ型

- 整数はint,小数はdouble
  - *小数を扱う計算はBigDecimal*
- 大きさの異なるデータ型は、リテラルの指定やキャストをすることで使うことができる
  - ただ挙動がおかしくなることがあるのでやめよう(特に基本データ型)
- 基本データ型(8) = 値だけ格納できる
- 参照型(たくさん) = 値と操作ができる
  - 例えば配列が格納されている変数xには、実際には値が格納されてはおらず、内部の挙動では、格納されている本来の場所まで参照しに行っている。だから参照型
  - エイリアスみたいな感じ
- "ダブルクオーテーションだとString",`シングルクオーテーションchar`
- *Character型は参照型でchar型はプリミティブ型*

### 配列

- 配列は参照型であり、その構成要素は基本データ型でも参照型でもよい
  - 配列はコピーしても参照している場所は両者同じ
  - だからコピーしたほうの値を変更したら、*大本の方の値も変わる*

### 条件分岐

- 参照型の場合、「＝＝」で文字列を比較すると結果が変わってくる(参照型はエイリアスみたいなもので実体がないから)
  - だからStringクラスのequalsメソッドを使う
    - equalsメソッドはboolean型の戻り値を返却してくれるので、if文で制御できる
      - `if ("hello".equals("hello")){ trueの場合の処理 }`
    - 同様のことがArrayListクラスのisEnptyメソッドでもできる
    - つまり*処理の結果を判定条件に使うことができる*

### 繰り返し

- while文の条件はfor文と異なり、結果がbooleanで返ってくる
- *while文は処理中に値を更新する(条件を変える)処理を入れないと、無限ループに陥る*
- 配列と相性がいいので、`ary.length`や`ary[i]`はよく使うものとして覚えておく
- phpでいうfor-each文は拡張for文と呼ばれており、条件の形式がまた変わってくる
  - 仕組みはわかりやすいから強張る必要はない

### メンバ変数の値の設定

1. 初期値を設定する
2. カプセル化
   1. メンバ変数の値の入出力を、メソッドを使って制限する
   2. 誤設定の防止や不要な値の取得防止に貢献する
      1. メンバ変数を*privateに設定*する
      2. メンバ変数のアクセッサメソッドを設定する
         1. get○○、set○○のようにメソッドを命名する
         2. カプセル化の意味がないかと思われるかもしれない
         3. しかし、アクセッサメソッド内に条件分岐を設定すれば、バリデーションが可能になる
3. コンストラクタ
   1. インスタンス化する際に一度だけ実行される特殊なメソッド
   2. 作成しなくても自動でコンストラクトする(デフォルトコンストラクタ)
      1. `Student s = new Student()`

### 定数

- `public static final String HELLO = "Hello"`
- finalキーワードが重要

### メソッド

- lowerCamelCaseで記述する
- 動詞と名詞を組み合わせて命名する

```java
// class
String address;

//method
void setAddress(String address){
  this.address = address;
}

// インスタンス化をする
Student s = new Student();

s.setAddress("東京都杉並区")

String getAddress = s.getAddress(); //受け皿を用意する必要がある

```

- staticメソッド
  - インスタンス化が必要ない
  - *クラスに依存しない処理*を作る場合に用いる
  - 使う側はクラス名.メソッド名で呼び出す
- オーバーロード
  - あるメソッドの引数を増やしたくなった時(ex.3つバージョンと4つバージョンが欲しい)、*同じメソッド名で引数の数を変える*ことで対応する手法
  - 応用として「可変長引数」が存在している

#### アウトプットの宣言

- *戻り値の型は1つのメソッドにつき1つだけ*
- 宣言するのは「型」だけで変数名は不要
- 戻り値が不要の場合は「void」

#### インプットの宣言

- *引数は1つのメソッドに複数宣言可能*
- 宣言するのは「型」と「変数名」
- 引数が不要の場合でも「()」を書かないとsyntax errorになる
- 引数を宣言した場合、メソッド使用時に必ず指定されたインプットを渡さなければならない

### 継承

- 親クラス(スーパークラス) -> 子クラス(サブクラス)
  - 抽象 -> 具体
  - class Animal -> class Human extends 
- 単一継承が原則
- 複数の特性を継承するためには「インターフェース」の利用を検討する
- 子クラスで親クラスのものを使いたい場合は*super.変数名*のように記述する
- 継承させることを目的としたクラス・メソッドは*abstract*で実装することが可能


#### 継承の仕組み

- オーバーライド
  - 親クラスで定義しているメソッドを、子クラス側で上書き(再定義)する機能
- キャスト
  - 子クラスのインスタンスは、親クラスのデータ型で宣言した変数に格納できる
  - このとき子クラスは親クラスとみなされるため、本来のインスタンスの機能を十分に使うことができない
  - そこでキャストを使う必要性が出てくる
- 親クラスで定義したメソッドは、*実行結果が異なっても、その振る舞いが保証されている*
  - これはポリモーフィズムにつながる考え方

### インターフェース

- 継承と違うのは*共通点を定義している*ということ
  - 異なるクラス間の*規格*となる
- 多重実装が可能
- インターフェースには原則*メソッドを定義しない*
  - implementsするクラスは、原則*インターフェースで定義されているメソッドを必ずオバーライドする*必要がある
- インターフェースはクラスではないため、インスタンス化できない
- データ型として使うことはできる

```java
// インターフェースの宣言
public interface UniversalSerialBus{
  void energizing();
}

public interface Audio{
  void start();
  void stop();
}

// Carクラスの宣言

public class Car implements UniversalSerialBus,Audio{
  @Override // わかりやすいからアノテーションをつける
  public void energizing(){
    System.out.println("充電します")
  }
  @Override
  public void start(){
    System.out.println("音楽を再生します")
  }
}
```

### アクセス修飾子

- クラス・変数・メソッドの*使用できる範囲を制限する*
- public
  - どこでもOK
- protected
  - 同じパッケージ内・子クラスからアクセス可能
- private
  - 同じクラス内からアクセス可能

### 例外

- プログラム内で発生する例外
  - エラーはプログラム外で発生する例外
  - 例外もエラーも正体はクラス
- チェック例外(検査例外)
  - 正しいプログラムが書けていても回避できない
  - 事前に発生することを考慮して対処が必須
    - IOExpection(何らかの入出力ができない)
    - SQLExpection(DB処理ができない)
- 非チェック例外(非検査例外)
  - 正しいプログラムが書けていれば発生する可能性が低い
  - 任意で対処する
    - NullPointerException
      - 中身がない(null)状態の変数に対して処理をしようとする場合に発生
    - ArrayIndexOutOfBoundsExpection
      - 配列に対してサイズを超えている、負の整数を指定した場合に発生する

### 例外処理

1. 例外を投げる(throws)
   1. 例外が発生したメソッドから呼び出し元に通知する
   2. 通知された例外の内容に基づき処理を継続する
2. 例外を捕まえる(try)
   1. 例外が発生したメソッド内で処理する
   2. 呼び出し先から投げられた例外については最終的にtryブロックで捕まえて処理する
3. 例外処理のセオリー
   1. 例外は掴みっぱなしにしない(tryは書いてあるのに、catchが書かれていない)
   2. tryブロックは例外の想定される範囲で設定する
   3. throw,catchするクラスは多すぎると可読性を下げる

```java

// 例外を投げる
public void throwSample() throws Exception{

  // throws Exceptionで、あらかじめ例外発生の可能性を宣言しておく
  // 例外が発生する可能性のある処理を記述する

}

// 例外を捕まえる
try{

// 例外が発生する可能性のある処理

} catch(Exception e){

// 例外が発生した場合の処理

} finally{

// 例外の有無にかかわらず、必ず実行する処理
// finallyは無くてもよい

}

```

### 独自例外

- 例外にも継承関係がある
- チェック例外が親になることが一般的

# 外部ファイルの実行・バックアップとリストア・検索条件

## 外部ファイルの実行(DBを選択した状態)

- `source ファイル名`

## バックアップ(DBの外で入力する(ターミナル・コマンドプロンプト等))

- `mysqldump -u ユーザ名 データベース名 > 保存先のファイル名`
- `mysqldump -u ユーザ名 テーブル名 データベース名 > 保存先のファイル名`とすることで、テーブル単位のバックアップも可能

## リストア(DBを選択した状態)

- `source ファイル名`
- 外部ファイルを実行しているので、結局外部ファイル実行コマンドを入力することになる

## ALTER

- テーブル名の変更
  - `ALTER TABLE tbl_name RENAME [TO|AS] new_tbl_name`

- インデックス名の変更
  - `ALTER TABLE tbl_name RENAME INDEX old_index_name TO new_index_name`

- カラム名の変更
  - `ALTER TABLE tbl_name RENAME COLUMN old_col_name TO new_col_name`

- カラム名と定義の変更
  - `ALTER TABLE tbl_name CHANGE [COLUMN]old_col_name new_col_name column_definition`

- カラム定義の変更
  - `ALTER TABLE tbl_name MODIFY [COLUMN] col_name column_definition`

- カラムの追加
  - ALTER TABLE tbl_name
  `ADD [COLUMN] col_name column_definitio [FIRST | AFTER col_name]`

## 検索条件

- like
  - not like
- in(SELECT文を指定することもできる)
  - 全表検索する(EXISTSは見つけたらそこで検索終了するのでパフォーマンス的にはEXISTSの方が良い、インデックスのみを参照してくれるし)
  - not in
- between(文字列の範囲検索も出きる)
- distinct
- offset(「データの何件目から取得する」という条件)
- limit
  - limitとoffsetは必ず最後に記述する
  - limitとoffsetはフルスキャン(全件取得してからいらない部分を切り捨て)するので遅い
    - 対策としてbetweenを使う
- order by col_name [ASC | DESC]

## ビュー

- よく使うFROM句のサブクエリがあれば、それをビューにすれば良い

## UNION

- `select文 UNION ALL select文`で和集合を表現できる
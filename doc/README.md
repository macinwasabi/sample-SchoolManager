# 学級管理システム - 仕様書

## ディレクトリ構成

```text
sample
├ ss サーバーサイドの仕様書
│ └ db DBの仕様書
├ fe フロントエンドの仕様書
└ README.md このファイル
```

## API一覧

APIの共通仕様は[ss配下のREADME](./ss/README.md)を参照。

- [生徒情報API(Student)](./ss/Student.md)

## 画面一覧

- 生徒一覧画面

## 環境構築

### フォーマッタなどの設定

TODO。

### MyBatisGeneratorの実行

プロジェクトディレクトリで`mvn mybatis-generator:generate`を実行する。

## curl例

```curl
curl -X POST -H "Content-Type: application/json" -d '{"familyName" : "テスト", "firstName":"太郎"}' localhost:8080/api/student
```

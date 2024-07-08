# 学級管理システム - DB仕様書

## ER図

NOT NULLはカラム名の頭に*をつける。

```mermaid
erDiagram
    class ||--|| teacher :""
    class ||--|{ student :""
    student ||--o{ record :""
    subject ||--o{ record :""
    class {
        integer *grade_no PK "学年"
        integer *class_no PK "学級"
    }
    student {
        serial *student_id PK "生徒番号"
        string family_name "苗字"
        string first_name "名前"
    }
    subject {
        serial *subject_id PK "科目番号"
        string *subject_name "科目名"
    }
    record {
        integer *student_id PK,FK "生徒番号"
        integer *subject_id PK,FK "科目番号"
        integer *score "点数"
    }
    teacher {
        serial *teacher_id PK "教員番号"
        string family_name "苗字"
        string first_name "名前"
    }
```

## テーブル詳細

必要なものだけ。CLASSはサンプル。

### CLASS

| 物理名      | 論理名 | 型      | NOTNULL | 制約 | 概要 | 備考 |
|----------| ------ | ------- | ------- | ---- | ---- | ---- |
| grade_no | 学年   | integer | ◯       | PK   |      |      |
| class_no | 学級   | integer | ◯       | PK   |      |      |

インデックス(例なので現状は不要)

- index
  1. grade
  2. class
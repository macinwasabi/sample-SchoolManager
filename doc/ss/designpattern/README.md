# designpattern

デザインパターンを実装してみるパッケージです。

実装内容の概要を記載します。クラス図で出てくるMainは実際に利用するクラスです。また、designpatternパッケージ内でしか利用しない想定で適当に名前をつけています。

- [designpattern](#designpattern)
  - [Iterator](#iterator)
  - [Adapter](#adapter)
    - [継承によるパターン](#継承によるパターン)
    - [インスタンスによるパターン](#インスタンスによるパターン)

## Iterator

java.lang.Iterator、java.lang.Iterableを利用する。そのため、パターンとしてのIterator、Iteratorを利用できるものとしてのIterableをイテレーター、イテラブルと表記して、java.langのクラスは英字でIterator、Iterableと表記する。

- メリット

  リストにしてforをするより、繰り返しを行うロジックが実装に依存しなくなる。iteratorパターンにすることによって、実際にループしたオブジェクトに関係なくIteratorとして繰り返しができる。

- 実装概要

  クラスDTOとして生徒情報DTOをまとめている。クラスDTOをイテラブルにして、イテレーターで生徒情報を取り出せるように実装した。

- 実装の各オブジェクトの説明

  - StudentDto：生徒情報DTO。
  - IterableClassDto：クラス情報DTO。複数の生徒情報をフィールドに持つ。Iterableを継承している。
  - ClassIterator：クラス情報DTOのイテレーター。Iteratorを継承している。

- クラス図

  イテレーターに関連するメソッド、フィールドしか記述していない。

  ```mermaid
  classDiagram
      Iterable <|.. IterableClassDto
      IterableClassDto o-- StudentDto
      Iterator <|.. ClassIterator
      Iterator <-- Iterable
      ClassIterator o-- IterableClassDto
      ClassIterator <-- IterableClassDto
      IterableClassDto <-- Main
      class Iterator{
          + boolean hasNext()
          + E next()
      }
      class Iterable{
          + Iterator iterator()
      }
      class StudentDto{
      }
      class IterableClassDto{
        + StudentDto[] students
        + Iterator iterator()
      }
      class ClassIterator{
        - IterableClassDto classDto
        + boolean hasNext()
        + IterableClassDto next()
      }
  ```

## Adapter

- メリット

  - すでに存在しているクラスを利用するためにある。
  - 複数のクラスを利用する場合も、利用する側はアダプターだけを意識すればよくなるし、追加する際もアダプターの中で追加すればよくなる。拡張性が高まる。

- 疑問

  - 単に処理をまとめたいだけならLogicとしてまとめてDIするのと同じでは？：それがインスタンスによるパターンそのものだと思う。

- 実装概要

  既存クラス役として姓名の文字列を受け取って生徒(先生)情報DTOを返すクラスがある。これをAdapterで利用する。

### 継承によるパターン

- 実装の各オブジェクトの説明

  - StudentLogic：生徒情報に関するロジックのインターフェース。
  - StudentLogicImpl：生徒情報に関するロジックのクラス。StudentConverterを拡張して利用する。大して思いつかなかったので雑です。
  - StudentConverter：文字列から生徒情報DTOを返すクラス。

- クラス図

  ```mermaid
    classDiagram
      StudentLogic <-- Main
      StudentLogic <|.. StudentLogicImpl
      StudentConverter <|-- StudentLogicImpl
      class StudentLogic{
        + StudentDto getStudent(String)
      }
      class StudentLogicImpl{
        + StudentDto getStudent(String)
      }
      class StudentConverter{
        + StudentDto convertSeiMei(String)
      }
  ```

### インスタンスによるパターン

- 実装の各オブジェクトの説明

  - TeacherLogic：先生情報に関するロジックの抽象クラス。
  - TeacherLogicImpl：Teacherせんs情報に関するロジックのクラス。TeacherConverterを利用する。大して思いつかなかったので雑です。
  - TeacherConverter：文字列から先生情報DTOを返すクラス。

- クラス図

  ```mermaid
    classDiagram
      TeacherLogic <-- Main
      TeacherLogic <|-- TeacherLogicImpl
      TeacherConverter --o TeacherLogicImpl
      class TeacherLogic{
        + TeacherDto getTeacher(String)
      }
      class TeacherLogicImpl{
        - TeacherConverter converter
        + TeacherDto getTeacher(String)
      }
      class TeacherConverter{
        + TeacherDto convertSeiMei(String)
      }
  ```

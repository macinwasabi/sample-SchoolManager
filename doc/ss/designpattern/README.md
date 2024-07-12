# designpattern

デザインパターンを実装してみるパッケージです。

実装内容の概要を記載します。

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

  - 単に処理をまとめたいだけならLogicとしてまとめるのと同じでは？：

- 実装概要

### 継承によるパターン

- 実装の各オブジェクトの説明

### インスタンスによるパターン

- 実装の各オブジェクトの説明

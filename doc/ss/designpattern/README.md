# designpattern

デザインパターンを実装してみるパッケージです。

実装内容の概要を記載します。クラス図で出てくるMainは実際に利用するクラスです。また、designpatternパッケージ内でしか利用しない想定で適当に名前をつけています。

- [designpattern](#designpattern)
  - [Iterator](#iterator)
  - [Adapter](#adapter)
    - [継承によるパターン](#継承によるパターン)
    - [インスタンスによるパターン](#インスタンスによるパターン)
  - [TemplateMethod](#templatemethod)
  - [FactoryMethod](#factorymethod)
  - [Singleton](#singleton)
  - [Prototype](#prototype)
  - [Builder](#builder)
  - [AbstractFactory](#abstractfactory)
  - [Bridge](#bridge)
  - [Strategy](#strategy)
  - [Composite](#composite)
  - [Decorator](#decorator)
  - [Visitor](#visitor)
  - [Chain of Responsibility](#chain-of-responsibility)
  - [Facade](#facade)
  - [Mediator](#mediator)
  - [Observer](#observer)
  - [Memento](#memento)
  - [State](#state)
  - [Flyweight](#flyweight)
  - [Proxy](#proxy)
  - [Command](#command)
  - [Interpreter](#interpreter)

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
  - TeacherLogicImpl：Teacher先生情報に関するロジックのクラス。TeacherConverterを利用する。大して思いつかなかったので雑です。
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

## TemplateMethod

- メリット

ロジックを共通化し、個別に必要なロジックだけをサブクラスで実装すればよくなる。

- 実装概要

  クラスの紹介文を生成する処理です。

- 実装の各オブジェクトの説明

  - AbstractClassIntroduciton：クラス紹介の抽象クラス。
  - ClassIntroduction：クラス紹介を実装しているクラス。AbstractClassIntroducitonを継承する。実装では1年A組を想定している。

- クラス図

  ```mermaid
    classDiagram
      AbstractClassIntroduciton <-- Main
      ClassIntroduction <-- Main
      AbstractClassIntroduciton <|-- ClassIntroduction
      class AbstractClassIntroduciton{
        + String get()
        # String precontent()
        # String content()
      }
      class ClassIntroduction{
        # String precontent()
        # String content()
      }
  ```

## FactoryMethod

- メリット

  - TempateMethodのインスタンス生成版、応用。Creater.create()とConcreteCreater.create()がTemplateMethodになっている。
  - 本来はnewで行うインスタンス生成を、インスタンス生成のためのメソッドに置き換えることで、具体的なクラス名

- 疑問

  - インスタンス生成をメソッドに置き換えたいだけなら、インターフェースを介さないでよいと思う：Product, Creatorのframework側と実装をする側で完全に分かれているため、別のインスタンスを作成するのにframework側はそのまま使える。依存を減らしたこの形も含めてのFactoryMethodだと思う。

- 実装概要

- 実装の各オブジェクトの説明

  - Product：生成されるインスタンスの抽象クラス。
  - Creator：Productを生成する抽象クラス。
  - ConcreteProduct：Productの具象クラス。
  - ConcreteCreator：Creatorの具象クラス。

- クラス図

  ```mermaid
    classDiagram
      Product <|-- Creator
      Creator <|.. ConcreteCreator
      Product <|.. ConcreteProduct
      ConcreteProduct <|-- ConcreteCreator
      class Product {
        + method1()
        + method2()
      }
      class Creator {
        + Product create()
        # Product factoryMethod()
      }
      class ConcreteProduct {
        + method1()
        + method2()
      }
      class ConcreteCreator {
        # Product factoryMethod()
      }
  ```

## Singleton

- メリット

  - インスタンスが1つしか生成されないようにできる。
  - 扱う側で気をつけて設計を行えばインスタンスが1つしかないようにできるが、その保証がない。Singletonなら保証されている。
  - enumで実現することもできる。

- 実装概要

- 実装の各オブジェクトの説明

- Singleton：コンストラクタ、フィールド(インスタンス)をprivateとし、getInstance()からインスタンスを生成、返すようにする。

- クラス図

  ```mermaid
    classDiagram
      class Singleton {
        - singleton
        - Singleton()
        + getInstance()
      }
  ```

## Prototype

- メリット

  - Prototypeやそれを利用するClientでは、ConcretePrototypeに依存することなくインスタンスのコピーを作れる(Clientの中でPrototype型で扱う)。つまり、ClientやConcretePrototypeと、実際の実装(ConcretePrototype)や実行する処理(Clientを使うクラス)とを切り分けることができる。
  - newせずに、インスタンスをコピーできる。

- 実装概要

- 実装の各オブジェクトの説明

  - Prototype：インスタンスをコピーするメソッドを定めるインターフェース。
  - ConcretePrototype：Prototypeを実装する。
  - Client：インスタンスをコピーするメソッドを利用して新しいインスタンスを作る。

- クラス図

  ```mermaid
    classDiagram
      Prototype <|-- ConcretePrototype
      Prototype <|-- Client
      class Prototype {
        + createCopy()
      }
      class ConcretePrototype {
        + createCopy()
      }
      class Client {
      }
  ```

## Builder

- メリット

  - 複雑な構造のオブジェクトの作成を簡単に行うことができる。

- 実装概要

- 実装の各オブジェクトの説明

  - Director：Builderを使ってインスタンスを生成する。
  - Builder：インスタンスを生成するためのインターフェース。インスタンスの各部分を作るためのメソッドを用意する。
  - ConcreteBuilder：Builderの実装。インスタンス生成で呼び出されるメソッドや、最終的に出来たインスタンスを得るメソッドがある。
  - Main：Builderパターンを利用する。

- クラス図

  ```mermaid
    classDiagram
      Director o-- Builder
      Builder <|-- ConcreteBuilder
      Director <|-- Main
      ConcreteBuilder <|-- Main
      class Director {
        - Builder
        + construct()
      }
      class Builder {
        + buuldPart1()
        + buuldPart2()
        + buuldPart3()
        + getResult()
      }
      class ConcreteBuilder {
        + buuldPart1()
        + buuldPart2()
        + buuldPart3()
        + getResult()
      }
      class Main {
      }
  ```

## AbstractFactory

- メリット

- 疑問

- 実装概要

- 実装の各オブジェクトの説明

- クラス図

## Bridge

- メリット

- 疑問

- 実装概要

- 実装の各オブジェクトの説明

- クラス図

## Strategy

- メリット

- 疑問

- 実装概要

- 実装の各オブジェクトの説明

- クラス図

## Composite

- メリット

- 疑問

- 実装概要

- 実装の各オブジェクトの説明

- クラス図

## Decorator

- メリット

- 疑問

- 実装概要

- 実装の各オブジェクトの説明

- クラス図

## Visitor

- メリット

- 疑問

- 実装概要

- 実装の各オブジェクトの説明

- クラス図

## Chain of Responsibility

- メリット

- 疑問

- 実装概要

- 実装の各オブジェクトの説明

- クラス図

## Facade

- メリット

- 疑問

- 実装概要

- 実装の各オブジェクトの説明

- クラス図

## Mediator

- メリット

- 疑問

- 実装概要

- 実装の各オブジェクトの説明

- クラス図

## Observer

- メリット

- 疑問

- 実装概要

- 実装の各オブジェクトの説明

- クラス図

## Memento

- メリット

- 疑問

- 実装概要

- 実装の各オブジェクトの説明

- クラス図

## State

- メリット

- 疑問

- 実装概要

- 実装の各オブジェクトの説明

- クラス図

## Flyweight

- メリット

- 疑問

- 実装概要

- 実装の各オブジェクトの説明

- クラス図

## Proxy

- メリット

- 疑問

- 実装概要

- 実装の各オブジェクトの説明

- クラス図

## Command

- メリット

- 疑問

- 実装概要

- 実装の各オブジェクトの説明

- クラス図

## Interpreter

- メリット

- 疑問

- 実装概要

- 実装の各オブジェクトの説明

- クラス図
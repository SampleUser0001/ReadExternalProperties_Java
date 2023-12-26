# ReadExternalProperties_Maven

Mavenのresources配下ののpropertiesを読み込む。

- [ReadExternalProperties\_Maven](#readexternalproperties_maven)
  - [基本](#基本)
  - [ファイル一覧](#ファイル一覧)
  - [実行](#実行)
  - [参考](#参考)

## 基本

propertiesはclassLoaderを使う場合、クラスパスを基準に検索される。フルパスで指定しても読み込みできるが、  
Mavenの場合、`mvn compile`を実行すると`src/main/resources`配下のファイルが`target/classes`（クラスパス直下）にコピーされるので、フルパスで指定しなくても読み込みできる。  
jarを使用する場合、クラスパスはマニフェストファイルに書かれる。マニフェストファイルにどう書くかはpom.xmlで指定できる。

## ファイル一覧

``` txt

src
├── main
│   ├── java
│   │   └── sample
│   │       └── props
│   │           ├── App.java
│   │           └── enums
│   │               └── SamplePropertiesEnum.java
│   └── resources
│       └── sample.properties
└── test
    └── java
        └── sample
            └── properties
                └── AppTest.java

10 directories, 4 files
```

## 実行

``` bash
mvn clean compile exec:java
```

## 参考

- [java - 読み込み - Mavenプロジェクトのリソースファイルへのパスとは何ですか?:CodeExamples](https://code-examples.net/ja/q/2f5f69)
- [プロパティファイルをUnicode以外で記述、読み込む:Qiita](https://qiita.com/areph/items/e2430fe12a2880fb7a2e)
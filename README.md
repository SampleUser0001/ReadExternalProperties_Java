# ReadExternalProperties_Maven
Mavenのresources配下ののpropertiesを読み込む。

## ディレクトリ構成

``` txt
$ tree src
src
├── main
│   ├── java
│   │   └── sample
│   │       └── properties
│   │           └── App.java
│   └── resources
│       └── properties
│           └── sample.properties
└── test
    └── java
        └── sample
            └── properties
                └── AppTest.java

10 directories, 3 files
```

## ソース

``` java
package sample.properties;

import java.util.Properties;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Mavenのresources配下のpropertiesを読み込む
 */
public class App {
    public static final String PROPERTIES_FILEPATH = Paths.get("/","properties","sample.properties").toString();
    public static final String SAMPLE_KEY = "sample.key";
    
    public void exec(String[] args) {
        Properties props = new Properties();
        try (InputStream in = getClass().getResourceAsStream(PROPERTIES_FILEPATH)){
            props.load(new InputStreamReader(in, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(props.getProperty(SAMPLE_KEY));
    }

    
    public static void main(String[] args) {
        new App().exec(args);
    }

}

```

## 実行

``` bash
mvn clean compile exec:java
```

## 参考

- [java - 読み込み - Mavenプロジェクトのリソースファイルへのパスとは何ですか?:CodeExamples](https://code-examples.net/ja/q/2f5f69)
- [プロパティファイルをUnicode以外で記述、読み込む:Qiita](https://qiita.com/areph/items/e2430fe12a2880fb7a2e)
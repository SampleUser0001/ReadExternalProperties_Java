package sample.props;

import java.util.Properties;
import java.util.ResourceBundle;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * Mavenのresources配下のpropertiesを読み込む
 */
public class App {
    public static final String PROPERTIES_FILEPATH = Paths.get("sample.properties").toString();
    public static final String SAMPLE_KEY = "sample.key";
    
    public void exec(String[] args) {
        System.out.println("PROPERTIES_FILEPATH : " + PROPERTIES_FILEPATH);
        Properties props = new Properties();
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILEPATH)){
            props.load(new InputStreamReader(in, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(props.getProperty(SAMPLE_KEY));
    }

    public void readByBundle(String[] args) {
        ResourceBundle res = ResourceBundle.getBundle("sample");
        System.out.println(res.getString(SAMPLE_KEY));
    }

    
    public static void main(String[] args) {
        new App().exec(args);
        // new App().readByBundle(args);
    }

}

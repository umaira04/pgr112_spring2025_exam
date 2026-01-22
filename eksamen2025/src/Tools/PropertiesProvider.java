package Tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesProvider {
    public static final Properties PROPS;

    static {
        PROPS = new Properties();
        try {
            PROPS.load(new FileInputStream("sql.properties"));
        } catch (IOException e) {
            System.out.println("unable to connect to scrapyardDB");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}


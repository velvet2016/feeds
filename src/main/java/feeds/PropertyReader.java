package feeds;



import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * Created by linux on 23.04.16.
 */
public class PropertyReader extends LoggedClass {
    protected static Logger logger = Logger.getLogger(PropertyReader.class.getName());

    private static Properties get(String fileName) {
        Properties prop = new Properties();
        InputStream input = CommonMethods.getInputStream(fileName);
        try {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
        return prop;
    }


    public static Properties getProperties(String path){
        return get(path);
    }



}

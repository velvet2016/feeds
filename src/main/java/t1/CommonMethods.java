package t1;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by linux on 25.04.16.
 */
public class CommonMethods {
    public static InputStream getInputStream(String path){
        try{
            InputStream input = CommonMethods.class.getClassLoader().getResourceAsStream(path);
            if(input==null){
                throw new IOException();
            }
            return input;
        } catch (IOException ex) {
            throw new RuntimeException("can not read property file:" + path);
        }
    }
}

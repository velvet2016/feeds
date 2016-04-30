package feeds;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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

    public static Document getDocumentFromXml(String path) {
        InputStream inputStream = getInputStream(path);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        Document doc;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputStream);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
        return doc;
    }
}

package feeds;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

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
            throw new RuntimeException("can not read file:" + path);
        }
    }

    public static BufferedReader getBuferedReader(String path, String encoding){
        CharsetDecoder decoder = Charset.forName(encoding).newDecoder();
        return new BufferedReader(new InputStreamReader(CommonMethods.getInputStream(path), decoder));
    }
    public static void printFile(String filePath, String encoding){
        BufferedReader reader = getBuferedReader(filePath, encoding);
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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

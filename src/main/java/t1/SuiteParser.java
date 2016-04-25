package t1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import t1.interfaces.SuiteParserInterface;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linux on 25.04.16.
 */
public class SuiteParser implements SuiteParserInterface {
    @Override
    public List<RunInfo> parse(String path) {
        List<RunInfo> runInfos = new ArrayList<>();
        InputStream inputStream = CommonMethods.getInputStream(path);
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
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("runItem");
        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                NodeList caseFileNameNodeList = eElement.getElementsByTagName("caseFileName");
                ArrayList<String> caseFileNames = new ArrayList<>();
                for (int i = 0; i < caseFileNameNodeList.getLength(); i++) {
                    caseFileNames.add(caseFileNameNodeList.item(i).getTextContent());
                }
                runInfos.add(new RunInfo(
                        eElement.getAttribute("className"),
                        caseFileNames,
                        eElement.getAttribute("tag")
                ));
            }
        }
        return runInfos;
    }
}

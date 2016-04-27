package feeds;

import feeds.enums.PublishingType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import feeds.interfaces.SuiteParserInterface;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
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
        NodeList nList = doc.getElementsByTagName("runItem");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Element eElement = (Element) nList.item(temp);
            runInfos.add(new RunInfo(
                    eElement.getAttribute("className"),
                    getMapTypeToValue(eElement,"vendorDataFile"),
                    getMapTypeToValue(eElement,"expectedDataFile"),
                    eElement.getAttribute("tag"),
                    new PublishingInfo(getIsPublishingNeeded(eElement),getPublishingType(eElement))

            ));
        }
        return runInfos;
    }

    private PublishingType getPublishingType(Element eElement) {
        Node node = eElement.getElementsByTagName("isPublishingNeeded").item(0);
        if (node == null) {
            return null;
        }
        String type = ((Element) node).getAttribute("type");
        return type == null ? null : PublishingType.valueOf(type.toUpperCase());

    }

    private boolean getIsPublishingNeeded(Element eElement) {
        Node node = eElement.getElementsByTagName("isPublishingNeeded").item(0);
        return node == null ? false : Boolean.parseBoolean(node.getTextContent());
    }

    private HashMap<String, String> getMapTypeToValue(Element eElement, String tagName) {
        HashMap<String, String> map = new HashMap<>();
            NodeList caseFileNameNodeList = eElement.getElementsByTagName(tagName);
            for (int i = 0; i < caseFileNameNodeList.getLength(); i++) {
                Element item = (Element) caseFileNameNodeList.item(i);
                map.put(item.getAttribute("type"), item.getTextContent());
        }
        return map;
    }
}

package feeds;

import feeds.enums.VendorProfile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by linux on 27.04.16.
 */
public class VendorInfoReader {
    public static VendorInfo getVendorInfo(VendorProfile vendorProfile, String env) {
        VendorInfo vendorInfo;
        Document doc = CommonMethods.getDocumentFromXml(vendorProfile.getXmlPropertyFileName());
        NodeList nList = doc.getElementsByTagName("vendorInfo");

        Element eElement = (Element) nList.item(0);
        vendorInfo = new VendorInfo(
                eElement.getElementsByTagName("staticDataCode").item(0).getTextContent(),
                eElement.getElementsByTagName("alacraMappingCode").item(0).getTextContent(),
                eElement.getElementsByTagName("alacraMappingName").item(0).getTextContent(),
                getMapTypeToPath(eElement, "fileType", env)

        );
        return vendorInfo;
    }

    private static HashMap<String, String> getMapTypeToPath(Element eElement, String tagName, String env) {
        HashMap<String, String> map = new HashMap<>();
        NodeList caseFileNameNodeList = eElement.getElementsByTagName(tagName);
        for (int i = 0; i < caseFileNameNodeList.getLength(); i++) {
            Element item = (Element) caseFileNameNodeList.item(i);
            map.put(item.getTextContent(), item.getAttribute("path").replaceAll("%env%",env));
        }
        return map;
    }
}

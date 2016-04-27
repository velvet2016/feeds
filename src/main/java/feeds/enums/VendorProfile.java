package feeds.enums;

/**
 * Created by linux on 27.04.16.
 */
public enum VendorProfile {
    BBG("vendorProperties/bbg.xml"),
    TR("vendorProperties/tr.xml");


    VendorProfile(String xmlPropertyFile) {
        this.xmlPropertyFile = xmlPropertyFile;
    }

    private String xmlPropertyFile;

    public String getXmlPropertyFileName() {
        return xmlPropertyFile;
    }
}

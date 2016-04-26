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

    private static Properties getProperties(String fileName) {
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

    public static VendorInfo getVendorInfoFromPropertyFile(String fileName) {
        VendorInfo vendorInfo = new VendorInfo();

        Properties prop = getProperties(fileName);

        vendorInfo.setStaticDataCode(prop.getProperty("staticDataCode"));
        vendorInfo.setName(prop.getProperty("alacra.name"));
        vendorInfo.setUnixPath1(prop.getProperty("unixPath1"));
        vendorInfo.setUnixPath2(prop.getProperty("unixPath2"));
        vendorInfo.setUnixPath3(prop.getProperty("unixPath3"));
        return vendorInfo;
    }

    public static VendorInfo getVendorInfoFromPropertyFile(Profile vendor) {
       return getVendorInfoFromPropertyFile(vendor.getPropertyFileName());
    }

    public static void getCommonConfig(){
        Properties properties = getProperties("common.properties");
        logger.info(properties.toString());
    }



}

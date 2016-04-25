package t1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


/**
 * Created by linux on 23.04.16.
 */
public class PropertyReader {

    private static Logger logger= LogManager.getLogger(PropertyReader.class.getName());
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
    public static List<RunInfo> getSuiteConfig(){
        List<RunInfo> runInfos = new ArrayList<RunInfo>();
        Properties properties = getProperties("suites/suite.properties");
        String runSequence = properties.getProperty("runSequence");
        String[] typeAndCaseFileArray = runSequence.split(";");
        for (String typeAndCaseFile : typeAndCaseFileArray) {
            String[] item = typeAndCaseFile.split(":");
            String tag = item[0];
            String className = item[1];
            String caseFileName = item[2];
            List<String> casesFileNames = Arrays.asList(caseFileName.split(","));
            runInfos.add(new RunInfo(className, casesFileNames, tag));
        }
        return runInfos;
    }


}

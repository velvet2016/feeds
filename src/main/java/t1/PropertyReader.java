package t1;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by linux on 23.04.16.
 */
public class PropertyReader {
    private static Properties getProperties(String fileName) {
        Properties prop = new Properties();

        try(InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream(fileName)){
            if(input==null){
                throw new IOException();
            }
            prop.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("can not read property file:" + fileName);
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
        System.out.println(properties);
    }
    public static List<RunInfo> getSuiteConfig(){
        List<RunInfo> runInfos = new ArrayList<RunInfo>();
        Properties properties = getProperties("bbgFullSuite/suite.properties");
        String runSequence = properties.getProperty("runSequence");
        String[] typeAndCaseFileArray = runSequence.split(";");
        for (String typeAndCaseFile : typeAndCaseFileArray) {
            String[] item = typeAndCaseFile.split(":");
            String className = item[0];
            String caseFileName = item[1];
            runInfos.add(new RunInfo(className, caseFileName));
        }
        return runInfos;
    }


}

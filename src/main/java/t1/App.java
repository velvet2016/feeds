package t1;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        VendorInfo vendorInfo = PropertyReader.getVendorInfoFromPropertyFile(Profile.BBG);

        System.out.println(vendorInfo);

        PropertyReader.getCommonConfig();
        File file = new TextReader().getFile("tr.properties");
        System.out.println(file);


    }
}

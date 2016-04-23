package t1;

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



    }
}

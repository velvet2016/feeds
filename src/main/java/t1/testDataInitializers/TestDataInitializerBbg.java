package t1.testDataInitializers;

import t1.LoggedClass;
import t1.TestDataEntry;
import t1.VendorData;
import t1.interfaces.TestDataInitializerInterface;

import java.io.File;
import java.util.List;

/**
 * Created by linux on 24.04.16.
 */
public  class TestDataInitializerBbg extends TestDataInitializer {
    @Override
    public VendorData getVendorData(File file) {
        logger.info("get Vendor Data for BBG...");
        return null;
    }


}

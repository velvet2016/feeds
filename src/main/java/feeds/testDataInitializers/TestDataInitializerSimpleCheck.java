package feeds.testDataInitializers;

import feeds.VendorData;

import java.util.Map;

/**
 * Created by linux on 24.04.16.
 */
public  class TestDataInitializerSimpleCheck extends TestDataInitializer {
    @Override
    public Map<String,VendorData> getVendorData(Map<String, String> typeToFileMap) {
        logger.info("get Vendor Data for SimpleCheck...");
        return null;
    }


}

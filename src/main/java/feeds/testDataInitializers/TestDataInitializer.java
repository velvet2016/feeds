package feeds.testDataInitializers;

import feeds.LoggedClass;
import feeds.TestDataEntry;
import feeds.VendorData;
import feeds.interfaces.TestDataInitializerInterface;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by linux on 24.04.16.
 */
public abstract class TestDataInitializer extends LoggedClass implements TestDataInitializerInterface {
    @Override
    public Map<String,VendorData> getVendorData(Map<String, String> typeToFileMap) {
        return null;
    }

    @Override
    public List<TestDataEntry> getExpectedData(File file) {
        logger.info("getting Expected Data...");
        return null;
    }
}

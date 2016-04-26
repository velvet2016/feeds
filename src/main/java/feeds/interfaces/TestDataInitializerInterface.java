package feeds.interfaces;

import feeds.TestDataEntry;
import feeds.VendorData;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by linux on 24.04.16.
 */
public interface TestDataInitializerInterface {
    public Map<String, VendorData> getVendorData(Map<String, String> typeToFileMap);
    public List<TestDataEntry> getExpectedData(File file);
}

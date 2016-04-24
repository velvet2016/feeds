package t1.interfaces;

import t1.TestDataEntry;
import t1.VendorData;

import java.io.File;
import java.util.List;

/**
 * Created by linux on 24.04.16.
 */
public interface TestDataInitializerInterface {
    public VendorData getVendorData(File file);
    public List<TestDataEntry> getExpectedData(File file);
}

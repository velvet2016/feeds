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
public abstract class TestDataInitializer extends LoggedClass implements TestDataInitializerInterface {
    @Override
    public VendorData getVendorData(File file) {
        return null;
    }

    @Override
    public List<TestDataEntry> getExpectedData(File file) {
        return null;
    }
}

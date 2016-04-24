package t1.interfaces;

import t1.DataProviderInput;
import t1.TestDataEntry;
import t1.VendorInfo;

import java.io.File;
import java.util.List;

/**
 * Created by linux on 23.04.16.
 */
public interface SimpleCheckerTestInterface  {
    public List<DataProviderInput> getDataForDataProvider(List<TestDataEntry> exp, List<TestDataEntry> act);
    public List<String> getVendorIds(List<TestDataEntry> testData, VendorInfo vendorInfo);
}
